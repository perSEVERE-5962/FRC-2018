package org.usfirst.frc.team5962.robot.subsystems;

import org.usfirst.frc.team5962.robot.Robot;
import org.usfirst.frc.team5962.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Lift {

	final static double HEIGHTOFROPE = 42;
	
	static boolean isEnabled = false;
	
	public static void lift() {
		
		if (!isEnabled){
		RobotMap.lift.set(0.0);
		}
		else {
			if (Robot.oi.xBoxLeftAxis() > 0)
				RobotMap.lift.set(Robot.oi.xBoxLeftAxis() * -.5);
			else {
				RobotMap.lift.set(Robot.oi.xBoxLeftAxis() * -1);
			}
		}
	
	}
	
	public static  void checkHeight() {
		
		isEnabled = RobotMap.limitSwitchSlide.get();
		SmartDashboard.putBoolean("Limit Switch", isEnabled);
		//Robot.slideEncoder.getDistance();
	}
	
	public void getDistance() {
		
		
	}
}
	