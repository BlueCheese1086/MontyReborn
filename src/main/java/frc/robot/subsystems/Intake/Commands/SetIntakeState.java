package frc.robot.subsystems.Intake.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake.Intake;

public class SetIntakeState extends CommandBase {
    public final Intake intake;
    public final boolean state;

    public SetIntakeState(Intake intake, boolean state) {
        this.intake = intake;
        this.state = state;
    }

    @Override
    public void execute() {
        intake.setState(state);
    }
}