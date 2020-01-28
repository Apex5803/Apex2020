package com.swervedrivespecialties.exampleswerve;

public class RobotMap {
    public static final int DRIVETRAIN_FRONT_LEFT_ANGLE_MOTOR = 2; // PWM
    public static final int DRIVETRAIN_FRONT_LEFT_ANGLE_ENCODER = 0; // Analog
    public static final int DRIVETRAIN_FRONT_LEFT_DRIVE_MOTOR = 1; // CAN

    public static final int DRIVETRAIN_FRONT_RIGHT_ANGLE_MOTOR = 4; // PWM
    public static final int DRIVETRAIN_FRONT_RIGHT_ANGLE_ENCODER = 1; // Analog
    public static final int DRIVETRAIN_FRONT_RIGHT_DRIVE_MOTOR = 3; // CAN

    public static final int DRIVETRAIN_BACK_LEFT_ANGLE_MOTOR = 6; // PWM
    public static final int DRIVETRAIN_BACK_LEFT_ANGLE_ENCODER = 2; // Analog
    public static final int DRIVETRAIN_BACK_LEFT_DRIVE_MOTOR = 5; // CAN

    public static final int DRIVETRAIN_BACK_RIGHT_ANGLE_MOTOR = 8; // PWM
    public static final int DRIVETRAIN_BACK_RIGHT_ANGLE_ENCODER = 3; // Analog
    public static final int DRIVETRAIN_BACK_RIGHT_DRIVE_MOTOR = 7; // CAN


    public static final int Intake1 = 10; //CAN
    public static final int IntakeExtender_ForwardChannel = 0; //PCM
    public static final int IntakeExtender_ReverseChannel = 1;


    public static final int Shooter1 = 13; //CAN
    public static final int Shooter2 = 1;


    public static final int Tunnel1 = 11;
    public static final int TunnelPiston_ForwardChannel =  2;
    public static final int TunnelPiston_ReverseChannel = 3;


    public static final int Elevator1 = 9;
    public static final int ElevatorRotator_ForwardChannel = 4;
    public static final int ElevatorRotator_ReverseChannel = 5;


    public static final int Wheel1 = 12;
    public static final int WheelExtender_ForwardChannel = 6;
    public static final int WheelExtender_ReverseChannel = 7;
}
