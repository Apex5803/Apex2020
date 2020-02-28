package com.swervedrivespecialties.exampleswerve;

import com.swervedrivespecialties.exampleswerve.commands.ColorWheelCommands.*;
import com.swervedrivespecialties.exampleswerve.commands.DriveTrainCommands.*;
import com.swervedrivespecialties.exampleswerve.commands.ElevatorCommands.*;
import com.swervedrivespecialties.exampleswerve.commands.IntakeCommands.*;
import com.swervedrivespecialties.exampleswerve.commands.ShooterCommands.*;
import com.swervedrivespecialties.exampleswerve.commands.TunnelCommands.*;
import com.swervedrivespecialties.exampleswerve.subsystems.DrivetrainSubsystem;
import com.swervedrivespecialties.exampleswerve.utils.POVTrigger;
import com.swervedrivespecialties.exampleswerve.utils.TriggerButton;

import org.frcteam2910.common.robot.Utilities;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.InstantCommand;
import edu.wpi.first.wpilibj.geometry.Translation2d;

public class OI {
    /*
       Add your joysticks and buttons here
     */
    private XboxController xbox1 = new XboxController(0);
    private XboxController xbox2 = new XboxController(1);

    public OI() {
        // Back button zeroes the drivetrain
        new JoystickButton(xbox1, 7).whenPressed(
                new InstantCommand(() -> DrivetrainSubsystem.getInstance().resetGyroscope())
        );
        POVTrigger DriverDpadUp = new POVTrigger(xbox1, 0, 0);
        POVTrigger DriverDpadLeft = new POVTrigger(xbox1, 0, 270);
        POVTrigger DriverDpadRight = new POVTrigger(xbox1, 0, 90);
        POVTrigger DriverDpadDown = new POVTrigger(xbox1, 0, 180);
        Button DriverX = new JoystickButton (xbox1, 3);
        Button DriverB = new JoystickButton(xbox1, 2);
        Button DriverA = new JoystickButton(xbox1, 1);
        Button DriverLBumper = new JoystickButton(xbox1, 5);
        TriggerButton DriverLTrigger = new TriggerButton(xbox1, 2);
        Button DriverRBumper = new JoystickButton(xbox1, 6);
        TriggerButton DriverRTrigger = new TriggerButton(xbox1, 3);

        Button OperatorA = new JoystickButton(xbox2, 1);
        Button OperatorB = new JoystickButton(xbox2, 2);
        Button OperatorX = new JoystickButton(xbox2, 3);
        Button OperatorY = new JoystickButton(xbox2, 4);
        Button OperatorBackButton = new JoystickButton(xbox2, 7);
        Button OperatorStartButton = new JoystickButton(xbox2, 8);
        Button OperatorRBumper = new JoystickButton(xbox2, 6);
        Button OperatorLBumper = new JoystickButton(xbox2, 5);
        POVTrigger OperatorDpadUp = new POVTrigger(xbox2, 0, 0);
        POVTrigger OperatorDpadLeft = new POVTrigger(xbox2, 0, 270);
        POVTrigger OperatorDpadRight = new POVTrigger(xbox2, 0, 90);
        POVTrigger OperatorDpadDown = new POVTrigger(xbox2, 0, 180);
        Button OperatorRStickClick = new JoystickButton(xbox2, 10);
        TriggerButton OperatorLeftTrigger = new TriggerButton(xbox2, 2);
        TriggerButton OperatorRightTrigger = new TriggerButton(xbox2, 3);
        TriggerButton OperatorLeftJoystickY = new TriggerButton(xbox2, 1);

        // OperatorA.whenPressed(new ColorWheelPositionToggle());
        // OperatorB.whileHeld(new SpinWheelToColor());
        // OperatorX.whenPressed(new SpinWheelToPosition(24));
        OperatorY.whileHeld(new FeedBalls());
        OperatorX.whileHeld(new TunnelReverse());
        OperatorLeftJoystickY.whileActive(new MoveElevatorPercent());
        // OperatorDpadUp.whenPressed(new MoveElevatorPosition(ConfigValues.HighestClimbPosition));
        // OperatorDpadLeft.whenPressed(new MoveElevatorPosition(ConfigValues.LowestClimbPosition));
        // OperatorDpadRight.whenPressed(new MoveElevatorPosition(ConfigValues.MidClimbPosition));
        // OperatorDpadDown.whenPressed(new MoveElevatorPosition(ConfigValues.LowestElevatorPosition));
        OperatorDpadDown.whenPressed(new LowerElevator());
        OperatorDpadUp.whenPressed(new RaiseElevator());
        OperatorDpadLeft.whenPressed(new ExtendIntake());
        OperatorDpadRight.whenPressed(new RetractIntake());
        // OperatorDpadUp.whenActive(new ExtendIntake());
        // OperatorDpadDown.whenActive(new RetractIntake());
        // OperatorStartButton.whenPressed(new LockElevator());
        // OperatorLBumper.whenPressed(new UnlockElevator());
        // OperatorLBumper.whenPressed(new ToggleIntakePosition());
        // OperatorLBumper.whileHeld(new TunnelReverse());
        OperatorA.whenPressed(new LockElevator());
        OperatorB.whenPressed(new UnlockElevator());
        OperatorRBumper.whileHeld(new Shooter_Test());
        // OperatorBackButton.whenPressed(new RaiseElevator());
        // OperatorRStickClick.whenPressed(new LowerElevator());
        OperatorRightTrigger.whileActive(new IntakeForwardStatic());
        OperatorLeftTrigger.whileActive(new IntakeReverseStatic());


        // DriverB.whileHeld(new AlignToTarget());
        // DriverB.whileHeld(new LimelightShoot());
        // DriverX.whileHeld(new PursueBall());
        // DriverX.whileHeld( new IntakeForwardStatic());       
        // DriverA.whenPressed(new ChangeControlScheme());    
        // DriverDpadUp.whenPressed(new AutoDrive(new Translation2d(0, 0), 0, true));
        // DriverDpadLeft.whenPressed(new AutoDrive(new Translation2d(0, 0), 90, true));
        // DriverDpadRight.whenPressed(new AutoDrive(new Translation2d(0, 0), -90, true));
        // DriverDpadDown.whenPressed(new AutoDrive(new Translation2d(0, 0), 179.999999, true));
        while(Robot.intake.IntakeEnabledForDriver == true){
            DriverLBumper.whenPressed(new RetractIntake());
            DriverRBumper.whenPressed(new ExtendIntake());
            DriverRTrigger.whileActive(new IntakeForwardStatic());
            DriverLTrigger.whileActive(new IntakeReverseStatic());
        }
    }

    public XboxController getXbox1() {
        return xbox1;
    }

    public XboxController getXbox2() {
        return xbox2;
    }

    
}
