
package org.usfirst.frc.team5962.robot.subsystems;

import org.usfirst.frc.team5962.robot.Robot;
import org.usfirst.frc.team5962.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Drive extends Subsystem {
	
	public void joystickTank() {
		RobotMap.myRobot.tankDrive(-.5, -.5);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
}