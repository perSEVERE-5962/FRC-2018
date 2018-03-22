package org.usfirst.frc.team5962.robot.subsystems;

import org.usfirst.frc.team5962.robot.Robot;
import org.usfirst.frc.team5962.robot.RobotMap;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class WingDeploy {
	
	public WingDeploy() {
		RobotMap.wingRelay.set(Relay.Value.kOff);
		RobotMap.wingRelay.setDirection(Relay.Direction.kBoth);
	}
	
	public static void leftWingOff() {
		
		RobotMap.wingRelay.set(Relay.Value.kOff);
		//SmartDashboard.putString("WINGS " , " WINGS ARE OFF");
	}
	
	public static void rightWingOff() {
		
		RobotMap.wingRelay.set(Relay.Value.kOff);
	}
	
	public static void bothWingsOff() {
		
		RobotMap.wingRelay.stopMotor();
		SmartDashboard.putString("WINGS " , " WINGS ARE OFF");
        //rightWingRelay.set(Relay.Value.kOff);
        
	}
	
	public static void leftWingDeploy(){
		
		RobotMap.wingRelay.set(Relay.Value.kReverse);
		SmartDashboard.putString("WINGS " , " LEFT WING FORWARD");
		
		
	}
  	
	public static void rightWingDeploy() {
		
		RobotMap.wingRelay.set(Relay.Value.kForward);
		SmartDashboard.putString("WINGS " , " RIGHT WING REVERSE");
		
	}
	
	public static void bothWingsDeploy() {
		
		RobotMap.wingRelay.set(Relay.Value.kOn);
		

		
	}
	
}