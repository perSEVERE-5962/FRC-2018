package org.usfirst.frc.team5962.robot.subsystems;

import org.usfirst.frc.team5962.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.PIDOutput;

import org.usfirst.frc.team5962.robot.Robot;

public class PIDClimberOutput implements PIDOutput{

	@Override
	public void pidWrite(double output) {
		
		if (Robot.oi.xBoxRightTrigger() > 0) {
			output = -output;
		}
		
		RobotMap.climber.set(output);
		// TODO Auto-generated method stub
		
	}

}
