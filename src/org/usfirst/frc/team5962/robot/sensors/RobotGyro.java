package org.usfirst.frc.team5962.robot.sensors;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RobotGyro {
		// gyro
		//public ADIS16448_IMU gyro;
		 public ADXRS450_Gyro gyro;
		final int gyroChannel = 0;
		double angleSetPoint = 0.0;
		final double gyroSpeedConstant = 0.006;

		public RobotGyro() {
			gyro = new ADXRS450_Gyro();
		}

		/**
		 * <pre>
		 * Reset and Calibrate
		 * </pre>
		 * 
		 * <pre>
		 * Calibrate the gyro by running for a number of samples and computing the
		 * center value. Then use the center value as the Accumulator center value for
		 * subsequent measurements. It's important to make sure that the robot is not
		 * moving while the centering calculations are in progress, this is typically
		 * done when the robot is first turned on while it's sitting at rest before
		 * the competition starts.
		 * </pre>
		 * 
		 * <pre>
		 * Reset the gyro. Resets the gyro to a heading of zero. This can be used if
		 * there is significant drift in the gyro and it needs to be recalibrated
		 * after it has been running.
		 * </pre>
		 */
		public void resetGyro() {
			gyro.reset();
		}

		public void calibrateGyro() {
			gyro.calibrate();
		}
		
		public double getGyroAngle() {
			SmartDashboard.putString("Gyro Angle", "" + gyro.getAngle());
		//	return gyro.getAngleX();
			return gyro.getAngle();

		}

		public double getTurningValue() {
			return (angleSetPoint - gyro.getAngle()) * gyroSpeedConstant;
		}
		

		public void showGyroData() {
		//	SmartDashboard.putString("Gyro Angle", "" + gyro.getAngleX());
		}
	}
