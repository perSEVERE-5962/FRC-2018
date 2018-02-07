package org.usfirst.frc.team5962.robot.subsystems;

import org.usfirst.frc.team5962.robot.RobotMap;
import org.usfirst.frc.team5962.robot.Robot;

import edu.wpi.first.wpilibj.PIDOutput;

public class PIDDriveOutput implements PIDOutput{

	@Override
	public void pidWrite(double output) {
		// TODO Auto-generated method stub
		double angle = Robot.robotGyro.getGyroAngle();
		RobotMap.myRobot.curvatureDrive(output, (angle * .03), false);
	}

}
