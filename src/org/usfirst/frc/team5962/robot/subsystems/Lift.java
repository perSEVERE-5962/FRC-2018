package org.usfirst.frc.team5962.robot.subsystems;

import org.usfirst.frc.team5962.robot.Robot;
import org.usfirst.frc.team5962.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class Lift {

	final static double HEIGHTOFROPE = 42;
	
	static boolean isEnabled = false;
	
	public void lift() {
		
		if (!isEnabled){
		RobotMap.lift.set(0.0);
		}
		else {
		RobotMap.lift.set(Robot.oi.xBoxLeftAxis() * -1);
		}
	
	}
	
	public  void checkHeight() {
		
		isEnabled = RobotMap.limitSwitchSlide.get();
		
		//Robot.slideEncoder.getDistance();
	}
	
	public void getDistance() {
		
		
	}
}
	