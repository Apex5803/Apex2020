/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.swervedrivespecialties.exampleswerve.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import com.swervedrivespecialties.exampleswerve.commands.*;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class CollectBalls extends ParallelCommandGroup {
  /**
   * Creates a new CollectBalls.
   */
  public CollectBalls() {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());super();

    super(new ExtendIntake(), new IntakeInVariable());
  }
}
