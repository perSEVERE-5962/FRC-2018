package org.usfirst.frc.team5962.robot.subsystems;

import org.usfirst.frc.team5962.robot.Robot;
import org.usfirst.frc.team5962.robot.RobotMap;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class BoxIntake {

	
	public static void boxIntake() {
		//if (Robot.oi.gamePadLeftTrigger() > 0.0)
		//{
		//	RobotMap.boxIntake.set(Robot.oi.gamePadLeftTrigger());
		//}
		
		RobotMap.boxIntake.set(1);
		
	}
	
	public static void boxOutake() {
		//if (Robot.oi.gamePadRightTrigger() > 0.0)
		//{
		//	RobotMap.boxIntake.set(Robot.oi.gamePadRightTrigger() * -1);
		//}
		
		RobotMap.boxIntake.set(-1);
		
	}
	
	public static void boxStop() {
		
		RobotMap.boxIntake.set(0);
	}
	
}
