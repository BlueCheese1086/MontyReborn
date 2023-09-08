// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

public final class Constants {
    public class DriveConstants {
        // Motor IDs
        public static final int FrontLeftID = 1;
        public static final int FrontRightID = 2;
        public static final int BackLeftID = 3;
        public static final int BackRightID = 4;

        // Other constants
        public static final double deadband = 0.02;
        public static final double maxSpeed = 0.5;
        public static final boolean squareInputs = true;
    }

    public class IntakeConstants {
        // Motor/Solenoid IDs
        public static final int FrontRollerID = 11;
        public static final int LeftIndexerID = 12;
        public static final int RightIndexerID = 13;
        public static final int BottomTrackID = 14;
        public static final int LeftSolenoidID = 0;
        public static final int RightSolenoidID = 0;
    }
    
    public class TowerConstants {
        // Motor/Solenoid IDs
        public static final int TopRoller1ID = 21;
        public static final int TopRoller2ID = 22;
        public static final int BottomRoller1ID = 23;
        public static final int BottomRoller2ID = 24;
        public static final int HoodSolenoidID = 0;
    }
}