package frc.robot.subsystems;

import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonTrackedTarget;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Camera extends SubsystemBase{
    PhotonCamera photonCamera = new PhotonCamera("Microsoft_LifeCam_HD-3000");
   public double getTargetYaw(){
    //    var result = photonCamera.getLatestResult();
    //    System.out.println("Result is " + result.toString());
       if(photonCamera.getLatestResult().hasTargets()){
        PhotonTrackedTarget target = photonCamera.getLatestResult().getBestTarget();
        System.out.println("I have a target " + target);
        return target.getYaw();
       }
       else{
           System.out.println("No target");
        return (0.4);
       }
   }
} 