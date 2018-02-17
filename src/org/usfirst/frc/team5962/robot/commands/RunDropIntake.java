package org.usfirst.frc.team5962.robot.commands;

import org.usfirst.frc.team5962.robot.Robot;
import org.usfirst.frc.team5962.robot.subsystems.DropIntake;
import org.usfirst.frc.team5962.robot.subsystems.PIDDropIntakeSubsystem;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
public class RunDropIntake extends Command{

	PIDDropIntakeSubsystem pidDropIntakeSubsystem;
	
	// Called just before this Command runs the first time
    protected void initialize() {
    	
    	pidDropIntakeSubsystem = new PIDDropIntakeSubsystem(.3, 0, .3);
    	pidDropIntakeSubsystem.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//pidDropIntakeSubsystem.enable();
    	//DropIntake.dropIntake();
    	//DropIntake.checkParallel();
    	if (Robot.oi.xBoxRightAxis() < 0)
    	{
    		pidDropIntakeSubsystem.setSetPoint(0);
    	}
    	else if (Robot.oi.xBoxRightAxis() > 0) {
    		pidDropIntakeSubsystem.setSetPoint(-16);
    	}
    	    	
    	//pidDropIntakeSubsystem.enable();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {

    	if (pidDropIntakeSubsystem.ifOnTarget())
    	{
    		pidDropIntakeSubsystem.disable();
    	}
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
