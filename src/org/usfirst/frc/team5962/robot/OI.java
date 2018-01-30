package org.usfirst.frc.team5962.robot;

import org.usfirst.frc.team5962.robot.commands.RunJoystickTank;
import org.usfirst.frc.team5962.robot.commands.Throttle;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Joystick joystickLeft;
	public Joystick joystickRight;
	public Joystick gamepad1;
	public Button throttle;
	
	private boolean throttleEnabled = false;

	public OI() {
		joystickLeft = new Joystick(1);
		joystickRight = new Joystick(2);
		gamepad1 = new Joystick(0);
		throttle = new JoystickButton(joystickLeft, 1);
		throttle.whenPressed(new Throttle());

	}
	
	public void startDriveCommand() {
	Command command = new RunJoystickTank();
	command.start();
	}
	
	public double joystickLeftAxis() {
		return joystickLeft.getRawAxis(1);
	}
	
	public double joystickRightAxis() {
		return joystickRight.getRawAxis(1);
	}
	
	public double gamepadLeftAxis() {
		return gamepad1.getRawAxis(1);
	}
	public double gamepadRightAxis() {
		return gamepad1.getRawAxis(5);
	}
	
	public boolean isThrottleEnabled() {
		return throttleEnabled;
	}
	
	public void toggleThrottle() {
		throttleEnabled = !throttleEnabled;
		SmartDashboard.putString("throttle enabled", "" + throttleEnabled);
	}
}
