package org.usfirst.frc.team5962.robot;

import org.usfirst.frc.team5962.robot.commands.RunBoxIntake;
import org.usfirst.frc.team5962.robot.commands.RunBoxOutake;
import org.usfirst.frc.team5962.robot.commands.RunBoxSpin;
import org.usfirst.frc.team5962.robot.commands.RunJoystickTank;
import org.usfirst.frc.team5962.robot.commands.RunLeftWingDeploy;
import org.usfirst.frc.team5962.robot.commands.RunRightWingDeploy;
import org.usfirst.frc.team5962.robot.commands.RunWingDeploy;
import org.usfirst.frc.team5962.robot.commands.StopBoxIntake;
import org.usfirst.frc.team5962.robot.commands.StopBoxOutake;
import org.usfirst.frc.team5962.robot.commands.StopBoxSpin;
import org.usfirst.frc.team5962.robot.commands.StopWingDeploy;
import org.usfirst.frc.team5962.robot.commands.Throttle;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
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
	public Joystick xBoxController;
	public Joystick gamepad2;

	
	public Button throttle;
	public Button jsIntake;
	public Button jsOutake;
	public Button jsBoxSpin;
	public Button deployWings;
	public Button deployLeftWing;
	public Button deployRightWing;
	
	public Trigger intake;
	public Trigger outake;
	public Trigger xBoxClimbUp;
	public Trigger xBoxClimbDown;
	
	private boolean throttleEnabled = false;

	public OI() {
		joystickLeft = new Joystick(1);
		joystickRight = new Joystick(2);
		gamepad1 = new Joystick(0);
		xBoxController = new Joystick(3);
		gamepad2 = new Joystick(4);
		
		jsIntake = new JoystickButton(joystickLeft,1);
		jsIntake.whenPressed(new RunBoxIntake());
		jsIntake.whenReleased(new StopBoxIntake());
		
		jsOutake = new JoystickButton(joystickRight,1);
		jsOutake.whenPressed(new RunBoxOutake());
		jsOutake.whenReleased(new StopBoxOutake());
		
		throttle = new JoystickButton(joystickLeft, 3);
		throttle.whenPressed(new Throttle());
		
		jsBoxSpin = new JoystickButton(joystickLeft, 4);
		jsBoxSpin.whenPressed(new RunBoxSpin());
		jsBoxSpin.whenReleased(new StopBoxSpin());
		
		deployWings = new JoystickButton(gamepad1, 1);
		deployWings.whenPressed(new RunWingDeploy());
		deployWings.whenReleased(new StopWingDeploy());
		
		deployLeftWing = new JoystickButton(gamepad1, 2);
		deployLeftWing.whenPressed(new RunLeftWingDeploy());
		deployLeftWing.whenReleased(new StopWingDeploy());
		
		deployRightWing = new JoystickButton(gamepad1, 3);
		deployRightWing.whenPressed(new RunRightWingDeploy());
		deployRightWing.whenReleased(new StopWingDeploy());
		
		//deployWings = new JoystickButton(joystickRight, 3);
		//deployWings.whenPressed(new RunWingDeploy());

	}
	
	public void startDriveCommand() {
	Command command = new RunJoystickTank();
	command.start();
	}
	
	public double joystickLeftAxis() {
		return joystickLeft.getRawAxis(1);
	}
	
	public double joystickLeftThrottleAxis() {
		return joystickLeft.getRawAxis(3);
	}
	
	public double joystickRightAxis() {
		return joystickRight.getRawAxis(1);
	}
	
	public double joystickRightThrottleAxis() {
		return joystickRight.getRawAxis(3);
	}
	
	public double gamepadLeftAxis() {
		return gamepad1.getRawAxis(1);
	}
	public double gamepadRightAxis() {
		return gamepad1.getRawAxis(5);
	}
	
	public double gamePadLeftTrigger() {
		return gamepad1.getRawAxis(2);
	}
	
	public double gamePadRightTrigger() {
		return gamepad1.getRawAxis(3);
	}
	
	public double xBoxLeftAxis() {
		return xBoxController.getRawAxis(1);
	}
	
	public double xBoxRightAxis() {
		return xBoxController.getRawAxis(5);
	}
	
	public double xBoxLeftTrigger() {
		return xBoxController.getRawAxis(2);
	}
	
	public double xBoxRightTrigger() {
		return xBoxController.getRawAxis(3);
	}
	
	public boolean isThrottleEnabled() {
		return throttleEnabled;
	}
	
	public void toggleThrottle() {
		throttleEnabled = !throttleEnabled;
		SmartDashboard.putString("throttle enabled", "" + throttleEnabled);
	}
	
}
