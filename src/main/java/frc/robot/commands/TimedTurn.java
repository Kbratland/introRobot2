package frc.robot.commands;

//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

//1750 millis for ~90 turn
//708cm long
//540cm short
//.6765 m/s at 0.5
/** An example command that uses an example subsystem. */
public class TimedTurn extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    private final DriveSubsystem m_subsystem;
    private long timerStart = 0;
    private long duration = 1750;
    boolean left = false;

    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public TimedTurn(DriveSubsystem subsystem, int duration, boolean left) {
        m_subsystem = subsystem;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(subsystem);
        this.duration = duration;
        this.left = left;
    }

    @Override
    public void initialize() {
        timerStart = System.currentTimeMillis();
    }

    public void execute() {
        if (left == false) {
            m_subsystem.arcadeDrive(0.1, 0.6);
        } else {
            m_subsystem.arcadeDrive(-0.1, -0.6);
        }
    }

    public boolean isFinished() {
        return System.currentTimeMillis() - timerStart >= duration;
    }

    public void end() {
        m_subsystem.arcadeDrive(0, 0);
    }
}
