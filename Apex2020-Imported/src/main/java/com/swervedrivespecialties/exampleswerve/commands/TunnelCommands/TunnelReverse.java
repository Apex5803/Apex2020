/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.swervedrivespecialties.exampleswerve.commands.TunnelCommands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.swervedrivespecialties.exampleswerve.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TunnelReverse extends Command {
  /**
   * Creates a new TunnelReverse.
   */
  public TunnelReverse() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.tunnel.runTunnel(ControlMode.PercentOutput, -0.50);
    // Robot.tunnel.tunnelUp();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end() {
    Robot.tunnel.runTunnel(ControlMode.PercentOutput, 0.0);
    Robot.tunnel.tunnelDown();
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
