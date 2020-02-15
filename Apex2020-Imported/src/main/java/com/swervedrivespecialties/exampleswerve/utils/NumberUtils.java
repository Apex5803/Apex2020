/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.swervedrivespecialties.exampleswerve.utils;
/**
 * Add your docs here.
 */
public class NumberUtils {

    public static double TwoEntryDeadzoneX(double x, double y, double deadzone_radius){
        if (Math.abs(Math.hypot(x, y)) < deadzone_radius){
           return 0;
        }
        else return x;
    }
    
    public static double TwoEntryDeadzoneY(double x, double y, double deadzone_radius){
        if (Math.abs(Math.hypot(x, y)) < deadzone_radius){
           return 0;
        }
        else return y;
    }

    public static void TwoEntryDeadzoneXY(double x, double y, double deadzone_radius){
        if (Math.abs(Math.hypot(x, y)) < deadzone_radius){
           x = 0;
           y = 0;
        }
    }
}
