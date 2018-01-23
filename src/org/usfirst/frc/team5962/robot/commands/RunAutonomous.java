package org.usfirst.frc.team5962.robot.commands;

import org.usfirst.frc.team5962.robot.subsystems.Autonomous;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RunAutonomous extends Command {

	private boolean isFinished = false;
	private Autonomous autonomousSubsystem = new Autonomous();

	protected void initialize() {
		autonomousSubsystem.init();
	}

	protected void execute() {
		//autonomousSubsystem.printHeavenlyVirtues();
		//autonomousSubsystem.determineGoodPerson();

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
}