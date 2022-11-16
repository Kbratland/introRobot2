/*package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class sonar extends CommandBase {
    public DriveSubsystem mdrive;
    public int distance = 10;

    public sonar(DriveSubsystem mdrive, int distance) {
        this.distance = distance;
        this.mdrive = mdrive;
    }

    @Override
    public void initialize() {
    }

    public void execute() {
        // mdrive.arcadeDrive(0.5, 0);
        System.out.println(mdrive.getRange());
    }

    public boolean isFinished() {
        return mdrive.getRange() <= distance;
    }
}*/
