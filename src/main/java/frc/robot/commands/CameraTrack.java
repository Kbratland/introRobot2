package frc.robot.commands;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class CameraTrack extends CommandBase {

    public void getCamera() {
        CameraServer.startAutomaticCapture();
    }
}
