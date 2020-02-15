package com.swervedrivespecialties.exampleswerve.utils;

// import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
// import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 * @author mwtidd
 */
public class TriggerButton extends Trigger{
    private final XboxController xbox;
    private final int axis;

    public TriggerButton(XboxController xbox, int axis){
        this.xbox = xbox;
        this.axis = axis;
    }

    public boolean get() {
        return Math.abs(xbox.getRawAxis(axis)) >= .1;
            
    }
}