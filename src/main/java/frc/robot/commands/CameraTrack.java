package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Camera;
import frc.robot.subsystems.DriveSubsystem;

public class CameraTrack extends CommandBase {
    Camera camera;
    DriveSubsystem driveSubsystem;
    public CameraTrack(Camera camera, DriveSubsystem driveSubsystem) {
     this.camera = camera; 
     this.driveSubsystem = driveSubsystem;
    }
    public void initialize(){

    }
    public void execute(){
        double yaw = camera.getTargetYaw();
        //driveSubsystem.arcadeDrive(0, yaw * -1);
        if(yaw < 0){
          driveSubsystem.arcadeDrive(0, -0.5);
        }
        else if (yaw > -0.3 && yaw < 0.3){
          driveSubsystem.arcadeDrive(0, 0);
        }
        else if (yaw > 0){
          driveSubsystem.arcadeDrive(0, 0.5);
        }
        // else if(yaw == null){
        // driveSubsystem.arcadeDrive(0, 0);
        // }
    }
    public boolean isFinished(){
      return false;
    }
    public void end (boolean interupted){
      driveSubsystem.arcadeDrive(0, 0);
    }
}
