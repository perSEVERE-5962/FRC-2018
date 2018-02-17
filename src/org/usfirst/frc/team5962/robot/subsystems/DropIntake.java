package org.usfirst.frc.team5962.robot.subsystems;

import org.usfirst.frc.team5962.robot.Robot;
import org.usfirst.frc.team5962.robot.RobotMap;
import org.usfirst.frc.team5962.robot.sensors.NeveRestGearMotorEncoder;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PIDController;

public class DropIntake {

	public PIDDropIntakeOutput pidDropIntakeOutput;
	public PIDDropIntakeSource pidDropIntakeSource;
	public PIDController pidDropIntakeController;
	
	final double STRINGLENGTH = 16;
	
	public static void dropIntake() {
		
		RobotMap.dropBoxIntake.set(ControlMode.PercentOutput, Robot.oi.xBoxRightAxis());
		Robot.dropIntakeEncoder.getDistance();
		
	}
	
	public void checkParallel() {
		
		//Makes sure the intake is parrallel to the gorund so the intake won't move back
		//if (getDistance() >= STRINGLENGTH) {
		//	RobotMap.dropBoxIntake.set(ControlMode.PercentOutput, 0);
		//}
		
		
		//pidDropIntakeController.setSetpoint(16);

		
		
	}
	
	//public static double getDistance() {
		
		//double encoderDistance = RobotMap.dropBoxIntake.getSensorCollection().getQuadraturePosition();
		//DriverStation.reportWarning(encoderDistance + "", false);
		//Determines distance of the string by 2*pi*(1) / 420;
		//double distance = encoderDistance * .0149;
		//return distance;
	//}
	
	public void init() {
		
		pidDropIntakeOutput = new PIDDropIntakeOutput();
		pidDropIntakeSource = new PIDDropIntakeSource();
		
		double kp = 0;
		double ki = 0;
		double kd = 0;
		
		pidDropIntakeController = new PIDController(kp,ki,kd,pidDropIntakeSource,pidDropIntakeOutput);
	}
}
