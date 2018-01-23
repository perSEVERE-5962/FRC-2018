package org.usfirst.frc.team5962.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Autonomous extends Subsystem {

	public enum State{
		genericOne,
		genericTwo,
		genericThree,
		vagueOne,
		vagueTwo,
		vagueThree,
		undefinedOne,
		undefinedTwo,
		undefinedThree,		
		
		stop
	};
	public State state;	
	private void defineGenerics()
	{
	switch(state) {
	case genericOne:
			state = State.genericTwo;
			
	}
	}
	
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
	
	
	public static enum HeavenlyVirtues {
		printChastity,
		printTemperance,
		printCharity,
		printDiligence,
		printPatience,
		printKindness,
		printHumility,
	
		sins,
		free
		
	}
	
	private HeavenlyVirtues state;
	
	SendableChooser<HeavenlyVirtues> goodOrBad;
	public void init()
	{
		//state = HeavenlyVirtues.printChastity;
		
		//goodOrBad = new SendableChooser<HeavenlyVirtues>();
		//goodOrBad.addDefault("Yes", HeavenlyVirtues.free);
		//goodOrBad.addObject("No", HeavenlyVirtues.sins);
		//SmartDashboard.putData("Are you a good person?", goodOrBad);
		//SmartDashboard.putString("Test", "Here");
		
		
	}
	
	public void printHeavenlyVirtues()
	{	
		switch(state){

		case printChastity:
			SmartDashboard.putString("First Stage: ", "Chastity");
			state = HeavenlyVirtues.printTemperance;
			break;
		
		case printTemperance:
			SmartDashboard.putString("Second Stage: ", "Temperance");
			state = HeavenlyVirtues.printCharity;
			break;
		
		case printCharity:
			SmartDashboard.putString("Third Stage: ", "Charity");
			state = HeavenlyVirtues.printDiligence;
			break;
			
		case printDiligence:
			SmartDashboard.putString("Fourth Stage: ", "Diligence");
			state = HeavenlyVirtues.printPatience;
			break;
		
		case printPatience:
			SmartDashboard.putString("Fifth Stage: ", "Patience");
			state = HeavenlyVirtues.printKindness;
			break;
			
		case printKindness:
			SmartDashboard.putString("Sixth Stage", "Kindness");
			state = HeavenlyVirtues.printHumility;
			break;
			
			
		case printHumility:
			SmartDashboard.putString("Seventh Stage: ","Humility");
			break;
			
		case sins:
			SmartDashboard.putString("Are you a good person?","Bad");
			break;
			
		case free:
			SmartDashboard.putString("Are you a good person?","Good");
			break;

		default:
			SmartDashboard.putString("Status", "" + state);
		}	
	}
	
//	SendableChooser<HeavenlyVirtues> goodOrBad;
	public void determineGoodPerson()
	{
//		goodOrBad = new SendableChooser<HeavenlyVirtues>();
//		goodOrBad.addDefault("Yes", HeavenlyVirtues.free);
//		goodOrBad.addObject("No", HeavenlyVirtues.sins);
//		SmartDashboard.putData("Are you a good person?", goodOrBad);
	}
}