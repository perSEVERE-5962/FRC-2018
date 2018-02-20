package org.usfirst.frc.team5962.robot.subsystems;

import org.usfirst.frc.team5962.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.PIDOutput;

public class PIDLiftOutput implements PIDOutput{

	@Override
	public void pidWrite(double output) {
		
		RobotMap.lift.set(output);
		// TODO Auto-generated method stub
		
	}

}
