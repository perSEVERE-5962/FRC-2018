package org.usfirst.frc.team5962.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

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
}