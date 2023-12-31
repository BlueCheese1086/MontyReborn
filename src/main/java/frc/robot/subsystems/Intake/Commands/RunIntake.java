package frc.robot.subsystems.Intake.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake.Intake;

public class RunIntake extends CommandBase {
    private final Intake intake;
    private final double speed;

    public RunIntake(Intake intake, double speed) {
        this.intake = intake;
        this.speed = speed;
    }

    @Override
    public void execute() {
        intake.setSpeed(speed);
    }

    @Override
    public void end(boolean interrupted) {
        intake.setSpeed(0);
    }
}