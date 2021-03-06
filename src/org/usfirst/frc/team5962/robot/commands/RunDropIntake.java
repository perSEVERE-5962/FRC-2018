package org.usfirst.frc.team5962.robot.commands;

import org.usfirst.frc.team5962.robot.Robot;
import org.usfirst.frc.team5962.robot.RobotMap;
import org.usfirst.frc.team5962.robot.subsystems.DropIntake;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
public class RunDropIntake extends Command{

	
	// Called just before this Command runs the first time
    protected void initialize() {
    	
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//pidDropIntakeSubsystem.enable();
    	//DropIntake.dropIntake();
    	DropIntake.checkParallel();
    	DropIntake.dropIntake();
    	}
    	   	
    	//pidDropIntakeSubsystem.enable();

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {


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
