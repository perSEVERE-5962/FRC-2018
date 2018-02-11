
package org.usfirst.frc.team5962.robot.subsystems;

import org.usfirst.frc.team5962.robot.Robot;
import org.usfirst.frc.team5962.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drive extends Subsystem {
	
	//public PIDDriveOutput pidDriveOutput = new PIDDriveOutput();
	//public PIDDriveSource pidDriveSource = new PIDDriveSource();
	//public PIDController pidDriveController = new PIDController(0,0,0,pidDriveSource,pidDriveOutput);
	
	public Drive() {
		
		//pidDriveController.disable();
		//pidDriveController.setOutputRange(-1,-1);   //The speeds of the drive
		//pidDriveController.setAbsoluteTolerance(1); //Tolerance is 1 inch
		//pidDriveController.setSetpoint(120);        //The Distance is 10 feet or 120 inches
	}
	public void joystickTank() {
		RobotMap.myRobot.tankDrive(Robot.oi.joystickRightAxis(), Robot.oi.joystickLeftAxis());
		//RobotMap.myRobot.tankDrive(robotOI.gamepadRightAxis(), robotOI.gamepadLeftAxis());
	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
	
}