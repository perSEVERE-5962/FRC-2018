package org.usfirst.frc.team5962.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5962.robot.Robot;
import org.usfirst.frc.team5962.robot.sensors.RobotGyro;

public class Gyro {

	//private RobotGyro robotGyro = new RobotGyro();
	
	private boolean gyroResetButton = false;
	
	public void setUpResetGyro()
	{
		SmartDashboard.putBoolean("Gyro Reset", gyroResetButton);
	}
	
	public void resetGryoShuffleboard() {
		
		gyroResetButton = SmartDashboard.getBoolean("Gyro Reset", gyroResetButton);
		if (gyroResetButton == true){
			Robot.robotGyro.resetGyro();
			gyroResetButton = false;
			SmartDashboard.putBoolean("Gyro Reset", gyroResetButton);
		}	
	}
}
