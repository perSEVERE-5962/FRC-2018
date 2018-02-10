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

	//Enum for what action the bot is doing at the moment
	public static enum CurrentState{
		
		crossLine,
		aroundSwitch,
		exchange,
		intoSwitch,
		pickUpBlock,
		nothing
		
	}
	
	//Variables for the switch case
	private CurrentState currentState;
	private PlatesLocation platesLocation;
	
	//Variables for default state of the bot in Autonomous
	private Robot.Location location = Robot.Location.farRight;
	private Robot.Action action = Robot.Action.nothing;
			
	//Variable for stopwatch
	private long end;
	
	//Variable for what step the action is on
	int steps = 0;
	
	//Variable on whether the switch ownership is left or right
	int leftRightValue;

	boolean actionStarted = false;

	//Called from Run Autonomous and sets up the timer and switch ownership
	public void init()
	{
		//initialize PID
		pidDriveOutput = new PIDDriveOutput();
		pidDriveSource = new PIDDriveSource();
		double Kp = SmartDashboard.getNumber("P Value:", 0);
		double Ki = SmartDashboard.getNumber("I Value:", 0);
		double Kd = SmartDashboard.getNumber("D Value:", 0);
		pidDriveController = new PIDController(Kp,Ki,Kd,pidDriveSource,pidDriveOutput);
		//pidDriveController.setPID(1,  0,  0);
		pidDriveController.disable();
		
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
			if (steps == 0 && action == Robot.Action.crossLine){
				currentState = CurrentState.crossLine;
			} else if (leftRightValue == 1 && steps == 1 && action == Robot.Action.switch1) {
				currentState = CurrentState.aroundSwitch;
			}
			else {
				currentState = CurrentState.nothing;
			}
			
			break;
		case switchRight:
		
			break;
		case middle:
			
			break;
		case vault:
			
			break;
			
		case switchLeft:
			
			break;
			
		case farLeft:	
			
			break;
			
		default:
			break;
			
	}
	}
	
		
		public void actionOnField()
		{
			switch (currentState){
			case nothing:
				RobotMap.myRobot.tankDrive(0, 0);
//				pidDriveController.enable();
				break;
				
			case crossLine:
					DriverStation.reportError("YOU ARE HERE", true);
					if (!actionStarted) {
						pidDriveController.setSetpoint(24);
						pidDriveController.enable();
						actionStarted = true;
					} else {
						// if done, then 
						//     1) actionStarted = false; 
						//     2) steps++;
						//     3) pidDriveController.disable();
						// else do nothing
					}
					
//				if (Robot.encoder.getDistance() < DISTANCETOLINE) {
//					RobotMap.myRobot.tankDrive(-1, -1);
//				} else {
//					steps++;
//				}
				
				break;
				
			case aroundSwitch:
				steps++;
				
			case exchange:
				steps++;
				break;
				
			default:
				RobotMap.myRobot.tankDrive(0, 0);
				break;
				
			}
			
		}
		
	}