/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.swervedrivespecialties.exampleswerve.commands.ShooterCommands;

import com.swervedrivespecialties.exampleswerve.ConfigValues;
import com.swervedrivespecialties.exampleswerve.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Shooter_Test extends Command {
  /**
   * Creates a new Shooter_Test.
   */
  public Shooter_Test() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.shooter.TestShoot(ConfigValues.Shooter_Test_Speed);
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
    return false;
  }
}
