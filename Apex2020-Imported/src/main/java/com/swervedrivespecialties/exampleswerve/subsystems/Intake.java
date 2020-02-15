/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.swervedrivespecialties.exampleswerve.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.swervedrivespecialties.exampleswerve.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  /**
   * Creates a new Intake.
   */
  private static Intake instance;
  TalonSRX Intake1 = new TalonSRX(RobotMap.Intake1);
  DoubleSolenoid IntakeExtender = new DoubleSolenoid(RobotMap.PDP1ID, RobotMap.IntakeExtender_ForwardChannel, RobotMap.IntakeExtender_ReverseChannel);
  public Intake() {

  }

  public void RollIntake(ControlMode controlmode, double speed){
    Intake1.set(controlmode, speed);
  }

  public void ExtendIntake(){
    IntakeExtender.set(Value.kForward);
  }

  public void RetractIntake(){
    IntakeExtender.set(Value.kReverse);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public static Intake getInstance() {
    if (instance == null) {
        instance = new Intake();
    }

    return instance;
}
}
