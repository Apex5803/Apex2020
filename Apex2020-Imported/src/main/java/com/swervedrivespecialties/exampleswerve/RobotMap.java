package com.swervedrivespecialties.exampleswerve;

public class RobotMap {
    public static final int DRIVETRAIN_FRONT_LEFT_ANGLE_MOTOR = 0; // CAN
    public static final int DRIVETRAIN_FRONT_LEFT_ANGLE_ENCODER = 2; // Analog
    public static final int DRIVETRAIN_FRONT_LEFT_DRIVE_MOTOR = 1; // CAN

    public static final int DRIVETRAIN_FRONT_RIGHT_ANGLE_MOTOR = 2; // CAN
    public static final int DRIVETRAIN_FRONT_RIGHT_ANGLE_ENCODER = 0; // Analog
    public static final int DRIVETRAIN_FRONT_RIGHT_DRIVE_MOTOR = 3; // CAN

    public static final int DRIVETRAIN_BACK_LEFT_ANGLE_MOTOR = 6; // CAN
    public static final int DRIVETRAIN_BACK_LEFT_ANGLE_ENCODER = 3; // Analog
    public static final int DRIVETRAIN_BACK_LEFT_DRIVE_MOTOR = 7; // CAN

    public static final int DRIVETRAIN_BACK_RIGHT_ANGLE_MOTOR = 4; // CAN
    public static final int DRIVETRAIN_BACK_RIGHT_ANGLE_ENCODER = 1; // Analog
    public static final int DRIVETRAIN_BACK_RIGHT_DRIVE_MOTOR = 5; // CAN

    public static final int PigeonID = 0;

    public static final int Intake1 = 10; //CAN
    public static final int IntakeExtender_ForwardChannel = 4; //PCM 1
    public static final int IntakeExtender_ReverseChannel = 1; //PCM 1


    public static final int Shooter1 = 13; //CAN
    public static final int Shooter2 = 1;// CAN
    public static final int ShooterHood_ForwardChannel = 3;
    public static final int ShooterHood_ReverseChannel = 0;


    public static final int Tunnel1 = 11;// CAN
    public static final int TunnelPiston_ForwardChannel =  5; //PCM 1
    public static final int TunnelPiston_ReverseChannel = 2; //PCM 1 


    public static final int Elevator1 = 9;// CAN
    public static final int Elevator2 = 15;// CAN
    public static final int ElevatorRotator_ForwardChannel = 2; //PCM 2
    public static final int ElevatorRotator_ReverseChannel = 1; //PCM 2
    public static final int ElevatorClimbLock_ForwardChannel = 3; //PCM
    public static final int ElevatorClimbLock_ReverseChannel = 0; //PCM


    public static final int Wheel1 = 12;// CAN
    public static final int ElevatorWheelPositionLock_ForwardChannel = 7; //PCM 1
    public static final int ElevatorWheelPositionLock_ReverseChannel = 6; //PCM 1

    public static final int Pixy2SPI_ID = 1;

    public static final int LEDRingID = 4;

    public static final int PDP1ID = 0;
    public static final int PDP2ID = 1;
}
