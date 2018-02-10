package org.usfirst.frc.team5962.robot.commands;

import org.usfirst.frc.team5962.robot.Robot;
import org.usfirst.frc.team5962.robot.Robot.Action;
import org.usfirst.frc.team5962.robot.Robot.Location;
import org.usfirst.frc.team5962.robot.RobotMap;
import org.usfirst.frc.team5962.robot.subsystems.Autonomous;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RunAutonomous extends Command {

	private boolean isFinished = false;
	private boolean targetReached = false;
	private Autonomous autonomousSubsystem = new Autonomous();
	
//	double P = 1;
//	double I = 0;
//	double D = 0;

	//Constructor for Run Autonomous
	public RunAutonomous(Robot.Location location, Robot.Action action) {
		
		//Initializes our position and action we want to accomplish in Autonomous
		autonomousSubsystem.initializeStateOfBot(location, action);
	}
	

	//Initializes the timer, switch location
	protected void initialize(){
		
		//Robot.drive.pidDriveController.enable();
		//Robot.drive.pidDriveController.setPID(P, I, D);
//	SmartDashboard.putNumber("P Value:", P);
//	SmartDashboard.putNumber("I Value:", I);
//	SmartDashboard.putNumber("D Value:", D);
		autonomousSubsystem.init();
		
		
	}

	//Runs until we reach our end goal
	protected void execute() 
	{	
//		SmartDashboard.putNumber("P Value:", P);
//		SmartDashboard.putNumber("I Value:", I);
//		SmartDashboard.putNumber("D Value:", D);
		autonomousSubsystem.elapsedTime();
		autonomousSubsystem.locationOnField();
		autonomousSubsystem.actionOnField();
		
		//if (isFinished || targetReached)
		//{
		//	RobotMap.myRobot.tankDrive(0, 0);
			
		//} else if(!targetReached) {
		//	autonomousSubsystem.locationOnField();
			
		//} else {
		//	RobotMap.myRobot.tankDrive(0, 0);
		//}
		
	}

	@Override
	protected boolean isFinished()
	{
		// TODO Auto-generated method stub
		return false;
	}
}