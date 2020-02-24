package com.swervedrivespecialties.exampleswerve;

import com.swervedrivespecialties.exampleswerve.subsystems.*;
import com.swervedrivespecialties.exampleswerve.utils.ColorChangeCounter;
import com.swervedrivespecialties.exampleswerve.utils.GameData;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
// import edu.wpi.first.wpilibj.DriverStation;


public class Robot extends TimedRobot {
    public static OI oi;

    public static DrivetrainSubsystem drivetrain;
    public static Intake intake;
    public static Shooter shooter;
    public static Tunnel tunnel;
    public static Elevator elevator;
    public static GameData gameData;
    public static ColorWheel colorWheel;
    public static ColorChangeCounter colorChangeCounter;
    public static Limelight limelight;
    public static PixyCam pixyCam;

    public static OI getOi() {
        return oi;
    }

    @Override
    public void robotInit() {
        oi = new OI();
        drivetrain = DrivetrainSubsystem.getInstance();
        intake = Intake.getInstance();
        shooter = Shooter.getInstance();
        tunnel = Tunnel.getInstance();
        elevator = Elevator.getInstance();
        gameData = GameData.getInstance();
        // colorChangeCounter = ColorChangeCounter.getInstance();
        // colorWheel = ColorWheel.getInstance();
        limelight = Limelight.getInstance();
        pixyCam = PixyCam.getInstance();
        
        
        
        limelight.enableLED();
    }

    @Override
    public void robotPeriodic() {
        Scheduler.getInstance().run();
    }


    public void disabledInit(){
        limelight.disableLED();
    }

    public void disabledPeriodic(){

    }

    public void autonomousInit(){

    }

    public void autonomousPeriodic(){

    }

    
    public void teleopInit(){

    }

    public void teleopPeriodic(){
        

    }
}
