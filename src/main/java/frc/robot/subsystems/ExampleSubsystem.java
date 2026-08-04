// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.io.ObjectInputFilter.Config;
import java.util.function.Supplier;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ExampleSubsystem extends SubsystemBase {

  SparkMax motorController = new SparkMax(37, SparkMax.MotorType.kBrushed);


  /** Creates a new ExampleSubsystem. */
  public ExampleSubsystem() {
    SparkMaxConfig config = new SparkMaxConfig();
    config.inverted(false);
    config.idleMode(IdleMode.kCoast);
    config.smartCurrentLimit(40);

    motorController.configure(
      config,
      ResetMode.kResetSafeParameters,
      PersistMode.kPersistParameters
    );
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command setSpeedCommand(Supplier<Double> speed) {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          setSpeed(speed.get());
        });
  }
  public void setSpeed(double speed) {
    // Set the speed of a motor or actuator in the subsystem.
    motorController.set(speed);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
