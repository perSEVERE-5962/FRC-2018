package org.usfirst.frc.team5962.robot.commands;

import org.usfirst.frc.team5962.robot.Robot;
import org.usfirst.frc.team5962.robot.subsystems.PIDClimberSubsystem;
import org.usfirst.frc.team5962.robot.subsystems.PIDDropIntakeSubsystem;
import org.usfirst.frc.team5962.robot.subsystems.Climber;

import edu.wpi.first.wpilibj.command.Command;
public class RunClimber extends Command{

	PIDClimberSubsystem pidClimberSubsystem;
	
	// Called just before this Command runs the first time
    protected void initialize() {

    	//pidClimberSubsystem = new PIDClimberSubsystem(.3, 0, .3);
    	//pidClimberSubsystem.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if (Robot.oi.xBoxLeftTrigger() > 0)
    	{
    		Climber.climbUp();
    	//	pidClimberSubsystem.setSetPoint(60);
    	} else if (Robot.oi.xBoxRightTrigger() > 0)
    	{
    		Climber.climbDown();
    	//	pidClimberSubsystem.setSetPoint(0);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {

    	//if (pidClimberSubsystem.ifOnTarget())
    	//{
    	//	pidClimberSubsystem.disable();
    	//}
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
