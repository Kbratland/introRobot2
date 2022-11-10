package frc.robot.subsystems;

import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonTrackedTarget;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Camera extends SubsystemBase{
    PhotonCamera photonCamera = new PhotonCamera("MICROSOFT_LifeCam_HD-3000");
   public double getTargetYaw(){
       var result = photonCamera.getLatestResult();
       if(result.hasTargets()){
        PhotonTrackedTarget target = result.getBestTarget();
        System.out.println("I have a target " + target);
        return target.getYaw();
       }
       else{
        return (0);
       }
   }
}