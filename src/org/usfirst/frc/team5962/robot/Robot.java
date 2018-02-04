
package org.usfirst.frc.team5962.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5962.robot.commands.ResetGyro;
import org.usfirst.frc.team5962.robot.commands.RunAutonomous;
import org.usfirst.frc.team5962.robot.commands.Throttle;
import org.usfirst.frc.team5962.robot.commands.RunBoxIntake;
import org.usfirst.frc.team5962.robot.commands.RunBoxOutake;
import org.usfirst.frc.team5962.robot.commands.Throttle;
import org.usfirst.frc.team5962.robot.sensors.ADIS16448_IMU;
import org.usfirst.frc.team5962.robot.sensors.RobotGyro;
import org.usfirst.frc.team5962.robot.subsystems.Drive;
import org.usfirst.frc.team5962.robot.subsystems.Gyro;

/* The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static Command autonomousCommand;
	public static OI oi;
	public static Drive drive = new Drive();
	public static Gyro gyro = new Gyro();
//	public static RunBoxIntake runBoxIntake = new RunBoxIntake();
//	public static RunBoxOutake runBoxOutake = new RunBoxOutake();
//	public static ADIS16448_IMU robotGyro = new ADIS16448_IMU();
	public static RobotGyro robotGyro = new RobotGyro();
	


	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */

	public void robotInit() {
		RobotMap.init();
		oi = new OI();
		//RobotMap.myRobot.setMaxOutput(0.5);
		//gyro.setUpResetGyro();
		RobotMap.myRobot.setMaxOutput(0.5);
		robotGyro.resetGyro();
		SmartDashboard.putData("Reset Gyro", new ResetGyro());
		CameraServer.getInstance().startAutomaticCapture();		
	}
	


	/**
	 * This function is called once each time the robot enters Disabled mode. You
	 * can use it to reset any subsystem information you want to clear when the
	 * robot is disabled.
	 */
	public void disabledInit() {
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable chooser
	 * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
	 * remove all of the chooser code and uncomment the getString code to get the
	 * auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons to
	 * the switch structure below with additional strings & commands.
	 */
	public void autonomousInit() {
		autonomousCommand = new RunAutonomous();

		if (autonomousCommand != null) {
			autonomousCommand.start();
			robotGyro.resetGyro();
		}

	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Gyro ADIS - yaw", gyro.resetGyroAutomatic());
	}

	public void teleopInit() {
		oi.startDriveCommand();
		robotGyro.resetGyro();
		//runBoxIntake.start();
		//runBoxOutake.start();
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Gyro ADIS - yaw", gyro.resetGyroAutomatic());
		
		SmartDashboard.putString("throttle enabled", "" + oi.isThrottleEnabled());
		gyro.resetGryoShuffleboard();
		SmartDashboard.putNumber("Gyro ADIS - yaw", robotGyro.getGyroAngle());
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}