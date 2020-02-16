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
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.swervedrivespecialties.exampleswerve.ConfigValues;
import com.swervedrivespecialties.exampleswerve.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {
  /**
   * Creates a new Elevator.
   */
TalonSRX Elevator1 = new TalonSRX(RobotMap.Elevator1);
VictorSPX Elevator2 = new VictorSPX(RobotMap.Elevator2);
public DoubleSolenoid ElevatorRotator = new DoubleSolenoid(RobotMap.PDP1ID, RobotMap.ElevatorRotator_ForwardChannel,RobotMap.ElevatorRotator_ReverseChannel);
public DoubleSolenoid ColorWheelLock = new DoubleSolenoid(RobotMap.PDP1ID, RobotMap.ElevatorWheelPositionLock_ForwardChannel, RobotMap.ElevatorWheelPositionLock_ReverseChannel);
public DoubleSolenoid ElevatorClimbLock = new DoubleSolenoid(RobotMap.PDP1ID, RobotMap.ElevatorClimbLock_ForwardChannel, RobotMap.ElevatorClimbLock_ReverseChannel);
private static Elevator instance;
public boolean ElevatorRotatorExtended;
public boolean ColorWheelLockExtended;
public boolean ClimbLockEngaged;
public int ButtonPressCount;

  public Elevator() {
    Elevator1.config_kP(0, ConfigValues.Elevator_P);
    Elevator1.config_kI(0, ConfigValues.Elevator_I);
    Elevator1.config_kD(0, ConfigValues.Elevator_D);
    Elevator1.config_kF(0, ConfigValues.Elevator_F);
    Elevator1.setNeutralMode(NeutralMode.Brake);
    Elevator2.follow(Elevator1);
    ElevatorRotatorExtended = true;
    ColorWheelLockExtended = true;
    ClimbLockEngaged = false;
    ButtonPressCount = 0;
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


  public void ExtendElevator(){
    ElevatorRotator.set(Value.kForward);
    ElevatorRotatorExtended = true;
  }

  public void RetractElevator(){
    ElevatorRotator.set(Value.kReverse);
    ElevatorRotatorExtended = false;
  }

  public void moveElevatorPosition(int EncoderPosition){
    if(ClimbLockEngaged = true &&  EncoderPosition < getElevatorPosition){
      retractElevatorClimbLock();
      ClimbLockEngaged = false;
    }
    Elevator1.set(ControlMode.MotionMagic, EncoderPosition);

  }

  public void moveElevatorPercent(double PercentOutput){
    if(ClimbLockEngaged = true && PercentOutput < 0){
      retractElevatorClimbLock();
      ClimbLockEngaged = false;
    }
    Elevator1.set(ControlMode.PercentOutput, PercentOutput);
  }


  public void extendColorWheelLock(){
    ColorWheelLock.set(Value.kForward);
    ColorWheelLockExtended = true;
  }
  public void retractColorWheelLock(){
    ColorWheelLock.set(Value.kReverse);
    ColorWheelLockExtended = false;
  }

  public void extendElevatorClimbLock(){
    if(getElevatorPosition > ConfigValues.LowestClimbPositionLimiting){
    ElevatorClimbLock.set(Value.kForward);
    ClimbLockEngaged = true;
  }
}
  public void retractElevatorClimbLock(){
    ElevatorClimbLock.set(Value.kReverse);
    ClimbLockEngaged = false;
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
