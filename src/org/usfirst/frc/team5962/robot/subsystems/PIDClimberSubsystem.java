package org.usfirst.frc.team5962.robot.subsystems;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

import org.usfirst.frc.team5962.robot.RobotMap;
import org.usfirst.frc.team5962.robot.Robot;

public class PIDClimberSubsystem extends PIDSubsystem{

	public PIDController pidClimberController;
	public PIDClimberSource pidClimberSource;
	public PIDClimberOutput pidClimberOutput;
	
	public PIDClimberSubsystem(double p, double i, double d) {
		super(p, i, d);
		pidClimberSource = new PIDClimberSource();
		pidClimberOutput = new PIDClimberOutput();
		pidClimberController = this.getPIDController();
		pidClimberController.setOutputRange(0.5, 0.5);
		pidClimberController.setInputRange(0, 100);
		pidClimberController.setPercentTolerance(5);
		//pidDropIntakeController.setContinuous(false);
		
		// TODO Auto-generated constructor stub
	}

	public void setSetPoint(double setPoint) {
		pidClimberController.setSetpoint(setPoint);
		pidClimberController.enable();
		
	}
	
	public void setDisable() {
		pidClimberController.disable();
	}
	
	public boolean ifOnTarget() {
		return pidClimberController.onTarget();
	}
	
	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return pidClimberSource.pidGet();
	}

	@Override
	protected void usePIDOutput(double output) {
		pidClimberOutput.pidWrite(output);
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
