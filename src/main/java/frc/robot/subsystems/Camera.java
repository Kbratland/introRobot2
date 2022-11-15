package frc.robot.subsystems;

import java.util.List;

import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Camera extends SubsystemBase{
    PhotonCamera photonCamera = new PhotonCamera("Microsoft_LifeCam_HD-3000");
   public double getTargetYaw(){
    //    var result = photonCamera.getLatestResult();
    //    System.out.println("Result is " + result.toString());
    PhotonPipelineResult result = photonCamera.getLatestResult();
    System.out.println("after acquiring results");
    System.out.println(result.hasTargets());

       if(photonCamera.getLatestResult().hasTargets()){
        System.out.println("I have a target");
        PhotonPipelineResult target = photonCamera.getLatestResult();
        List<PhotonTrackedTarget> target1 = target.getTargets();
        PhotonTrackedTarget myTarget = target1.get(0);
        System.out.println("I have a target " + myTarget);
        return myTarget.getYaw();
       }
       else{
           System.out.println("No target");
        return (0.4);
       }
   }
} 