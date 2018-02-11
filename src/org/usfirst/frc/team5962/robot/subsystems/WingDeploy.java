package org.usfirst.frc.team5962.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;

public class WingDeploy {

	 Solenoid leftWing = new Solenoid(0);
	 Solenoid rightWing = new Solenoid(2);
	
	public void dropWings() {
		leftWing.set(true);
		rightWing.set(true);
	}
	
	public void liftWings() {
		leftWing.set(false);
		rightWing.set(false);
	}
}
