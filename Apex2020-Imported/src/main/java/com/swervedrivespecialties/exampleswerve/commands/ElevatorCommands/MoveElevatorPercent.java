/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.swervedrivespecialties.exampleswerve.commands.ElevatorCommands;

import com.swervedrivespecialties.exampleswerve.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class MoveElevatorPercent extends Command {
  /**
   * Creates a new MoveElevatorPercent.
   */
  double percent;
  public MoveElevatorPercent(double Input) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.percent = Input;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.elevator.moveElevatorPercent(percent); //lets us set velocity percent where we call the command
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end() {
    Robot.elevator.moveElevatorPercent(0.0);
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
