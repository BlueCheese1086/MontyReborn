package frc.robot.subsystems.Drivetrain.Commands.AutoCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake.Intake;

public class RunIntakeTime extends CommandBase {
    private final Intake intake;
    private final double speed;
    private final double seconds;
    private double end;

    public RunIntakeTime(Intake intake, double speed, double seconds) {
        this.intake = intake;
        this.speed = speed;
        this.seconds = seconds;
    }

    @Override
    public void initialize() {
        this.end = System.currentTimeMillis() + seconds * 1000;
    }

    @Override
    public void execute() {
        intake.setSpeed(speed);
    }

    @Override
    public boolean isFinished() {
        return System.currentTimeMillis() == end;
    }

    @Override
    public void end(boolean interrupted) {
        intake.setSpeed(0);
    }
}