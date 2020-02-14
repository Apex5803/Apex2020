/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.swervedrivespecialties.exampleswerve.commands.DriveTrainCommands;

import com.swervedrivespecialties.exampleswerve.Robot;

import edu.wpi.first.wpilibj.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class AutoDrive extends CommandBase {
  /**
   * Creates a new AutoDrive.
   */
  Translation2d translation;
  double turn;
  double currentHeading;
  double deltaAngle;
  double deltaAnglePostMath;
  
  public AutoDrive(Translation2d translation, double turnAngle) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.translation = translation;
    this.turn = turnAngle;
    this.currentHeading = Robot.drivetrain.getRealAngle();
    this.deltaAngle = turnAngle - currentHeading;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (deltaAngle > 180){
      deltaAnglePostMath = ((deltaAngle - 360)/180);
    }
    else if (deltaAngle < -180){
      deltaAnglePostMath = ((360 + deltaAngle)/180);
    }
    else deltaAnglePostMath = (deltaAngle/180);

    Robot.drivetrain.drive(translation, deltaAnglePostMath, true);
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
