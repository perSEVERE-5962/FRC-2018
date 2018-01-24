package org.usfirst.frc.team5962.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Autonomous extends Subsystem {

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
	
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
		
		stop
	}
	
	//Variables for the switch case
	private Location situation;
	private Action action;
	
	//Variables for Shuffleboard
	SendableChooser<Location> position;
	SendableChooser<Action> state;
	
	public void init()
	{
		//Set up for state cases
		situation = Location.farRight;
		action = Action.nothing;
		
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
		state.addObject("Two Switches", Action.switch2);
		//state.addObject("Scale", Action.scale);
		SmartDashboard.putData("Action for Auto", state);
	}
	
}