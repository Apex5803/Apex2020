/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.swervedrivespecialties.exampleswerve.commands.ElevatorCommands;

import com.swervedrivespecialties.exampleswerve.Robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class MoveToColorWheelPosition extends CommandBase {
  /**
   * Creates a new ExtendColorWheel.
   */
  public MoveToColorWheelPosition() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if(Robot.elevator.ColorWheelLockExtended == true && Robot.elevator.ElevatorRotatorExtended == true){
    Robot.elevator.retractColorWheelLock();
    Robot.elevator.RetractElevator();
    }
    else if(Robot.elevator.ElevatorRotatorExtended == true){
      Robot.elevator.RetractElevator();
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.elevator.extendColorWheelLock();
    Robot.elevator.ExtendElevator();
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
