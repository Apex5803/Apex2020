package com.swervedrivespecialties.exampleswerve.utils;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
// import edu.wpi.first.wpilibj.buttons.Trigger;

public class POVTrigger extends Button{
	private int PovID;
	private int axisNumber;
	private int PovAngle;
	private XboxController xbox;
	
	
	public POVTrigger (XboxController xbox, int PovID, int axisNumber){
		 this.xbox = xbox;
		 this.PovID = PovID;
		 this.axisNumber = axisNumber;
	}
	@Override
	public boolean get() {
		return xbox.getPOV(PovID) == axisNumber;
	}

}