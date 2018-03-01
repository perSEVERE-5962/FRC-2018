package org.usfirst.frc.team5962.robot.subsystems;

import org.usfirst.frc.team5962.robot.Robot;
import org.usfirst.frc.team5962.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class Lift {

	final static double HEIGHTOFROPE = 42;
	
	static boolean isEnabled;
	
	public static  void lift() {
		
		if (isEnabled){
		RobotMap.lift.set(ControlMode.PercentOutput, 0.0);
		}
		else {
		RobotMap.lift.set(ControlMode.PercentOutput, Robot.oi.xBoxLeftAxis() * -1);
		}
	
	}
	
	public  static void checkHeight() {
		
		isEnabled = RobotMap.limitSwitchSlide.get();
		
		//Robot.slideEncoder.getDistance();
	}
	
	public static void getDistance() {
		
		
	}
}
	