package frc.robot.subsystems;

import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonTrackedTarget;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Camera extends SubsystemBase{
    PhotonCamera photonCamera = new PhotonCamera("MICROSOFT_LifeCam_HD-3000");

    public double getTargetYaw(){
 
    var result = photonCamera.getLatestResult();
       if(result.hasTargets()){
            PhotonTrackedTarget targetX = result.getBestTarget();
            System.out.println("I have a target X " + targetX);
            return targetX.getYaw();
       }
       else{
        return (0);
       }
   }
   public double getTargetPitch(){

    var result = photonCamera.getLatestResult();
        if(result.hasTargets()){
            PhotonTrackedTarget targetY = result.getBestTarget();
            System.out.println("I have target Y " + targetY);
            return targetY.getPitch();
        }
        else{
         return (0);
        }
}
public double getTargetArea(){

    var result = photonCamera.getLatestResult();
        if(result.hasTargets()){
            PhotonTrackedTarget targetA = result.getBestTarget();
            System.out.println("I have target Y " + targetA);
            return targetA.getArea();
        }
        else{
         return (0);
        }
}
}
