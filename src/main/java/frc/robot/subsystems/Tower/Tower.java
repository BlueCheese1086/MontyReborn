package frc.robot.subsystems.Tower;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants.TowerConstants;

public class Tower {
    // Creates Solenoids as well, Solenoids
    Solenoid hoodSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, TowerConstants.HoodSolenoidID);

    // Creates motor controllers as TalonFXs and CANSparkMaxes
    TalonFX leftTopRoller = new TalonFX(TowerConstants.LeftTopRollerID);
    TalonFX rightTopRoller = new TalonFX(TowerConstants.RightTopRollerID);
    
    TalonSRX bottomRoller = new TalonSRX(TowerConstants.BottomRollerID);
    
    /** Creates a new Tower subsystem */
    public Tower() {
        // Applying settings to each motor
        rightTopRoller.follow(leftTopRoller);
        rightTopRoller.setInverted(true);

        // If the backup motor is in use, uncomment this.
        //bottomRoller.setInverted(true);
    }

    /** Sets the speed of the tower. */
    public void setSpeed(double speed) {
        SmartDashboard.putNumber("Tower Speed", speed);

        leftTopRoller.set(ControlMode.PercentOutput, speed);
        bottomRoller.set(ControlMode.PercentOutput, speed);
    }

    /** Returns the average speed of the motors.  Doesn't use encoders, so very unreliable. */
    public double getSpeed() {
        return (bottomRoller.getMotorOutputPercent() + leftTopRoller.getMotorOutputPercent()) / 2;
    }

    /** Sets the state of the hood. true is closed, false is open. */
    public void setHood(boolean state) {
        SmartDashboard.putString("Hood", state ? "Closed" : "Open");
        hoodSolenoid.set(state);
    }

    /** Returns the state of the hood. */
    public boolean getHood() {
        return hoodSolenoid.get();
    }
}