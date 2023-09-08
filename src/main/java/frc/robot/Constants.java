// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

public final class Constants {
    public class DriveConstants {
        // Motor IDs
        public static final int FrontLeftID = 0;
        public static final int FrontRightID = 0; // inverted
        public static final int BackLeftID = 0; // follows frontLeft
        public static final int BackRightID = 0; // follows backRight

        // Other constants
        public static final double deadband = 0.02;
        public static final double maxSpeed = 0.5;
        public static final boolean squareInputs = true;
    }

    public class IntakeConstants {
        // Motor IDs
        public static final int FrontRollerID = 0; // follows bottomTrack
        public static final int LeftIndexerID = 0; // inverted, follows bottomTrack
        public static final int RightIndexerID = 0; // follows bottomTrack
        public static final int BottomTrackID = 0;
        public static final int LeftSolenoidID = 0;
        public static final int RightSolenoidID = 0; // follows leftSolenoid
    }
    
    public class TowerConstants {
        // Motor IDs
        public static final int HoodSolenoidID = 0;
        public static final int TopRoller1ID = 0;
        public static final int TopRoller2ID = 0; // inverted, follows topRoller1
        public static final int BottomRoller1ID = 0; // follows topRoller1
        public static final int BottomRoller2ID = 0; // inverted, follows topRoller1
    }
}