/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.swervedrivespecialties.exampleswerve.commands.AutoCommands;

import com.swervedrivespecialties.exampleswerve.commands.DriveTrainCommands.AutoDrive;
import com.swervedrivespecialties.exampleswerve.commands.IntakeCommands.ExtendIntake;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.geometry.Translation2d;

public class MoveAwayFromDriverStation extends CommandGroup {
  /**
   * Add your docs here.
   */
  public MoveAwayFromDriverStation() {
    // Add Commands here:
    // e.g. addSequential(new Command1());
    // addSequential(new Command2());
    // these will run in order.

    // To run multiple commands at the same time,
    // use addParallel()
    // e.g. addParallel(new Command1());
    // addSequential(new Command2());
    // Command1 and Command2 will run in parallel.

    // A command group will require all of the subsystems that each member
    // would require.
    // e.g. if Command1 requires chassis, and Command2 requires arm,
    // a CommandGroup containing them would require both the chassis and the
    // arm.
    addParallel(new AutoDrive(new Translation2d(1,0), 180, true), 2.0);
    addParallel(new ExtendIntake());
  }
}
