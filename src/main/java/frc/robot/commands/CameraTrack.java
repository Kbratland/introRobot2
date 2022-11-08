package frc.robot.commands;

import org.photonvision.PhotonCamera;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class CameraTrack extends CommandBase {
    PhotonCamera photonCamera = new PhotonCamera(null, getName());

    public void getCamera() {
      var result = photonCamera.getLatestResult();
      boolean hasTargets = result.hasTargets();
      
    }
}
