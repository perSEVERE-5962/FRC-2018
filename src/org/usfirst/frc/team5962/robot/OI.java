package org.usfirst.frc.team5962.robot;

import org.usfirst.frc.team5962.robot.commands.RunJoystickTank;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Joystick joystickLeft;
	public Joystick joystickRight;
	

	public OI() {
		joystickLeft = new Joystick(1);
		joystickRight = new Joystick(2);

	}
	
	public void startDriveCommand() {
	Command command = new RunJoystickTank();
	command.start();
	}
}