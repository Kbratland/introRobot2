package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Camera;
import frc.robot.subsystems.DriveSubsystem;

public class CameraTrack extends CommandBase {
    Camera camera;
    DriveSubsystem driveSubsystem;
    public CameraTrack(Camera camera, DriveSubsystem driveSubsystem) {
      
    }
    public void initialize(){

    }
    public void execute(){
        double yaw = camera.getTargetYaw();
        if(yaw < 0)
        {
          driveSubsystem.arcadeDrive(0, -0.5);
        }
        else if (yaw > -0.2 && yaw < 0.2){
          driveSubsystem.arcadeDrive(0, 0);
        }
        else{
          driveSubsystem.arcadeDrive(0, 0.5);
        }
    }
    public boolean isFinished(){
      return false;
    }
}
