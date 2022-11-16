// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.Camera;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.PIDCommand;

/** A command that will turn the robot to the specified angle. */
public class CameraPID extends PIDCommand {
  /**
   * 
   * Turns to robot to the specified angle.
   *
   * @param targetAngleDegrees The angle to turn to
   * @param drive              The drive subsystem to use
   */
  public DriveSubsystem m_drive;
  Camera camera;

  public CameraPID(double targetAngleDegrees, DriveSubsystem drive) {
    super(

        new PIDController(DriveConstants.kTurnP, DriveConstants.kTurnI, DriveConstants.kTurnD),
        // Close loop on heading
        drive::getHeading,
        // Set reference to target
        targetAngleDegrees,
        // Pipe output to turn robot
        output -> {
          output /= 100;
          if (output < 0) {
            output = MathUtil.clamp(output, -0.8, -0.46);
          }
          if (output > 0) {
            output = MathUtil.clamp(output, 0.46, 0.8);
          }
          drive.arcadeDrive(0, output);
          System.out.println("Output " + output);
          System.out.println(targetAngleDegrees + " angle");
        //   System.out.println("Output is " + output);
        },
        // Require the drive
        drive);
    m_drive = drive;

    // Set the controller to be continuous (because it is an angle controller)
    getController().enableContinuousInput(-180, 180);
    // Set the controller tolerance - the delta tolerance ensures the robot is
    // stationary at the
    // setpoint before it is considered as having reached the reference
    getController()
        .setTolerance(DriveConstants.kTurnToleranceDeg, DriveConstants.kTurnRateToleranceDegPerS);
  }

  @Override
  public void initialize() { 
    super.initialize();
    m_drive.zeroHeading();


  }

  public boolean isFinished() {
    // End when the controller is at the reference.
    return getController().atSetpoint();
  }
}
