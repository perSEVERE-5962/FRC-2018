package org.usfirst.frc.team5962.robot.subsystems;

import org.usfirst.frc.team5962.robot.RobotMap;
import org.usfirst.frc.team5962.robot.Robot;

import edu.wpi.first.wpilibj.PIDOutput;

public class PIDDriveOutput implements PIDOutput{

	@Override
	public void pidWrite(double output) {
		// TODO Auto-generated method stub
	double angle =Robot.robotGyro.getGyroAngle();
	double counterTurn = 0 - angle;
	RobotMap.myRobot.curvatureDrive(output, counterTurn , false);
	}

}
