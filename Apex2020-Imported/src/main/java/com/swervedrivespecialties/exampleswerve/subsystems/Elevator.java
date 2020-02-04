/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.swervedrivespecialties.exampleswerve.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.swervedrivespecialties.exampleswerve.ConfigValues;
import com.swervedrivespecialties.exampleswerve.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {
  /**
   * Creates a new Elevator.
   */
TalonFX Elevator1 = new TalonFX(RobotMap.Elevator1);
DoubleSolenoid ElevatorRotator = new DoubleSolenoid(RobotMap.ElevatorRotator_ForwardChannel,RobotMap.ElevatorRotator_ReverseChannel);
private static Elevator instance;

  public Elevator() {
    Elevator1.config_kP(0, ConfigValues.Elevator_P);
    Elevator1.config_kI(0, ConfigValues.Elevator_I);
    Elevator1.config_kD(0, ConfigValues.Elevator_D);
    Elevator1.config_kF(0, ConfigValues.Elevator_F);
    Elevator1.setNeutralMode(NeutralMode.Brake);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


  public void ExtendElevator(){
    ElevatorRotator.set(Value.kForward);
  }

  public void RetractElevator(){
    ElevatorRotator.set(Value.kReverse);
  }

  public void moveElevator(int EncoderPosition){
    Elevator1.set(ControlMode.MotionMagic, EncoderPosition);

  }

  public void moveElevator(float percentOutput){
    Elevator1.set(ControlMode.PercentOutput, percentOutput);
  }

  public int getElevatorPosition = Elevator1.getSelectedSensorPosition();
  public int getElevatorVelocity = Elevator1.getSelectedSensorVelocity();
 
 
  public static Elevator getInstance() {
    if (instance == null) {
        instance = new Elevator();
    }

    return instance;
}



}
