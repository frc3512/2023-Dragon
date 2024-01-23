package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Motors;

public class MotorControl extends Command {
    private final Motors m_motors;
    private final Supplier<Double> m_axis;

    public MotorControl(Motors motors, Supplier<Double> axis) {
        m_motors = motors;
        m_axis = axis;

        addRequirements(m_motors);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        if (m_axis.get() >= 0.1 || m_axis.get() <= -0.1) {
            m_motors.runMotors(m_axis.get() / 10);
        }
        else {
            m_motors.stopMotors();
        }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
