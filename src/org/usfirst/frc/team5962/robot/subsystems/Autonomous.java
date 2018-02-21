package org.usfirst.frc.team5962.robot.subsystems;

import org.usfirst.frc.team5962.robot.Robot;
import org.usfirst.frc.team5962.robot.RobotMap;
import org.usfirst.frc.team5962.robot.subsystems.FmsDataRetrieval.PlatesLocation;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Autonomous extends Subsystem {
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
	
	//Variable for the position of the switches
	public static FmsDataRetrieval fmsDataRetrieval = new FmsDataRetrieval();
	
	//All Constant variables
	private final double DISTANCETOLINE = 80.625;
	private final double DISTANCEPASTSWITCH = 105;
	private final double DISTANCEACROSSSWITCH = 149;
	
	public PIDDriveOutput pidDriveOutput;
	public PIDDriveSource pidDriveSource;
	public PIDController pidDriveController;
	
	public PIDTurningDriveOutput pidTurningDriveOutput;
	public PIDTurningDriveSource pidTurningDriveSource;
	public PIDController pidTurningDriveController;
	
	//Enum for what action the bot is doing at the moment
	public static enum CurrentState{
		
		crossLineStraight,
		crossLineDiagonal,
		crossLineFromMiddle,
		
		drivePastSwitch,
		driveAcrossSwitch,
		driveHalfwayPastSwitch,
		moveForwardToSwitch,
		
		driveBackwards,
		driveBackwardsSlightly,
		
		intoExchange,
		intoSwitch,
		pickUpBlock,
		
		turn180,
		turn90Left,
		turn90Right,
		turnADegree,
		backToForward,
		
		nothing
		
	}
	
	//Variables for the switch case
	private CurrentState currentState;
	private PlatesLocation platesLocation;
	
	//Variables for default state of the robot in Autonomouse
	private Robot.Location location = Robot.Location.farRight;
	private Robot.Action action = Robot.Action.nothing;
			
	//Variable for stopwatch
	private long end;
	
	//Variable for what step the action is on
	int steps = 0;
	int substeps = 0;
	
	//Variable on whether the switch ownership is left or right
	int leftRightValue;
	
	//Variable for on Target
	boolean onTarget = false;
	double onTargetFirstTime = 0;
	double onTargetCurrentTime = 0;

	boolean actionStarted = false;

	//Called from Run Autonomous and sets up the timer and switch ownership
	public void init()
	{
		//initialize PID
		pidDriveOutput = new PIDDriveOutput();
		pidDriveSource = new PIDDriveSource();
		pidTurningDriveOutput = new PIDTurningDriveOutput();
		pidTurningDriveSource = new PIDTurningDriveSource();
		double Kp = SmartDashboard.getNumber("P Value:", 0);
		double Ki = SmartDashboard.getNumber("I Value:", 0);
		double Kd = SmartDashboard.getNumber("D Value:", 0);
		double Tp = SmartDashboard.getNumber("P t Value:", 0);
		double Ti = SmartDashboard.getNumber("I t Value:", 0);
		double Td = SmartDashboard.getNumber("D t Value:", 0);
		pidDriveController = new PIDController(Kp,Ki,Kd,pidDriveSource,pidDriveOutput);
		pidTurningDriveController = new PIDController(Tp, Ti, Td, pidTurningDriveSource, pidTurningDriveOutput);
		//pidDriveController.setPID(1,  0,  0);
		pidDriveController.disable();
		pidTurningDriveController.disable();
		
		//Set up for state cases
		platesLocation = fmsDataRetrieval.fieldDataRetrieval();
				
		//Sets up the start timer
		end = System.currentTimeMillis() + 16000;
		
		//Variable for the whether there should be right or left decisions
		//Left will be 1
		//Right will be -1
		int leftRightValue;
		if (platesLocation == FmsDataRetrieval.PlatesLocation.leftSwitchOwnership)
		{
			leftRightValue = 1;
		} else if (platesLocation == FmsDataRetrieval.PlatesLocation.rightSwitchOwnership){
			
			leftRightValue = -1;
		} else {
			leftRightValue = 0;
		}
		

	}
	
	//Sets up the bot's situation on the field and desired outcome
	public void initializeStateOfBot(Robot.Location location,
									 Robot.Action action){
		
		this.location = location;
		this.action = action;
		
	}
	
	//Displays timer for the autonomous
	public void elapsedTime() {
        long now = System.currentTimeMillis();
        long elapsedTime =  (long) ((end - now) / 1000.0);
        SmartDashboard.putNumber("Time", elapsedTime);
    }
	
	//Runs the code we use for autonomous
	public void locationOnField()
	{
		switch (location){
		case farRight:
			//Crosses the line
			if (steps == 0 && (action == Robot.Action.crossLine ||
							   action == Robot.Action.switch1)){
				
				currentState = CurrentState.crossLineStraight;
			
			//Moves directly to switch after crossing the line
			} else if (leftRightValue == -1 && steps == 1 && action == Robot.Action.switch1) {
				turnToSwitch();
				
			//Moves along the backside of the switch to drop the cube
			} else if (leftRightValue == 1 && steps == 1 && action == Robot.Action.switch1) {
				aroundSwitch();
				
			} 
			else {
				DriverStation.reportWarning("GANESH LOOK HERE" , false);
				currentState = CurrentState.nothing;
			}
			break;
			
		case switchRight:
			//Goes straight if switch is owned on the right side
			if (leftRightValue == -1 && steps == 0 && (action == Robot.Action.crossLine ||
			   				   						   action == Robot.Action.switch1)){
				currentState = CurrentState.crossLineStraight;
				
			} else if (leftRightValue == -1 && steps == 1 && action == Robot.Action.switch1) {
				straightToSwitch();
				
			//Turns if the switch is owned on the left side
			} else if (leftRightValue == 1 && steps == 0 && (action == Robot.Action.crossLine ||
						  									 action == Robot.Action.switch1)) {
				currentState = CurrentState.crossLineDiagonal;
				
			} else if (leftRightValue == 1 && steps == 1 && action == Robot.Action.switch1) {
				aroundSwitch();
			} else
				currentState = CurrentState.nothing;
			
			break;
			
		case middle:
			if (steps == 0 && (action == Robot.Action.crossLine ||
				   			   action == Robot.Action.switch1)) {
				currentState = CurrentState.crossLineFromMiddle;
			} else if(steps == 1 && (action == Robot.Action.switch1)) {
				straightToSwitch();
			}  else
				currentState = CurrentState.nothing;
			
			break;
		case vault:
			if (steps == 0 && (action == Robot.Action.exchange ||
							   action == Robot.Action.crossLine)) {
				intoVault();
			} else if(steps == 1 && action == Robot.Action.crossLine) {
				crossLineAfterVault();
			}
			break;
			
		case switchLeft:
			
			//Goes straight if switch is owned on the left side
			if (leftRightValue == 1 && steps == 0 && (action == Robot.Action.crossLine ||
			   				   						   action == Robot.Action.switch1)){
				currentState = CurrentState.crossLineStraight;
				
			} else if (leftRightValue == 1 && steps == 1 && action == Robot.Action.switch1) {
				straightToSwitch();
				
			//Turns if the switch is owned on the left side
			} else if (leftRightValue == -1 && steps == 0 && (action == Robot.Action.crossLine ||
						  									 action == Robot.Action.switch1)) {
				currentState = CurrentState.crossLineDiagonal;
				
			} else if (leftRightValue == -1 && steps == 1 && action == Robot.Action.switch1) {
				aroundSwitch();
			} else
				currentState = CurrentState.nothing;
			break;
			
		case farLeft:	
			
			//Crosses the Line
			if (steps == 0 && (action == Robot.Action.crossLine ||
			   action == Robot.Action.switch1)){

				currentState = CurrentState.crossLineStraight;

			//Moves directly to switch after crossing the line
			} else if (leftRightValue == 1 && steps == 1 && action == Robot.Action.switch1) {
				turnToSwitch();

			//Moves along the backside of the switch to drop the cube
			} else if (leftRightValue == -1 && steps == 1 && action == Robot.Action.switch1) {
				aroundSwitch();

			} else {
				currentState = CurrentState.nothing;
			}
			break;
			
		default:
			break;
			
	  }
	}
		
		
		//Moves to the switch if it is on the same side
		public void turnToSwitch() {
			  
			  if (substeps == 0) {
				  currentState = CurrentState.backToForward;
				  
			  } else if (substeps == 1) {
					currentState = CurrentState.driveHalfwayPastSwitch;
				
				//Turns based on which switch we own
			  } else if(substeps == 2) {
				  if (leftRightValue == -1) {
					  currentState = CurrentState.turn90Left;
				  }
				  else if(leftRightValue == 1) {
					  currentState = CurrentState.turn90Right;
				  }
					  
				
			  } else if (substeps == 3) {
				  currentState = CurrentState.moveForwardToSwitch;
		      }else if(substeps == 4) {
		    	  currentState = CurrentState.intoSwitch;
			  } else {
				  substeps = 0;
				  steps++;
			  }
		}
		
		//Moves behind the switch to drop the cube
		public void aroundSwitch() {
			
			if (substeps == 0) {
				currentState = CurrentState.backToForward;
			}
			if (substeps == 1) {
				currentState = CurrentState.drivePastSwitch;
				
				//Turns based on which switch we own
			}else if ( substeps == 2){
				if (leftRightValue == 1) {
					currentState = CurrentState.turn90Left;
				}else if (leftRightValue == -1) {
					currentState = CurrentState.turn90Right;
				}
				
			} else if (substeps == 3){
				currentState = CurrentState.driveAcrossSwitch;
				
				//Turns based on which switch we own
			} else if (substeps == 4) {
				if (leftRightValue == 1) {
					currentState = CurrentState.turn90Left;
				}else if (leftRightValue == -1) {
					currentState = CurrentState.turn90Right;
				}
				
			} else if (substeps == 5) {
				currentState = CurrentState.moveForwardToSwitch;
			} else if (substeps == 6) {
				currentState = CurrentState.intoSwitch;
			} else {
				substeps = 0;
				steps++;
			}
		}
		
		//Moves forward to place the cube into the switch
		public void straightToSwitch() {
			
			if (substeps == 0) {
				currentState = CurrentState.backToForward;
			} else if (substeps == 1) {
				currentState = CurrentState.moveForwardToSwitch;
			} else if(substeps == 2) {
				currentState = CurrentState.intoSwitch;
			} else {
				substeps = 0;
				steps++;
			}
		}
		
		//Place the box into the vault
		public void intoVault() {
			if (substeps == 0) {
				currentState = CurrentState.intoExchange;
			} else {
				substeps = 0;
				steps++;
			}
		}
		
		//Moves to the switch after placing the block
		public void crossLineAfterVault() {
			if (substeps == 0) {
				currentState = CurrentState.driveBackwards;
			} else if (substeps == 1) {
				currentState = CurrentState.turn180;
			} else if (substeps == 2) {
				currentState = CurrentState.moveForwardToSwitch;
			} else {
				substeps = 0;
				steps++;
			}
		}
		
		//All the small actions will do depending on what current state the bot is in (changed in methods)
		//Only the cross the line actions should add 1 to steps. The rest should increment subsystems by 1
		public void actionOnField(){
			
			switch (currentState){
				case nothing:
					//pidTurningDriveController.disable();
					//pidDriveController.disable();
					RobotMap.myRobot.tankDrive(0, 0);
					DriverStation.reportWarning("YOU ARE HEREDEAEFEAFEFSEFSEFSEF", true);
					break;
						
				case crossLineStraight:
//					if (Robot.encoder.getDistance() < 20) { 
//						RobotMap.myRobot.tankDrive(-.5, -.5);
//						DriverStation.reportError("YOU ARE HERE", true);
//					} else {
//						steps++;
//					}
					
					//RobotMap.myRobot.setMaxOutput(0.5);
					
					if (!actionStarted) {
						//DriverStation.reportWarning("YOU ARE HERE", true);
						pidTurningDriveController.disable();
						pidDriveController.disable();
						//Robot.robotGyro.resetGyro();
						//Robot.encoder.reset();
						double Kp = SmartDashboard.getNumber("P Value:", 0.15);
						double Ki = SmartDashboard.getNumber("I Value:", 0);
						double Kd = SmartDashboard.getNumber("D Value:", 0);
						pidDriveController.setPID(Kp, Ki, Kd);
						pidDriveController.setOutputRange(-0.5,0.5);
						pidDriveController.setInputRange(0, 98);
						pidDriveController.setSetpoint(96);
						pidDriveController.setPercentTolerance(1);
						pidDriveController.enable();
						actionStarted = true;
					
					} else if (pidDriveController.onTarget()) { //&&
							   //RobotMap.robotLeftVictor1.getSpeed() == 0 &&
							   //RobotMap.robotRightVictor1.getSpeed() == 0) {
						DriverStation.reportWarning("YOU ARE ON TARGET", true);
						actionStarted = false;
						steps++;
					}
						
					break;
						
				case crossLineDiagonal:
					steps++;
					break;
						
				case crossLineFromMiddle:
					steps++;
					break;
						
				case drivePastSwitch:
					if (!actionStarted) {
						//DriverStation.reportWarning("YOU ARE HERE", true);
						pidTurningDriveController.disable();
						//pidDriveController.disable();
						//Robot.encoder.reset();
						Robot.robotGyro.resetGyro();
						pidDriveController.setOutputRange(-0.5,0.5);
						pidDriveController.setInputRange(0,160);
						pidDriveController.setSetpoint(144.5);
						pidDriveController.setPercentTolerance(1);
						pidDriveController.enable();
						actionStarted = true;
					} else if (pidDriveController.onTarget()) {
						DriverStation.reportWarning("YOU ARE ON TARGET", true);
						actionStarted = false;
						substeps++;
					}
					break;
						
				case driveAcrossSwitch:
					if (!actionStarted) {
						//DriverStation.reportWarning("YOU ARE HERE", true);
						pidTurningDriveController.disable();
						pidDriveController.disable();
						Robot.encoder.reset();
						//Robot.robotGyro.resetGyro();
						pidDriveController.setOutputRange(-0.5, 0.5);
						pidDriveController.setInputRange(0,200);
						pidDriveController.setSetpoint(171.625);
						pidDriveController.setPercentTolerance(1);
						pidDriveController.enable();
						actionStarted = true;
					} else if (pidDriveController.onTarget()) {
						DriverStation.reportWarning("YOU ARE ON TARGET", true);
						actionStarted = false;
						substeps++;
					}
					break;
					
				case driveHalfwayPastSwitch:
					if (!actionStarted) {
						//DriverStation.reportWarning("YOU ARE HERE", true);
						pidTurningDriveController.disable();
						pidDriveController.disable();
						//Robot.robotGyro.resetGyro();
						Robot.encoder.reset();
						pidDriveController.setOutputRange(-0.5, 0.5);
						pidDriveController.setInputRange(0,80);
						pidDriveController.setSetpoint(76);
						pidDriveController.setPercentTolerance(1);
						pidDriveController.enable();
						actionStarted = true;
					} else if (pidDriveController.onTarget()) {
						DriverStation.reportWarning("YOU ARE ON TARGET", true);
						actionStarted = false;
						substeps++;
					}
					
					break;
						
				case moveForwardToSwitch:
					substeps++;
					break;
						
				case driveBackwards:
					if (!actionStarted) {
						//DriverStation.reportWarning("YOU ARE HERE", true);
						pidTurningDriveController.disable();
						pidDriveController.disable();
						//Robot.robotGyro.resetGyro();
						Robot.encoder.reset();
						pidDriveController.setOutputRange(-0.5, 0.5);
						pidDriveController.setInputRange(-120,0);
						pidDriveController.setSetpoint(-100);
						pidDriveController.setPercentTolerance(1);
						pidDriveController.enable();
						actionStarted = true;
					
					} else if (pidDriveController.onTarget() && !onTarget) {
						
						onTarget = true;
						
					} else if (pidDriveController.onTarget()) {
						DriverStation.reportWarning("YOU ARE ON TARGET", true);
						actionStarted = false;
						substeps++;
					}
					break;
					
				case driveBackwardsSlightly:
					if (!actionStarted) {
						//DriverStation.reportWarning("YOU ARE HERE", true);
						pidTurningDriveController.disable();
						pidDriveController.disable();
						//Robot.robotGyro.resetGyro();
						Robot.encoder.reset();
						pidDriveController.setOutputRange(-0.5, 0.5);
						pidDriveController.setInputRange(-30,0);
						pidDriveController.setSetpoint(-17);
						pidDriveController.setPercentTolerance(1);
						pidDriveController.enable();
						actionStarted = true;
					} else if (pidDriveController.onTarget()) {
						DriverStation.reportWarning("YOU ARE ON TARGET", true);
						actionStarted = false;
						substeps++;
					}
					break;
					
				case intoExchange:
					substeps++;
					break;
						
				case intoSwitch:
					substeps++;
					break;
						
				case pickUpBlock:
					substeps++;
					break;
						
				case turn180:
					if (!actionStarted) {
						//DriverStation.reportWarning("YOU ARE HERE", true);
						pidTurningDriveController.disable();
						pidDriveController.disable();
						//Robot.robotGyro.resetGyro();
						Robot.encoder.reset();
						pidTurningDriveController.setOutputRange(-0.5, 0.5);
						pidTurningDriveController.setInputRange(-360, 360);
						pidTurningDriveController.setSetpoint(180);
						pidTurningDriveController.setPercentTolerance(1);
						pidTurningDriveController.enable();
						actionStarted = true;
					} else if (pidDriveController.onTarget()) {
						DriverStation.reportWarning("YOU ARE ON TARGET", true);
						actionStarted = false;
						Robot.robotGyro.resetGyro();
						substeps++;
					}
					break;
						
				case turn90Left:
					if (!actionStarted) {
						//DriverStation.reportWarning("YOU ARE HERE", true);
						pidTurningDriveController.disable();
						pidDriveController.disable();
						//Robot.robotGyro.resetGyro();
						Robot.encoder.reset();
						pidTurningDriveController.setOutputRange(-0.5, 0.5);
						pidTurningDriveController.setInputRange(-360, 360);
						pidTurningDriveController.setSetpoint(-90);
						pidTurningDriveController.setPercentTolerance(1);
						pidTurningDriveController.enable();
						actionStarted = true;
					} else if (pidDriveController.onTarget()) {
						DriverStation.reportWarning("YOU ARE ON TARGET", true);
						actionStarted = false;
						Robot.robotGyro.resetGyro();
						substeps++;
					}
					break;
						
				case turn90Right:
					if (!actionStarted) {
						//DriverStation.reportWarning("YOU ARE HERE", true);
						pidTurningDriveController.disable();
						pidDriveController.disable();
						//Robot.robotGyro.resetGyro();
						Robot.encoder.reset();
						pidTurningDriveController.setOutputRange(-0.5, 0.5);
						pidTurningDriveController.setInputRange(-360, 360);
						pidTurningDriveController.setSetpoint(90);
						pidTurningDriveController.setPercentTolerance(1);
						pidTurningDriveController.enable();
						actionStarted = true;
					} else if (pidDriveController.onTarget()) {
						DriverStation.reportWarning("YOU ARE ON TARGET TURNING", true);
						actionStarted = false;
						Robot.robotGyro.resetGyro();
						substeps++;
					}
					break;
					
				case turnADegree:
					if (!actionStarted) {
						//DriverStation.reportWarning("YOU ARE HERE", true);
						pidTurningDriveController.disable();
						pidDriveController.disable();
						//Robot.robotGyro.resetGyro();
						Robot.encoder.reset();
						pidTurningDriveController.setOutputRange(-0.5, 0.5);
						pidTurningDriveController.setInputRange(-360, 360);
						if (location == Robot.Location.switchLeft ||
							location == Robot.Location.switchRight) {
							
							pidTurningDriveController.setSetpoint(leftRightValue * 29.5433);
						} else if (location == Robot.Location.middle) {
							
							pidTurningDriveController.setSetpoint(-1 * leftRightValue * 36.1225);
						}
						pidTurningDriveController.setPercentTolerance(1);
						pidTurningDriveController.enable();
						actionStarted = true;
					} else if (pidDriveController.onTarget()) {
						DriverStation.reportWarning("YOU ARE ON TARGET TURNING", true);
						actionStarted = false;
						Robot.robotGyro.resetGyro();
						substeps++;
					}
						
				case backToForward:
					if (!actionStarted) {
						//DriverStation.reportWarning("YOU ARE HERE", true);
						pidTurningDriveController.disable();
						pidDriveController.disable();
						//Robot.robotGyro.resetGyro();
						Robot.encoder.reset();
						pidTurningDriveController.setOutputRange(-0.5, 0.5);
						pidTurningDriveController.setInputRange(-360, 360);
						pidTurningDriveController.setSetpoint(0);
						pidTurningDriveController.setPercentTolerance(1);
						pidTurningDriveController.enable();
						actionStarted = true;
					} else if (pidDriveController.onTarget()) {
						DriverStation.reportWarning("YOU ARE ON TARGET TURNING", true);
						actionStarted = false;
						Robot.robotGyro.resetGyro();
						substeps++;
					}
					break;
						
				default:
					RobotMap.myRobot.tankDrive(0, 0);
					break;
						
				}
					
			}
	}