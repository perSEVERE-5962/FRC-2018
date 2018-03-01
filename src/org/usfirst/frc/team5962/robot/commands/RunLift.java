package org.usfirst.frc.team5962.robot.commands;

import org.usfirst.frc.team5962.robot.Robot;
import org.usfirst.frc.team5962.robot.subsystems.Lift;

import org.usfirst.frc.team5962.robot.subsystems.PIDLiftSubsystem;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
public class RunLift extends Command{

	PIDLiftSubsystem pidLiftSubsystem;
	Lift lift = new Lift();
	
	// Called just before this Command runs the first time
    protected void initialize() {
    	
    	//pidLiftSubsystem = new PIDLiftSubsystem(.3,0,.3);
    	//pidLiftSubsystem.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	lift.lift();
    	lift.checkHeight();
    	//if (Robot.oi.xBoxLeftAxis() < 0) {
    	//	pidLiftSubsystem.setSetPoint(40);
    	//} else if (Robot.oi.xBoxRightAxis() > 0){
    	//	pidLiftSubsystem.setSetPoint(0);
    	//}
    	
    	//pidLiftSubsystem.enable();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {

    	//if (pidLiftSubsystem.ifOnTarget())
    	//{
    	//	pidLiftSubsystem.disable();
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
