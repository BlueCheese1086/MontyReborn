package frc.robot.subsystems.Tower;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import frc.robot.Constants.TowerConstants;

public class Tower {
    Solenoid hoodSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, TowerConstants.HoodSolenoidID);
    TalonFX topRoller1 = new TalonFX(TowerConstants.TopRoller1ID);
    TalonFX topRoller2 = new TalonFX(TowerConstants.TopRoller2ID);
    CANSparkMax bottomRoller1 = new CANSparkMax(TowerConstants.BottomRoller1ID, MotorType.kBrushless);
    CANSparkMax bottomRoller2 = new CANSparkMax(TowerConstants.BottomRoller2ID, MotorType.kBrushless);
    
    public Tower() {
        topRoller2.follow(topRoller1);
        topRoller2.setInverted(true);

        bottomRoller2.follow(bottomRoller1, true);
    }

    // Sets the speed of the tower to the value of 'speed'
    public void setSpeed(double speed) {
        topRoller1.set(TalonFXControlMode.PercentOutput, speed);
        bottomRoller1.set(speed);
    }

    // Returns the average speed of the motors.
    public double getSpeed() {
        return (bottomRoller1.get() + topRoller1.getMotorOutputPercent()) / 2;
    }

    // Sets the state of the hood to the value of 'state'
    public void setHood(boolean state) {
        hoodSolenoid.set(state);
    }

    // Returns the state of the hood.
    public boolean getHood() {
        return hoodSolenoid.get();
    }
}