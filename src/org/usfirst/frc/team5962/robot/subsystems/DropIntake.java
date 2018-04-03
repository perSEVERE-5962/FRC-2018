package org.usfirst.frc.team5962.robot.subsystems;

import org.usfirst.frc.team5962.robot.Robot;
import org.usfirst.frc.team5962.robot.RobotMap;
import org.usfirst.frc.team5962.robot.sensors.NeveRestGearMotorEncoder;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DropIntake {

	//public PIDDropIntakeOutput pidDropIntakeOutput;
	//public PIDDropIntakeSource pidDropIntakeSource;
	//public PIDController pidDropIntakeController;
	
	final double STRINGLENGTH = 16;
	
	public static void dropIntake() {
		
		if (Robot.oi.xBoxRightAxis() > .3 || Robot.oi.xBoxRightAxis() < -.3) {
		RobotMap.dropBoxIntake.set(ControlMode.PercentOutput, Robot.oi.xBoxRightAxis());
		} else {
			RobotMap.dropBoxIntake.set(ControlMode.PercentOutput, 0);
		}
		//Robot.dropIntakeEncoder.getDistance();
		
	}
	
	public static void checkParallel() {
		
		SmartDashboard.putString("Limit Drop Intake Pressed:", RobotMap.limitDropIntake.get() + "");

		
		
	}
	
	//public static double getDistance() {
		
		//double encoderDistance = RobotMap.dropBoxIntake.getSensorCollection().getQuadraturePosition();
		//DriverStation.reportWarning(encoderDistance + "", false);
		//Determines distance of the string by 2*pi*(1) / 420;
		//double distance = encoderDistance * .0149;
		//return distance;
	//}
	
	public void init() {
		
		//pidDropIntakeOutput = new PIDDropIntakeOutput();
		//pidDropIntakeSource = new PIDDropIntakeSource();
		
		//double kp = 0;
		//double ki = 0;
		//double kd = 0;
		
		//pidDropIntakeController = new PIDController(kp,ki,kd,pidDropIntakeSource,pidDropIntakeOutput);
	}
}
