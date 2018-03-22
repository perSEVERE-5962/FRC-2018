package org.usfirst.frc.team5962.robot.subsystems;

import org.usfirst.frc.team5962.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PIDDriveSource implements PIDSource{

	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PIDSourceType getPIDSourceType() {
		// TODO Auto-generated method stub
		return PIDSourceType.kDisplacement;
	}

	@Override
	public double pidGet() {
		// TODO Auto-generated method stub
		SmartDashboard.putString("Encoder Distance:", Robot.encoder.getDistance() * -1 + "");
		return (Robot.encoder.getDistance() * -1);
	}

}
