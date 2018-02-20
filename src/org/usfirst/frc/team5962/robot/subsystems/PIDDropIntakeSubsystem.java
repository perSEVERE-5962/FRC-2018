package org.usfirst.frc.team5962.robot.subsystems;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

import org.usfirst.frc.team5962.robot.RobotMap;
import org.usfirst.frc.team5962.robot.Robot;

public class PIDDropIntakeSubsystem extends PIDSubsystem{

	public PIDController pidDropIntakeController;
	public PIDDropIntakeSource pidDropIntakeSource;
	public PIDDropIntakeOutput pidDropIntakeOutput;
	
	public PIDDropIntakeSubsystem(double p, double i, double d) {
		super(p, i, d);
		pidDropIntakeSource = new PIDDropIntakeSource();
		pidDropIntakeOutput = new PIDDropIntakeOutput();
		pidDropIntakeController = this.getPIDController();
		pidDropIntakeController.setOutputRange(0.5, 0.5);
		pidDropIntakeController.setInputRange(-80, 20);
		pidDropIntakeController.setPercentTolerance(5);
		//pidDropIntakeController.setContinuous(false);
		//pidDropIntakeController.enable();
		
		// TODO Auto-generated constructor stub
	}

	public void setSetPoint(double setPoint) {
		pidDropIntakeController.setSetpoint(setPoint);
		pidDropIntakeController.enable();
		
	}
	
	public void setDisable() {
		pidDropIntakeController.disable();
	}
	
	public boolean ifOnTarget() {
		return pidDropIntakeController.onTarget();
	}
	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return pidDropIntakeSource.pidGet();
	}

	@Override
	protected void usePIDOutput(double output) {
		pidDropIntakeOutput.pidWrite(output);
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
}
