package org.usfirst.frc.team5962.robot.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class FmsDataRetrieval {

public static enum PlatesLocation {
		
		leftSwitchOwnership,
		rightSwitchOwnership,
		stop
		
	}
	
	static int fieldDataLocation = 0;
	
	public static int fieldDataRetrieval(){
		
	String gameData = DriverStation.getInstance().getGameSpecificMessage();
	fieldDataLocation = 0;
	
		if(gameData.charAt(0) == 'L')
		{
		
			fieldDataLocation = 1;
			
		} else if (gameData.charAt(0) == 'R'){
			
			fieldDataLocation = -1;
		
		}else{
			fieldDataLocation = 0;
		}
		
		return fieldDataLocation;
	}


}
