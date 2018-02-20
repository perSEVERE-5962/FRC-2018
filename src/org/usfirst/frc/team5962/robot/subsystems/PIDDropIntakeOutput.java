package org.usfirst.frc.team5962.robot.subsystems;


import org.usfirst.frc.team5962.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.PIDOutput;

import org.usfirst.frc.team5962.robot.Robot;

public class PIDDropIntakeOutput implements PIDOutput{

	public void pidWrite(double output) {
		
		if (output <= -.05 || output >= .05) {
			RobotMap.dropBoxIntake.set(ControlMode.PercentOutput, Robot.oi.xBoxRightAxis());
		} else {
			RobotMap.dropBoxIntake.set(ControlMode.PercentOutput, 0);
		}
	}
}
