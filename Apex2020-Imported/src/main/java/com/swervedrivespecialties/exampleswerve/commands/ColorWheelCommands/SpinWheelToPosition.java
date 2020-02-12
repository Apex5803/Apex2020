/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.swervedrivespecialties.exampleswerve.commands.ColorWheelCommands;

import com.swervedrivespecialties.exampleswerve.ConfigValues;
import com.swervedrivespecialties.exampleswerve.Robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class SpinWheelToPosition extends CommandBase {
  /**
   * Creates a new SpinWheel.
   */
  int specifiedColorChanges;
  public SpinWheelToPosition(int colorChanges) { //pass through a number of color changes (8 times the number of wheel rotations you want)
    // Use addRequirements() here to declare subsystem dependencies.
    this.specifiedColorChanges = colorChanges;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(Robot.colorChangeCounter.countColors() < specifiedColorChanges){
      Robot.colorWheel.spinWheel(ConfigValues.colorWheelRPMS);
    }
    else end(false);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.colorWheel.spinWheel(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(Robot.colorChangeCounter.countColors() >= specifiedColorChanges){
      return true;
    }
    return false;
  }
}
