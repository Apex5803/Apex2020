/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.swervedrivespecialties.exampleswerve.commands.ElevatorCommands;

import com.swervedrivespecialties.exampleswerve.Robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class MoveToClimbPosition extends CommandBase {
  /**
   * Creates a new MoveToClimbPosition.
   */
  public MoveToClimbPosition() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if(Robot.elevator.ColorWheelLockExtended == true){
      Robot.elevator.retractColorWheelLock();
    }
    Robot.elevator.ExtendElevator();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
