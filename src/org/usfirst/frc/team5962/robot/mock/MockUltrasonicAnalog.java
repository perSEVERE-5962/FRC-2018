package org.usfirst.frc.team5962.robot.mock;

import org.usfirst.frc.team5962.robot.sensors.RobotUltrasonicAnalog;

public class MockUltrasonicAnalog extends RobotUltrasonicAnalog {

	double range = 10;
	boolean backwards = false;
	
	public MockUltrasonicAnalog(int channel) {
		super(channel);
		// TODO Auto-generated constructor stub
	}
	
	public double getRange() {
		if (backwards) {
			range += 2;
			if (range >=10) {
				range = 10;
			}
		} else {
			range -= 2;
			if (range <=0) {
				range=0;
			}
		}
		return range; 
	}
	
	public void setBackwards(boolean backwards) {
		this.backwards = backwards;
	}
	
	public void reset() {
		backwards = false;
		range = 10;
	}
}
