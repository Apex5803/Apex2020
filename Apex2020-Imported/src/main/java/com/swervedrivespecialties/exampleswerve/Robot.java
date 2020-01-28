package com.swervedrivespecialties.exampleswerve;

import com.swervedrivespecialties.exampleswerve.subsystems.*;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends TimedRobot {
    public static OI oi;

    private static DrivetrainSubsystem drivetrain;
    public static Intake intake;
    public static Shooter shooter;
    public static Tunnel tunnel;

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
    }

    @Override
    public void robotPeriodic() {
        Scheduler.getInstance().run();
    }
}
