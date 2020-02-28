package com.swervedrivespecialties.exampleswerve;

import com.swervedrivespecialties.exampleswerve.commands.AutoCommands.MoveAwayFromDriverStation;
import com.swervedrivespecialties.exampleswerve.commands.ShooterCommands.RetractHood;
import com.swervedrivespecialties.exampleswerve.subsystems.*;
import com.swervedrivespecialties.exampleswerve.utils.ColorChangeCounter;
import com.swervedrivespecialties.exampleswerve.utils.GameData;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode.PixelFormat;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
// import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


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
        oi = new OI();
        UsbCamera camera1 = CameraServer.getInstance().startAutomaticCapture(0);
        camera1.setVideoMode(PixelFormat.kMJPEG, 160, 120, 20);// pixel format, x pixels, y pixels, FPS

        
        
        
        // limelight.enableLED();
    }

    @Override
    public void robotPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putNumber("ShooterRPMS", shooter.getRPMS());
    //    SmartDashboard.putNumber("SteerCommand", limelight.getSteerCommand());
    }


    public void disabledInit(){
        // limelight.disableLED();
    }

    public void disabledPeriodic(){

    }

    public void autonomousInit(){
        
        // new MoveAwayFromDriverStation();

    }

    public void autonomousPeriodic(){

    }

    
    public void teleopInit(){
        // new RetractHood();
        
    }

    public void teleopPeriodic(){
        

    }
}
