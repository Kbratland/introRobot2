package frc.robot.commands;

// import com.ctre.phoenix.motorcontrol.NeutralMode;
// import com.ctre.phoenix.motorcontrol.can.TalonSRX;

//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

//1750 millis for ~90 turn
//708cm long
//540cm short
/** An example command that uses an example subsystem. */
public class TImedStraight extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    private final DriveSubsystem m_subsystem;
    private long timerStart = 0;
    private long duration = 10400;

    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public TImedStraight(DriveSubsystem subsystem, int duration) {
        m_subsystem = subsystem;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(subsystem);
        this.duration = duration;
    }

    @Override
    public void initialize() {
        timerStart = System.currentTimeMillis();
    }

    public void execute() {
        // System.out.println(Encoder);
        m_subsystem.arcadeDrive(0.5, 0);
    }

    public boolean isFinished() {
        return System.currentTimeMillis() - timerStart >= duration;
    }

    public void end() {
        m_subsystem.arcadeDrive(0, 0);
    }
}
