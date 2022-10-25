package frc.robot.commands;

//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSubsystem;

//.6725 m/s at half speed
//1750 millis for ~90 turn at half speed
//708cm long
//540cm short
/** An example command that uses an example subsystem. */
// new TImedStraight(drive, 9400);
// new TimedTurn(drive, 2600, left);
// new TImedStraight(drive, 8222);
// new TimedTurn(drive, 2600, left);
// new TImedStraight(drive, 9400);
// new TimedTurn(drive, 2600, left);
// new TImedStraight(drive, 8222);
// new TimedTurn(drive, 2600, left);
public class deskLoop extends SequentialCommandGroup {

    public deskLoop(DriveSubsystem drive) {
        addCommands(
                new PIDstraight(9400, drive, 0),
                new TurnToAngle(90, drive),
                new PIDstraight(3991, drive, 0),
                new TurnToAngle(90, drive),
                new PIDstraight(9400, drive, 0),
                new TurnToAngle(90, drive),
                new PIDstraight(3991, drive, 0),
                new TurnToAngle(90, drive));
    }

}
