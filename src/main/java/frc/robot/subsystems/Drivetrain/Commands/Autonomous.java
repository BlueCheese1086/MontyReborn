// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Drivetrain.Commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.subsystems.Drivetrain.Commands.AutoCommands.*;
import frc.robot.subsystems.Drivetrain.Drivetrain;
import frc.robot.subsystems.Intake.Intake;
import frc.robot.subsystems.Tower.Tower;

public final class Autonomous extends SequentialCommandGroup {
  public Autonomous(Drivetrain drivetrain, Intake intake, Tower tower) {
    addCommands(
      new DriveTime(drivetrain, 1, 2),
      new TurnTime(drivetrain, 1, 3),
      new SetIntakeState(intake, true),
      new RunIntakeTime(intake, 1, 2),
      new SetIntakeState(intake, false),
      new SetHoodState(tower, true),
      new RunTowerTime(tower, 1, 3),
      new SetHoodState(tower, false)
    );
  }
}