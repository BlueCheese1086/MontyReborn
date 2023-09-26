package frc.robot.subsystems.Tower;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants.TowerConstants;

public class Tower {
    // Initializes Pneumatics
    Solenoid hood;

    // Creates motor controllers as TalonFXs and CANSparkMaxes
    TalonFX leftTopRoller = new TalonFX(TowerConstants.LeftTopRollerID);
    TalonFX rightTopRoller = new TalonFX(TowerConstants.RightTopRollerID);
    
    TalonSRX bottomRoller = new TalonSRX(TowerConstants.BottomRollerID);
    
    /** Creates a new Tower subsystem */
    public Tower(PneumaticHub hub) {
        // Creating the solenoid
        hood = hub.makeSolenoid(TowerConstants.SolenoidID);

        // Applying settings to each motor
        rightTopRoller.configFactoryDefault();
        leftTopRoller.configFactoryDefault();
        bottomRoller.configFactoryDefault();

        leftTopRoller.setInverted(true);

        hood.set(true);

        // If the backup motor is in use, uncomment this.
        //bottomRoller.setInverted(true);
    }

    /** Sets the speed of the tower. */
    public void setSpeed(double speed) {
        SmartDashboard.putNumber("Tower Speed", speed * 0.6);
        leftTopRoller.set(ControlMode.PercentOutput, speed * 0.6);
        rightTopRoller.set(ControlMode.PercentOutput, speed * 0.6);
        bottomRoller.set(ControlMode.PercentOutput, speed * 0.6);
    }

    /** Returns the average speed of the motors.  Doesn't use encoders, so very unreliable. */
    public double getSpeed() {
        return (bottomRoller.getMotorOutputPercent() + leftTopRoller.getMotorOutputPercent()) / 2;
    }

    /** Sets the state of the hood. true is closed, false is open. */
    public void setHood(boolean state) {
        SmartDashboard.putString("Hood", state ? "Closed" : "Open");
        hood.set(state);
    }

    /** Returns the state of the hood. */
    public boolean getHood() {
        return hood.get();
    }
}