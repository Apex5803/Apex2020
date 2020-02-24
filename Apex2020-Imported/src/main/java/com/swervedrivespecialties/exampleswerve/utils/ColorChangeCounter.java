/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.swervedrivespecialties.exampleswerve.utils;

import com.swervedrivespecialties.exampleswerve.Robot;

/**
 * Add your docs here.
 */
public class ColorChangeCounter {
    int deltaColorCount;
    String currentColor;
    String lastColor;
    private static ColorChangeCounter instance;

    public ColorChangeCounter(){
        //initializes the variables to 0 and neutral so that it doesnt crash us or give us false values
        int deltaColorCount = 0;
        String currentColor = "N";
        String lastColor = "N";
        
    }


    // public int countColors(){
    //     currentColor = Robot.colorWheel.getRobotColorString();
    //     if (currentColor != lastColor && currentColor != "N"){
    //         deltaColorCount = Math.incrementExact(deltaColorCount);
    //     }

    //     if (currentColor == "N"){
    //         deltaColorCount = 0;
    //     }
    //     lastColor = currentColor;
        
    //     return deltaColorCount;
    // }

    // public static ColorChangeCounter getInstance(){
    //     if (instance == null) {
    //         instance = new ColorChangeCounter();
    //     }
    //     return instance;
    // }
}