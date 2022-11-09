package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Camera;
import frc.robot.subsystems.DriveSubsystem;

public class CameraTrack extends CommandBase {
    Camera camera;
    DriveSubsystem driveSubsystem;
    public void getCamera(Camera camera, DriveSubsystem driveSubsystem) {
      
    }
    public void initialize(){

    }
    public void execute(){
        camera.getTarget();
        
    }
}
