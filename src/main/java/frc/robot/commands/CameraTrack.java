package frc.robot.commands;

import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonTrackedTarget;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class CameraTrack extends CommandBase {
    PhotonCamera photonCamera = new PhotonCamera(null, getName());
    var result = photonCamera.getLatestResult();
    DriveSubsystem driveSubsystem;
    PhotonTrackedTarget target = result.getBestTarget();
    double yaw = target.getYaw();
    public void getCamera(PhotonCamera photonCamera, DriveSubsystem driveSubsystem) {
      this.photonCamera = photonCamera;

      // boolean hasTargets = result.hasTargets();
      
      // double pitch = target.getPitch();
      // double area = target.getArea();
      // double skew = target.getSkew();
      // ransform2d pose = target.getCameraToTarget();
      // List<TargetCorner> corners = target.getCorners();
    }
      @Override
      public void initialize(){

      }
      public void execute(){
        double yaw = target.getYaw();
        if(yaw < 0 ){
          driveSubsystem.arcadeDrive(0, 0.5);
        }
      }
}
