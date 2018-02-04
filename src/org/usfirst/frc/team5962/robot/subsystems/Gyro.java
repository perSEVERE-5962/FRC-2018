package org.usfirst.frc.team5962.robot.subsystems;

import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5962.robot.Robot;
import org.usfirst.frc.team5962.robot.sensors.RobotGyro;

public class Gyro {

	
	 
	public void resetGryoShuffleboard() {
		
			Robot.robotGyro.resetGyro();
	}
	
	public double resetGyroAutomatic() {
		
		if (Robot.robotGyro.getGyroAngle() >= 360 || Robot.robotGyro.getGyroAngle() <= -360)
		{
			return (Robot.robotGyro.getGyroAngle() % 360.0);
		}
		else
		{
			return Robot.robotGyro.getGyroAngle();
		}
	}
}
