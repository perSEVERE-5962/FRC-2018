package org.usfirst.frc.team5962.robot.commands;

import org.usfirst.frc.team5962.robot.Robot;
import org.usfirst.frc.team5962.robot.RobotMap;
// import org.usfirst.frc.team5962.robot.sensors.RobotGyro;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Throttle extends Command{
	boolean isFinished = false;
	boolean isThrottleEnabled = false;
	public Throttle() {
		   requires(Robot.drive);
		   
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		isFinished = false;
		   Robot.oi.toggleThrottle();
		   isThrottleEnabled = Robot.oi.isThrottleEnabled();
	}

	// Called repeatedly when this Command is scheduled to run
	public void execute() {

		if (isThrottleEnabled) {
			RobotMap.myRobot.setMaxOutput(0.25);
		} else {
			RobotMap.myRobot.setMaxOutput(0.5);
		}
		isFinished = true;
		Robot.oi.startDriveCommand();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isFinished;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
	
}

