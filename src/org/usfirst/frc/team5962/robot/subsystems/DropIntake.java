package org.usfirst.frc.team5962.robot.subsystems;

import org.usfirst.frc.team5962.robot.Robot;
import org.usfirst.frc.team5962.robot.RobotMap;

public class DropIntake {

	public static void dropIntake() {
		
			RobotMap.dropBoxIntake.set(Robot.oi.joystickRightAxis());
	}
}
