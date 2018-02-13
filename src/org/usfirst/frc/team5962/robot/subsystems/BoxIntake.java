package org.usfirst.frc.team5962.robot.subsystems;

import org.usfirst.frc.team5962.robot.Robot;
import org.usfirst.frc.team5962.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class BoxIntake {

	
	public static void boxIntake() {
		//if (Robot.oi.gamePadLeftTrigger() > 0.0)
		//{
		//	RobotMap.boxIntake.set(Robot.oi.gamePadLeftTrigger());
		//}
		
		double speed = (Robot.oi.joystickLeftThrottleAxis() + 1) / 2;
		
		RobotMap.leftBoxIntake.set(ControlMode.PercentOutput, speed);
		RobotMap.rightBoxIntake.set(ControlMode.PercentOutput, speed);
		SmartDashboard.putNumber("Speed of Intake", speed);
	}
	
	public static void boxOutake() {
		//if (Robot.oi.gamePadRightTrigger() > 0.0)
		//{
		//	RobotMap.boxIntake.set(Robot.oi.gamePadRightTrigger() * -1);
		//}
		
		//RobotMap.boxIntake.set(-1);
		
		double speed =  -1 * (Robot.oi.joystickLeftThrottleAxis() + 1) / 2;
		
		RobotMap.leftBoxIntake.set(ControlMode.PercentOutput, speed);
		RobotMap.rightBoxIntake.set(ControlMode.PercentOutput, speed);
		SmartDashboard.putNumber("Speed of Intake", speed);
	}
	
	public static void boxSpin() {
		
		double speed = (Robot.oi.joystickLeftThrottleAxis() + 1) / 2;
		
		RobotMap.leftBoxIntake.set(ControlMode.PercentOutput, speed);
		RobotMap.rightBoxIntake.set(ControlMode.PercentOutput, -1 * speed);
		SmartDashboard.putNumber("Speed of Intake", speed);
	}
	
	public static void boxStop() {
		
		RobotMap.leftBoxIntake.set(ControlMode.PercentOutput, 0);
		RobotMap.rightBoxIntake.set(ControlMode.PercentOutput, 0);
	}
	
}
