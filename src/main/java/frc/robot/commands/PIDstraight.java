package frc.robot.commands;

//import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.DriveSubsystem;

public class PIDstraight extends PIDCommand {
    public DriveSubsystem mdrive;
    public long duration = 3000;
    public long timerStart = 0;
    double targetAngleDegrees = 0;

    public PIDstraight(long duration, DriveSubsystem drive, double targetAngleDegrees) {

        super(

                new PIDController(DriveConstants.kTurnP, DriveConstants.kTurnI, DriveConstants.kTurnD),
                // Close loop on heading
                drive::getHeading,
                // Set reference to target
                targetAngleDegrees,
                // Pipe output to turn robot
                output -> {
                    drive.arcadeDrive(0, output);
                    System.out.println(" Output is " + output + " Heading is " + drive.getHeading()
                            + "\n-----------------------------------\n");
                },
                // Require the drive
                drive);
        mdrive = drive;
        // Set the controller to be continuous (because it is an angle controller)
        getController().enableContinuousInput(-180, 180);
        // Set the controller tolerance - the delta tolerance ensures the robot is
        // stationary at the
        // setpoint before it is considered as having reached the reference
        getController()
                .setTolerance(DriveConstants.kTurnToleranceDeg, DriveConstants.kTurnRateToleranceDegPerS);
    }

    @Override
    public void initialize() {
        super.initialize();
        mdrive.zeroHeading();
        timerStart = System.currentTimeMillis();
    }

    public void execute() {
        mdrive.arcadeDrive(0.6, 0);
    }

    public boolean isFinished() {
        return System.currentTimeMillis() - timerStart >= duration;
    }

}
