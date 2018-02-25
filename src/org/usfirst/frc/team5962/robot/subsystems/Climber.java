package org.usfirst.frc.team5962.robot.subsystems;

import org.usfirst.frc.team5962.robot.Robot;
import org.usfirst.frc.team5962.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class Climber {

	public static void climbUp(){
		
		RobotMap.climber.set(ControlMode.PercentOutput, Robot.oi.xBoxLeftTrigger());
	}
	
	public static void climbDown() {
		
		RobotMap.climber.set(ControlMode.PercentOutput, Robot.oi.xBoxRightTrigger() * -1);
	}
}
