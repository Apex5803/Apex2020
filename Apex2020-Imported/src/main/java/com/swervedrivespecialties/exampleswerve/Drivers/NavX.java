package com.swervedrivespecialties.exampleswerve.Drivers;

import com.kauailabs.navx.frc.AHRS;
import com.kauailabs.navx.frc.AHRS.SerialDataType;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SerialPort.Port;
import org.frcteam2910.common.drivers.Gyroscope;
import org.frcteam2910.common.math.Rotation2;

public final class NavX extends Gyroscope {
    private final AHRS navX;

    public NavX(SPI.Port port) {
        this(port, (byte) 200);
    }

    public NavX(SPI.Port port, byte updateRate) {
        navX = new AHRS(port, updateRate);
    }

    public NavX(int USB_Port){
        if(USB_Port == 1){
            navX = new AHRS(Port.kUSB1, SerialDataType.kProcessedData, (byte) 200);
        }
        else if (USB_Port == 2){
            navX = new AHRS(Port.kUSB2, SerialDataType.kProcessedData, (byte) 200);
        }
        else {
            System.out.println("error initializing navX, please provide a USB port in the future");
        navX = new AHRS(Port.kUSB, SerialDataType.kProcessedData, (byte) 200);}
        
    }

    @Override
    public void calibrate() {
        navX.reset();
    }

    @Override
    public Rotation2 getUnadjustedAngle() {
        return Rotation2.fromRadians(getAxis(Axis.YAW));
    }

    @Override
    public double getUnadjustedRate() {
        return Math.toRadians(navX.getRate());
    }

    public double getAxis(Axis axis) {
        switch (axis) {
            case PITCH:
                return Math.toRadians(navX.getPitch());
            case ROLL:
                return Math.toRadians(navX.getRoll());
            case YAW:
                return Math.toRadians(navX.getYaw());
            default:
                return 0.0;
        }
    }

    public enum Axis {
        PITCH,
        ROLL,
        YAW
    }
}
