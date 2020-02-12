/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.swervedrivespecialties.exampleswerve.utils;

// import com.swervedrivespecialties.exampleswerve.Robot;

import edu.wpi.first.wpilibj.DriverStation;

/**
 * Add your docs here.
 */
public class GameData {
    private static GameData instance;
    
    public String getGameData(){
        
        String GameData= DriverStation.getInstance().getGameSpecificMessage();
        

        if (GameData.length() > 0){
            return GameData;
        }
        else return "N";
    }
    public static GameData getInstance() {
        if (instance == null) {
            instance = new GameData();
        }
    
        return instance;
    }

}
