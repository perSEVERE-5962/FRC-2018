package org.usfirst.frc.team5962.robot;

import org.usfirst.frc.team5962.robot.sensors.RobotUltrasonicAnalog;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	private final static int PWM_CHANNEL_0 = 0;
	private final static int PWM_CHANNEL_1 = 1;
	private final static int PWM_CHANNEL_2 = 2;
	private final static int PWM_CHANNEL_3 = 3;
	private final static int PWM_CHANNEL_4 = 4;
	private final static int PWM_CHANNEL_5 = 5;
	private final static int PWM_CHANNEL_6 = 6;
	private final static int PWM_CHANNEL_7 = 7;
	private final static int PWM_CHANNEL_8 = 8;
	private final static int PWM_CHANNEL_9 = 9;

	// DIO Channels
	private final static int DIO_CHANNEL_0 = 0;
	private final static int DIO_CHANNEL_1 = 1;
	private final static int DIO_CHANNEL_2 = 2;
	private final static int DIO_CHANNEL_3 = 3;
	private final static int DIO_CHANNEL_4 = 4;
	private final static int DIO_CHANNEL_5 = 5;
	private final static int DIO_CHANNEL_6 = 6;
	private final static int DIO_CHANNEL_7 = 7;
	private final static int DIO_CHANNEL_8 = 8;
	private final static int DIO_CHANNEL_9 = 9;
	
	
	public static Victor robotLeftVictor1;
	public static Victor robotLeftVictor2;
	public static Victor robotRightVictor1;
	public static Victor robotRightVictor2;
	public static DifferentialDrive myRobot;
	public static SpeedController leftDrive;
	public static SpeedController rightDrive;
	
	public static TalonSRX leftBoxIntake;
	public static TalonSRX rightBoxIntake;
	
	public static TalonSRX dropBoxIntake;
	public static Victor lift;
	
	public static RobotUltrasonicAnalog ultraSonic;
	
	
	
	public static void init() {

		robotLeftVictor1 = new Victor(PWM_CHANNEL_6);
		robotLeftVictor2 = new Victor(PWM_CHANNEL_7);
		robotRightVictor1 = new Victor(PWM_CHANNEL_0);
		robotRightVictor2 = new Victor(PWM_CHANNEL_1);
		leftDrive = new MultiSpeedController(robotLeftVictor1, robotLeftVictor2);
		rightDrive = new MultiSpeedController(robotRightVictor1, robotRightVictor2);
		myRobot = new DifferentialDrive(leftDrive, rightDrive);
		
		leftBoxIntake = new TalonSRX(12);
		rightBoxIntake = new TalonSRX(13);
		
		dropBoxIntake = new TalonSRX(14);
		lift = new Victor(PWM_CHANNEL_3);
		
		dropBoxIntake.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		
		ultraSonic = new RobotUltrasonicAnalog(DIO_CHANNEL_0);
		

	}
}