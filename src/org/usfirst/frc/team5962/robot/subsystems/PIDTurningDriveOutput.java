package org.usfirst.frc.team5962.robot.subsystems;

import org.usfirst.frc.team5962.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.PIDOutput;

import org.usfirst.frc.team5962.robot.Robot;

public class PIDTurningDriveOutput implements PIDOutput{

	@Override
	public void pidWrite(double output) {
		double angle = Robot.robotGyro.getGyroAngle();
		double counterTurn = 0 - angle;
		RobotMap.myRobot.curvatureDrive(-output, counterTurn , true);
		// TODO Auto-generated method stub
		
	}

}
