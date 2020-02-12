/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.swervedrivespecialties.exampleswerve.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.swervedrivespecialties.exampleswerve.ConfigValues;
import com.swervedrivespecialties.exampleswerve.Robot;
import com.swervedrivespecialties.exampleswerve.RobotMap;
// import com.swervedrivespecialties.exampleswerve.utils.GameData;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;

public class ColorWheel extends SubsystemBase {
  /**
   * Creates a new ColorWheel.
   */
  TalonSRX Wheel1 = new TalonSRX(RobotMap.Wheel1);
    DoubleSolenoid WheelExtender = new DoubleSolenoid(RobotMap.WheelExtender_ForwardChannel, RobotMap.WheelExtender_ReverseChannel);
    String assignedColor = Robot.gameData.getGameData();
    private final I2C.Port i2cPort = I2C.Port.kOnboard;
    private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
    private final ColorMatch m_colorMatcher = new ColorMatch();
    private final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
    private final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
    private final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
    private final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);  
    private static ColorWheel instance = new ColorWheel();
    

  public ColorWheel() {
    Wheel1.configPeakOutputForward(ConfigValues.Spinner_Peak_Output);
    Wheel1.configPeakOutputReverse(-1 * ConfigValues.Spinner_Peak_Output);
    Wheel1.config_kP(0, ConfigValues.Spinner_P);
    Wheel1.config_kI(0, ConfigValues.Spinner_I);
    Wheel1.config_kD(0, ConfigValues.Spinner_D);
    Wheel1.config_kF(0, ConfigValues.Spinner_F);
    Wheel1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    m_colorMatcher.addColorMatch(kBlueTarget);
    m_colorMatcher.addColorMatch(kGreenTarget);
    m_colorMatcher.addColorMatch(kRedTarget);
    m_colorMatcher.addColorMatch(kYellowTarget);  
    Wheel1.setNeutralMode(NeutralMode.Brake);



  }
  Color detectedColor = m_colorSensor.getColor();
  String colorString;
  ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);


  //gets color measured at robot
  public String getRobotColorString(){
    if (match.color == kBlueTarget){
      return "B";
    }
    else if (match.color == kRedTarget){
      return "R";
    }
    else if (match.color == kGreenTarget){
      return "G";
    }
    else if (match.color == kYellowTarget){
      return "Y";
    }
    else {
      return "N";
    }
  }

//extrapolates from robot measured color (using 90 degree rotation) to actual color position on field
  public String getFieldColorString(){
    if (match.color == kBlueTarget){
      return "R";
    }
    else if (match.color == kRedTarget){
      return "B";
    }
    else if (match.color == kGreenTarget){
      return "Y";
    }
    else if (match.color == kYellowTarget){
      return "G";
    }
    else {
      return "N";
    }
  }
//gets sensor's confidence in color decision as a double between 0 and 1, 0 is no confidence and 1 is full confidence
  public double getColorConfidence(){
    return match.confidence;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
  }
  

  public void extendWheel(){
    WheelExtender.set(Value.kForward);
  }

  public void retractWheel(){
    WheelExtender.set(Value.kReverse);
  }

  public void spinWheel(double percentSpeed){
    Wheel1.set(ControlMode.PercentOutput, percentSpeed);
  }

  public void spinWheel(int wheelRPMs){
    Wheel1.set(ControlMode.Velocity, wheelRPMs * 4096 / 600);
  }

  public void setWheel(int wheelPosition){
    Wheel1.set(ControlMode.MotionMagic, wheelPosition);
  }
  public static ColorWheel getInstance() {
    if (instance == null) {
        instance = new ColorWheel();
    }
    return instance;
  }
}
