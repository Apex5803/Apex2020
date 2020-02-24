/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.swervedrivespecialties.exampleswerve.commands.ShooterCommands;

import com.swervedrivespecialties.exampleswerve.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ExtendHood extends Command {
  /**
   * Creates a new ExtendHood.
   */
  public ExtendHood() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.shooter.ExtendHood();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end() {
  }
  @Override
  protected void interrupted() {
    end();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (Robot.shooter.ShooterHood.get() == Value.kForward){
      return true;
    }
    else return false;
  }
}
