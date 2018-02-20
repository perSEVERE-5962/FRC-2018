package org.usfirst.frc.team5962.robot.subsystems;

import org.usfirst.frc.team5962.robot.Robot;
import org.usfirst.frc.team5962.robot.RobotMap;
import edu.wpi.first.wpilibj.Relay;

public class WingDeploy {
	
	public static Relay leftWingRelay;
	public static Relay rightWingRelay;
	
	public WingDeploy() {
		
		leftWingRelay = new Relay(1);
		rightWingRelay = new Relay(2);
		
	}
	
	public static void leftWingOff() {
		
		leftWingRelay.set(Relay.Value.kOff);
		
	}
	
	public static void rightWingOff() {
		
		rightWingRelay.set(Relay.Value.kOff);
		
	}
	
	public static void bothWingsOff() {
		
		leftWingRelay.set(Relay.Value.kOff);
        rightWingRelay.set(Relay.Value.kOff);
        
	}
	
	public static void leftWingDeploy(){
		
		leftWingRelay.set(Relay.Value.kForward);
		
	}
	
	public static void rightWingDeploy() {
		
		rightWingRelay.set(Relay.Value.kReverse);
		
	}
	
	public static void bothWingsDeploy() {
		
		leftWingRelay.set(Relay.Value.kForward);
		rightWingRelay.set(Relay.Value.kReverse);
		
	}
	
}