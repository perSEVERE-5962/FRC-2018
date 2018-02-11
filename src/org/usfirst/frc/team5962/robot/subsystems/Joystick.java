package org.usfirst.frc.team5962.robot.subsystems;

import org.usfirst.frc.team5962.robot.Robot;
import org.usfirst.frc.team5962.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Joystick extends Subsystem {
public static void throttle() {
	double nob = (((Robot.oi.joystickRight.getThrottle() * -1) + 2) / 3);
	RobotMap.myRobot.setMaxOutput ((nob));
}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
		
	}

}