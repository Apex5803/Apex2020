package com.swervedrivespecialties.exampleswerve;

public class ConfigValues{
    //TODO PID Tuning
    public static double Shooter_P = .8;
    public static double Shooter_I = 0.0;
    public static double Shooter_D = 14.0;
    public static double Shooter_F = 0.05;



    public static double Tunnel_P = 0;
    public static double Tunnel_I = 0;
    public static double Tunnel_D = 0;
    public static double Tunnel_F = 0;

 
    public static double Elevator_P = 0;
    public static double Elevator_I = 0;
    public static double Elevator_D = 0;
    public static double Elevator_F = 0;


    public static double Spinner_P = 0;
    public static double Spinner_I = 0;
    public static double Spinner_D = 0;
    public static double Spinner_F = 0;

    public static double Spinner_Peak_Output = 1;

    public static double Shooter_Test_Speed = 5000;

    public static int colorWheelRPMS = 30;

    public static double pixyTargetScaleModifier = 2.0;

    public static double XboxDriverLeftStickDeadband = 0.10;
    public static int LowestClimbPositionLimiting = 490; //TODO Set these value after testing
    public static int HighestClimbPosition = 1500;
    public static int MidClimbPosition = 1000;
    public static int LowestElevatorPosition = 10;
    public static int LowestClimbPosition = 500;


}
