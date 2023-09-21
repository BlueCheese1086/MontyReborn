package frc.robot.subsystems.Tower;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants.TowerConstants;

public class Tower {
    // Creates Solenoids as well, Solenoids
    Solenoid hoodSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, TowerConstants.HoodSolenoidID);

    // Creates motor controllers as TalonFXs and CANSparkMaxes
    TalonFX topRoller1 = new TalonFX(TowerConstants.TopRoller1ID);
    TalonFX topRoller2 = new TalonFX(TowerConstants.TopRoller2ID);
    CANSparkMax bottomRoller1 = new CANSparkMax(TowerConstants.BottomRoller1ID, MotorType.kBrushless);
    CANSparkMax bottomRoller2 = new CANSparkMax(TowerConstants.BottomRoller2ID, MotorType.kBrushless);
    
    /** Creates a new Tower subsystem */
    public Tower() {
        // Applying settings to each motor
        CANSparkMax[] motors = {bottomRoller1, bottomRoller2};
        for (CANSparkMax motor : motors) {
            motor.restoreFactoryDefaults();
            motor.setIdleMode(IdleMode.kBrake);
            motor.setSmartCurrentLimit(45);
        }

        topRoller2.follow(topRoller1);
        topRoller2.setInverted(true);

        bottomRoller2.follow(bottomRoller1, true);
    }

    /** Sets the speed of the tower. */
    public void setSpeed(double speed) {
        SmartDashboard.putNumber("Tower Speed", speed);

        topRoller1.set(TalonFXControlMode.PercentOutput, speed);
        bottomRoller1.set(speed);
    }

    /** Returns the average speed of the motors.  Doesn't use encoders, so very unreliable. */
    public double getSpeed() {
        return (bottomRoller1.get() + topRoller1.getMotorOutputPercent()) / 2;
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