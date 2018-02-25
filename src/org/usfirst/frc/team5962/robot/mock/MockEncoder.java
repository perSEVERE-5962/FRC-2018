package org.usfirst.frc.team5962.robot.mock;

import org.usfirst.frc.team5962.robot.sensors.RobotEncoder;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class MockEncoder extends RobotEncoder {
	double distance = 0;
	public double getDistance() {
		distance += 2; // increment by 2 inches
		if(isInverted())
			distance = -distance;
		SmartDashboard.putString("Encoder Distance", "" + distance);
		return distance;
	}
}
