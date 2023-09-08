package frc.robot.subsystems.Drivetrain.Commands.AutoCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Tower.Tower;

public class RunTowerTime extends CommandBase {
    private final Tower tower;
    private final double speed;
    private final double seconds;
    private double end;

    public RunTowerTime(Tower tower, double speed, double seconds) {
        this.tower = tower;
        this.speed = speed;
        this.seconds = seconds;
    }

    @Override
    public void initialize() {
        this.end = System.currentTimeMillis() + seconds * 1000;
    }

    @Override
    public void execute() {
        tower.setSpeed(speed);
    }

    @Override
    public boolean isFinished() {
        return System.currentTimeMillis() == end;
    }

    @Override
    public void end(boolean interrupted) {
        tower.setSpeed(0);
    }
}