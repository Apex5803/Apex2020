/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.swervedrivespecialties.exampleswerve.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.swervedrivespecialties.exampleswerve.ConfigValues;
import com.swervedrivespecialties.exampleswerve.RobotMap;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.motorcontrol.can.VictorSPXConfiguration;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  /**
   * Creates a new Shooter.
   */
  private static Shooter instance;
  TalonSRX Shooter1 = new TalonSRX(RobotMap.Shooter1);
  VictorSPX Shooter2 = new VictorSPX(RobotMap.Shooter2);
  DoubleSolenoid ShooterHood = new DoubleSolenoid(RobotMap.PDP1ID, RobotMap.ShooterHood_ForwardChannel, RobotMap.ShooterHood_ReverseChannel);
  
 
  public Shooter() {
    Shooter1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    Shooter2.follow(Shooter1);
    Shooter1.config_kP(0, ConfigValues.Shooter_P);
    Shooter1.config_kI(0, ConfigValues.Shooter_I);
    Shooter1.config_kD(0, ConfigValues.Shooter_D);
    Shooter1.config_kF(0, ConfigValues.Shooter_F);
    
    

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

public void Shoot(double RPMs){
  double Ticks_Per_100_MS = (RPMs * 4096 / 600);
Shooter1.set(ControlMode.Velocity, Ticks_Per_100_MS);
}

public void TestShoot(double percent){
Shooter1.set(ControlMode.PercentOutput, percent);
}

public void ExtendHood(){
  ShooterHood.set(Value.kForward);
}

public void RetractHood(){
  ShooterHood.set(Value.kReverse);
}


  public static Shooter getInstance() {
    if (instance == null) {
        instance = new Shooter();
    }

    return instance;
}
}
