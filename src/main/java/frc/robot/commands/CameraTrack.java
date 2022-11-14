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
        double a = camera.getTargetArea();
        double x = camera.getTargetYaw();
        System.out.println(x);
        //driveSubsystem.arcadeDrive(0, yaw * -1);
        if(x < 0){
          driveSubsystem.arcadeDrive(0, -0.25);
        }
        else if (x > -0.3 && x < 0.3){
          driveSubsystem.arcadeDrive(0, 0);
        }
        else if (x > 0){
          driveSubsystem.arcadeDrive(0, 0.25);
        }
        if(a < 5){
          driveSubsystem.arcadeDrive(0.25, 0);
        }
        else if (a > 20 && x < 5){
          driveSubsystem.arcadeDrive(0, 0);
        }
        else if (a > 20){
          driveSubsystem.arcadeDrive(-0.25, 0);
        }
        // else if(yaw == null){
        // driveSubsystem.arcadeDrive(0, 0);
        // }
    }
    public void end (boolean interupted){
      driveSubsystem.arcadeDrive(0, 0);
    }
    public boolean isFinished(){
      return false;
    }
}
