package frc.robot.subsystems.Intake;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.IntakeConstants;

public class Intake extends SubsystemBase {
    // Creates solenoids as well, Solenoid objects.
    Solenoid leftSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, IntakeConstants.LeftSolenoidID);
    Solenoid rightSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, IntakeConstants.RightSolenoidID);

    // Creates each motor controller as CANSparkMax objects.
    CANSparkMax frontRoller = new CANSparkMax(IntakeConstants.FrontRollerID, MotorType.kBrushless);
    CANSparkMax leftIndexer = new CANSparkMax(IntakeConstants.LeftIndexerID, MotorType.kBrushless);
    CANSparkMax rightIndexer = new CANSparkMax(IntakeConstants.RightIndexerID, MotorType.kBrushless);
    CANSparkMax bottomTrack = new CANSparkMax(IntakeConstants.BottomTrackID, MotorType.kBrushless);

    /** Creates a new Intake subsystem */
    public Intake() {
        // Applying settings to each motor
        CANSparkMax[] motors = {frontRoller, leftIndexer, rightIndexer, bottomTrack};
        for (CANSparkMax motor : motors) {
            motor.restoreFactoryDefaults();
            motor.setIdleMode(IdleMode.kBrake);
            motor.setSmartCurrentLimit(45);
        }

        frontRoller.follow(bottomTrack);
        leftIndexer.follow(bottomTrack, true);
        rightIndexer.follow(bottomTrack);
    }

    /** Sets the speed of the intake. */
    public void setSpeed(double speed) {
        // Only sets the speed of the bottom track because all of the other motors follow it.
        bottomTrack.set(speed);
    }

    /** Gets the speed of the intake.  Doesn't use encoders, so very unreliable. */
    public double getSpeed() {
        return bottomTrack.get();
    }

    /** Sets the state of the solenoids attached to the intake.  true is open, false is closed. */
    public void setState(boolean state) {
        leftSolenoid.set(state);
        rightSolenoid.set(state);
    }

    /** Gets the state of the solenoids. */
    public boolean getState() {
        // Only gets the state of one solenoid as they are manipulated together.
        return leftSolenoid.get();
    }
}