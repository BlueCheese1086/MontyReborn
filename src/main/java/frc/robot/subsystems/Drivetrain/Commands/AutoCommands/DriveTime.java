package frc.robot.subsystems.Drivetrain.Commands.AutoCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain.Drivetrain;

public class DriveTime extends CommandBase {
    private final Drivetrain drivetrain;
    private final double speed;
    private final double seconds;
    private double end;

    public DriveTime(Drivetrain drivetrain, double speed, double seconds) {
        this.drivetrain = drivetrain;
        this.speed = speed;
        this.seconds = seconds;
    }

    @Override
    public void initialize() {
        this.end = System.currentTimeMillis() + seconds * 1000;
    }

    @Override
    public void execute() {
        drivetrain.arcadeDrive(speed, 0);
    }

    @Override
    public boolean isFinished() {
        return System.currentTimeMillis() == end;
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.arcadeDrive(0, 0);
    }
}