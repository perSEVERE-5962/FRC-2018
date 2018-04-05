package org.usfirst.frc.team5962.robot.subsystems;

import org.usfirst.frc.team5962.robot.Robot;
import org.usfirst.frc.team5962.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class Climber {

	public static void climbUp(){
		
		RobotMap.climber.set(Robot.oi.xBoxLeftTrigger() * -1);
	}
	
	public static void climbDown() {
		
		RobotMap.climber.set(Robot.oi.xBoxRightTrigger());
	}
	
	public static void stop() {
		RobotMap.climber.set(0);
	}
}