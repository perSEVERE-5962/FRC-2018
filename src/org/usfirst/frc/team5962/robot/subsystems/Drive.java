
package org.usfirst.frc.team5962.robot.subsystems;

import org.usfirst.frc.team5962.robot.Robot;
import org.usfirst.frc.team5962.robot.RobotMap;
import org.usfirst.frc.team5962.robot.OI;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Drive extends Subsystem {
	
	private OI robotOI = new OI();
	
	public void joystickTank() {
		RobotMap.myRobot.tankDrive(robotOI.joystickLeftAxis(), robotOI.joystickRightAxis());
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
}