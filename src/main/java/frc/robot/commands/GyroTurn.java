package frc.robot.commands;

//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

//708cm long
//540cm short
//.6765 m/s at 0.5
/** An example command that uses an example subsystem. */
public class GyroTurn extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    private final DriveSubsystem m_subsystem;
    double angle = 90;
    double speed = 0.45;

    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public GyroTurn(DriveSubsystem subsystem, double angle, double speed) {
        m_subsystem = subsystem;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(subsystem);
        this.angle = angle;
        this.speed = speed;
    }

    @Override
    public void initialize() {
        m_subsystem.zeroHeading();
        // while (angle > 360) {
        // angle = angle - 360;
        // }
    }

    public void execute() {
        System.out.println(m_subsystem.getHeading());
        m_subsystem.arcadeDrive(0, speed);
    }

    public boolean isFinished() {
        System.out.println(m_subsystem.getHeading());
        return m_subsystem.getHeading() >= angle - 0.5 && m_subsystem.getHeading() <= angle + 0.5;
    }

    public void end() {
        m_subsystem.arcadeDrive(0, 0);
    }
}
