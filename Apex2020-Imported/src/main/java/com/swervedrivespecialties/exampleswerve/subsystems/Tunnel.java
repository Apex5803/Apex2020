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
import com.swervedrivespecialties.exampleswerve.PIDValues;
import com.swervedrivespecialties.exampleswerve.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Tunnel extends SubsystemBase {
  /**
   * Creates a new Tunnel.
   */
    
   TalonSRX Tunnel1 = new TalonSRX(RobotMap.Tunnel1);
   DoubleSolenoid TunnelPiston = new DoubleSolenoid(RobotMap.TunnelPiston_ForwardChannel, RobotMap.TunnelPiston_ReverseChannel);
   private static Tunnel instance;
  
  public Tunnel() {


    //uncomment following section if we switch to PID control for the tunnel
    // Tunnel1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    // Tunnel1.config_kP(0, PIDValues.Tunnel_P);
    // Tunnel1.config_kI(0, PIDValues.Tunnel_I);
    // Tunnel1.config_kD(0, PIDValues.Tunnel_D);
    // Tunnel1.config_kF(0, PIDValues.Tunnel_F);
  }

public void runTunnel(ControlMode controlmode, double speed){
    Tunnel1.set(controlmode, speed);
}

public void tunnelUp(){
TunnelPiston.set(Value.kForward);
} 
public void tunnelDown(){
  TunnelPiston.set(Value.kReverse);
}
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public static Tunnel getInstance() {
    if (instance == null) {
        instance = new Tunnel();
    }

    return instance;
  }
}
