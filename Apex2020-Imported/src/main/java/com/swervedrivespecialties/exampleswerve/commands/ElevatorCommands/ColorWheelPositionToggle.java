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

public class ColorWheelPositionToggle extends Command {
  /**
   * Creates a new ExtendColorWheel.
   */
  public ColorWheelPositionToggle() {
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
  if(Robot.elevator.ButtonPressCount % 2 == 0){
    Robot.elevator.extendColorWheelLock();
    Robot.elevator.ExtendElevator();
  }
  else{Robot.elevator.extendColorWheelLock();} 
    Math.incrementExact(Robot.elevator.ButtonPressCount);
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
