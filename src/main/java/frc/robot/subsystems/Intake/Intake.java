package frc.robot.subsystems.Intake;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.IntakeConstants;

public class Intake extends SubsystemBase {
    // Creates solenoids as well, Solenoid objects.
    Solenoid leftSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, IntakeConstants.LeftSolenoidID);
    Solenoid rightSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, IntakeConstants.RightSolenoidID);

    // Creates each motor controller as CANSparkMax objects.
    TalonSRX frontRoller = new TalonSRX(IntakeConstants.FrontRollerID);
    TalonSRX leftIndexer = new TalonSRX(IntakeConstants.LeftIndexerID);
    TalonSRX rightIndexer = new TalonSRX(IntakeConstants.RightIndexerID);

    /** Creates a new Intake subsystem */
    public Intake() {
        // Applying settings to each motor
        leftIndexer.follow(frontRoller);
        leftIndexer.setInverted(true);
        rightIndexer.follow(frontRoller);
    }

    /** Sets the speed of the intake. */
    public void setSpeed(double speed) {
        SmartDashboard.putNumber("Intake Speed", speed);

        // Only sets the speed of the front roller because all of the other motors follow it.
        frontRoller.set(ControlMode.PercentOutput, speed);
    }

    /** Gets the speed of the intake.  Doesn't use encoders, so very unreliable. */
    public double getSpeed() {
        return frontRoller.getMotorOutputPercent();
    }

    /** Sets the state of the solenoids attached to the intake.  true is open, false is closed. */
    public void setState(boolean state) {
        SmartDashboard.putString("Intake State", state ? "Open" : "Closed");

        leftSolenoid.set(state);
        rightSolenoid.set(state);
    }

    /** Gets the state of the solenoids. */
    public boolean getState() {
        // Only gets the state of one solenoid as they are manipulated together.
        return leftSolenoid.get();
    }
}