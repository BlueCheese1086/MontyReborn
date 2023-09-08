// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Drivetrain.Commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Drivetrain.Drivetrain;

/** An example command that uses an example subsystem. */
public class ArcadeDrive extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Drivetrain drivetrain;
  private final Supplier<Double> xSpeedSupplier;
  private final Supplier<Double> zTurnSupplier;

  /**
   * Creates a new ArcadeDrive command.
   *
   * @param drivetrain The subsystem used by this command.
   * @param xSpeedSupplier The lambda supplier for the forwards velocity of the robot.
   * @param zSpeedSupplier The lambda supplier for the turn velocity of the robot.
   */
  public ArcadeDrive(Drivetrain drivetrain, Supplier<Double> xSpeedSupplier, Supplier<Double> zTurnSupplier) {
    this.drivetrain = drivetrain;
    this.xSpeedSupplier = xSpeedSupplier;
    this.zTurnSupplier = zTurnSupplier;
    addRequirements(drivetrain);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrain.arcadeDrive(xSpeedSupplier.get(), zTurnSupplier.get());
  }
}