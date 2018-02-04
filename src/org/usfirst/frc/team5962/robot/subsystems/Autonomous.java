package org.usfirst.frc.team5962.robot.subsystems;

import org.usfirst.frc.team5962.robot.RobotMap;
import org.usfirst.frc.team5962.robot.subsystems.FmsDataRetrieval.PlatesLocation;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Autonomous extends Subsystem {
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
	
	public static FmsDataRetrieval fmsDataRetrieval = new FmsDataRetrieval();
	
	public static enum Location {
		
		farRight,
		switchRight,
		middle,
		vault,
		switchLeft,
		farLeft
		
	}
	
	public static enum Action {
		
		nothing,
		crossLine,
		exchange,
		switch1,
		switch2,
		scale,
		
		pickUpBlock,
		placeBlock,
		
		aroundSwitch,
		
		stop
	}
	
	//Variables for the switch case
	private Location situation;
	private Action action;
	private PlatesLocation platesLocation;
			
	//Variable for stopwatch
	private long end;
	
	//Variables for Shuffleboard
	SendableChooser<Location> position;
	SendableChooser<Action> state;
	
	public void init()
	{
		//Sets up the start timer
		end = System.currentTimeMillis() + 16000;
		
		int leftRightValue;
		
		if (platesLocation == FmsDataRetrieval.PlatesLocation.leftSwitchOwnership)
		{
			leftRightValue = 1;
		} else if (platesLocation == FmsDataRetrieval.PlatesLocation.rightSwitchOwnership){
			
			leftRightValue = -1;
		} else {
			leftRightValue = 0;
		}
		
		//Set up for state cases
		situation = Location.farRight;
		action = Action.nothing;
		platesLocation = fmsDataRetrieval.fieldDataRetrieval();
		
		//Setting up options for location
		position = new SendableChooser<Location>();
		position.addDefault("Far Right", Location.farRight);
		position.addObject("Right side of Switch", Location.switchRight);
		position.addObject("Middle", Location.middle);
		position.addObject("In front of Vault", Location.vault);
		position.addObject("Left side of Switch", Location.switchLeft);
		position.addObject("Far Left", Location.farLeft);
		SmartDashboard.putData("Location of robot", position);
		
		//Setting up options for actions in autonomous
		state = new SendableChooser<Action>();
		state.addDefault("Nothing", Action.nothing);
		state.addObject("Cross the Line", Action.crossLine);
		state.addObject("Exchange", Action.exchange);
		state.addObject("One Switch", Action.switch1);
		//state.addObject("Two Switches", Action.switch2);
		//state.addObject("Scale", Action.scale);
		SmartDashboard.putData("Action for Auto", state);
	}
	
	public void elapsedTime() {
        long now = System.currentTimeMillis();
        long elapsedTime =  (long) ((end - now) / 1000.0);
        SmartDashboard.putNumber("Time", elapsedTime);
    }
	
	public void locationOnField()
	{
		switch (situation){
		case farRight:
			
			
		case switchRight:
		
		case middle:
			
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
			switch (action){
			case nothing:
				RobotMap.myRobot.tankDrive(0, 0);
				break;
				
			case crossLine:
				break;
				
			case exchange:
				break;
				
			case switch1:
				break;
				
			case switch2:
				break;
				
			case scale:
				break;
				
			case pickUpBlock:
				break;
				
			case stop:
				RobotMap.myRobot.tankDrive(0, 0);
				break;
				
			default:
				RobotMap.myRobot.tankDrive(0, 0);
				break;
				
			}
			
		}
		
	}