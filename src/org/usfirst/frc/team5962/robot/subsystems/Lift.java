package org.usfirst.frc.team5962.robot.subsystems;

import org.usfirst.frc.team5962.robot.Robot;
import org.usfirst.frc.team5962.robot.RobotMap;

public class Lift {

	final static double HEIGHTOFROPE = 42;
	
	public static void lift() {
		
		RobotMap.lift.set(Robot.oi.xBoxLeftAxis() * -1);
	}
	
	public static void checkHeight() {
		
		Robot.slideEncoder.getDistance();
	}
	
	public static void getDistance() {
		
		
	}
}
