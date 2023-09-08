package frc.robot.subsystems.Intake;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class Intake extends SubsystemBase {
    Solenoid leftSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, IntakeConstants.LeftSolenoidID);
    Solenoid rightSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, IntakeConstants.RightSolenoidID);
    CANSparkMax frontRoller = new CANSparkMax(IntakeConstants.FrontRollerID, MotorType.kBrushless);
    CANSparkMax leftIndexer = new CANSparkMax(IntakeConstants.LeftIndexerID, MotorType.kBrushless);
    CANSparkMax rightIndexer = new CANSparkMax(IntakeConstants.RightIndexerID, MotorType.kBrushless);
    CANSparkMax bottomTrack = new CANSparkMax(IntakeConstants.BottomTrackID, MotorType.kBrushless);

    public Intake() {
        frontRoller.follow(bottomTrack);
        leftIndexer.follow(bottomTrack, true);
        rightIndexer.follow(bottomTrack);
    }

    public void setSpeed(double speed) {
        bottomTrack.set(speed);
    }

    public double getSpeed() {
        return bottomTrack.get();
    }

    public void setState(boolean state) {
        leftSolenoid.set(state);
        rightSolenoid.set(state);
    }

    public boolean getState() {
        return leftSolenoid.get();
    }
}