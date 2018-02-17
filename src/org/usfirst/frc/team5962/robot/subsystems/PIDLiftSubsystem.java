package org.usfirst.frc.team5962.robot.subsystems;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

import org.usfirst.frc.team5962.robot.RobotMap;
import org.usfirst.frc.team5962.robot.Robot;

public class PIDLiftSubsystem extends PIDSubsystem{

	public PIDController pidLiftController;
	public PIDLiftSource pidLiftSource;
	public PIDLiftOutput pidLiftOutput;
	
	public PIDLiftSubsystem(double p, double i, double d) {
		super(p, i, d);
		
		pidLiftSource = new PIDLiftSource();
		pidLiftOutput = new PIDLiftOutput();
		pidLiftController = this.getPIDController();
		pidLiftController.setOutputRange(0.5, 0.5);
		pidLiftController.setInputRange(0,60);
		pidLiftController.setPercentTolerance(5);
		// TODO Auto-generated constructor stub
	}
	
	public void setSetPoint(double setPoint) {
		pidLiftController.setSetpoint(setPoint);
		pidLiftController.enable();
		
	}
	
	public boolean ifOnTarget() {
		return pidLiftController.onTarget();
	}

	@Override
	protected double returnPIDInput() {
		pidLiftSource.pidGet();
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected void usePIDOutput(double output) {
		pidLiftOutput.pidWrite(output);
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
