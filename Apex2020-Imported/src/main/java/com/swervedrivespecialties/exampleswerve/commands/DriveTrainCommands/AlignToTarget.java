/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.swervedrivespecialties.exampleswerve.commands.DriveTrainCommands;

import com.swervedrivespecialties.exampleswerve.Robot;

import org.frcteam2910.common.robot.Utilities;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.geometry.Translation2d;

public class AlignToTarget extends Command {
  /**
   * Creates a new AlignToTarget.
   */
  public AlignToTarget() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double forward = -Robot.getOi().getXbox1().getRawAxis(1);
    forward = Utilities.deadband(forward);
    // Square the forward stick
    forward = Math.copySign(Math.pow(forward, 2.0), forward);

    double strafe = -Robot.getOi().getXbox1().getRawAxis(0);
    strafe = Utilities.deadband(strafe);
    // Square the strafe stick
    strafe = Math.copySign(Math.pow(strafe, 2.0), strafe);

    double rotation = Robot.limelight.getSteerCommand();
    rotation = Utilities.deadband(rotation);
    // // Square the rotation stick
    // rotation = Math.copySign(Math.pow(rotation, 2.0), rotation);

    // Robot.drivetrain.drive(new Translation2d(forward, strafe), rotation, Robot.drivetrain.fieldOriented);
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
