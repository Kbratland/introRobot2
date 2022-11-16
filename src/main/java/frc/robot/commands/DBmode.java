package frc.robot.commands;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Camera;
import frc.robot.subsystems.DriveSubsystem;

public class DBmode extends CommandBase {
    Camera camera;
    DriveSubsystem driveSubsystem;
    public DBmode(Camera camera, DriveSubsystem driveSubsystem) {
     this.camera = camera; 
     this.driveSubsystem = driveSubsystem;
    }
    public void initialize(){
    }
    public void execute(){
        double a = camera.getTargetArea();
        double x = camera.getTargetYaw();
        System.out.println("depth " + a + ", Yaw " + x);
        //driveSubsystem.arcadeDrive(0, yaw * -1);
        if (x > -0.3 && x < 0.3){
          driveSubsystem.arcadeDrive(0, 0);
        }
        if(x < -0.3){
          double r = 0;
          if (x > -10 && x > 5 ){
            r = (x/10)*-1;
          }
          else {
            r = -0.5;
          }
          driveSubsystem.arcadeDrive(0, r);
        }
        else if(x < 10 && x > 5){
          double r = 0;
          if (x < 10 && x > 5){
          r = (x/10); 
          }
          else {
            r = 0.5;
          }
          driveSubsystem.arcadeDrive(0, r);
        }
        if(a < 5){ 
          //0=1 & 5 = 0.5
          // 5 - 0, 0.5 - 1
          // -5 to 0 +5
          //a = (a+5)/10;
          a = (a * -1) + 5;
          a = a/5;
          MathUtil.clamp(a, 0.45, 0.5);
          driveSubsystem.arcadeDrive(a , 0);
        }
        else if (a > 20 && x < 5){
          driveSubsystem.arcadeDrive(0, 0);
        }
        else if (a > 20){
          //a = a/40;
          // 30 - 20, 1 - 0.5
          a = (a-20) / 40;

          MathUtil.clamp(a, 0.45, 0.5);
          driveSubsystem.arcadeDrive(-a, 0);
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
