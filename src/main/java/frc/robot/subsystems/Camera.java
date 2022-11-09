package frc.robot.subsystems;

import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonTrackedTarget;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Camera extends SubsystemBase{
    PhotonCamera photonCamera = new PhotonCamera(null, getName());
   public double getTargetYaw(){
       var result = photonCamera.getLatestResult();
       PhotonTrackedTarget target = result.getBestTarget();
       return target.getYaw();
   }
}