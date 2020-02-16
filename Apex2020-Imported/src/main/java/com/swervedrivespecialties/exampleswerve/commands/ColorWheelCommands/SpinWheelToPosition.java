/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.swervedrivespecialties.exampleswerve.commands.ColorWheelCommands;

import com.swervedrivespecialties.exampleswerve.ConfigValues;
import com.swervedrivespecialties.exampleswerve.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class SpinWheelToPosition extends Command {
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
    else end();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end() {
    Robot.colorWheel.spinWheel(0);
  }
  @Override
  protected void interrupted() {
    end();
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
