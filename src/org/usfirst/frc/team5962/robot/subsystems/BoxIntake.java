package org.usfirst.frc.team5962.robot.subsystems;

import org.usfirst.frc.team5962.robot.Robot;
import org.usfirst.frc.team5962.robot.RobotMap;
public class BoxIntake {

	
	public static void boxIntake() {
		if (Robot.oi.gamePadLeftTrigger() > 0.0)
		{
			RobotMap.boxIntake.set(Robot.oi.gamePadLeftTrigger());
		}
			
		
	}
	
	public static void boxOutake() {
		if (Robot.oi.gamePadRightTrigger() > 0.0)
		{
			RobotMap.boxIntake.set(Robot.oi.gamePadRightTrigger() * -1);
		}
		
		
	}
	
}
