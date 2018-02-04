package org.usfirst.frc.team5962.robot.subsystems;

import edu.wpi.first.wpilibj.DriverStation;

public class FmsDataRetrieval {

public static enum PlatesLocation {
		
		leftSwitchOwnership,
		rightSwitchOwnership,
		stop
		
	}
	
	public PlatesLocation fieldDataLocation;
	
	public PlatesLocation fieldDataRetrieval(){
		
	String gameData = DriverStation.getInstance().getGameSpecificMessage();
	fieldDataLocation = PlatesLocation.stop;
	
		if(gameData.charAt(0) == 'L')
		{
		
			fieldDataLocation = PlatesLocation.leftSwitchOwnership;
			
		} else if (gameData.charAt(0) == 'R'){
			
			fieldDataLocation = PlatesLocation.rightSwitchOwnership;
		
		}else{
			fieldDataLocation = PlatesLocation.stop;
		}
		
		return fieldDataLocation;
	}


}
