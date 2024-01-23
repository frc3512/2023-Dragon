package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pneumatics extends SubsystemBase {
    private final Solenoid miniSolenoid;
    private final DoubleSolenoid largeSolenoid;
    private final Compressor compressor;
    private final PneumaticHub pneumaticHub;

    public Pneumatics() {
        pneumaticHub = new PneumaticHub(17);
        miniSolenoid = pneumaticHub.makeSolenoid(13);
        largeSolenoid = pneumaticHub.makeDoubleSolenoid(14, 15);
        compressor = pneumaticHub.makeCompressor();
        compressor.enableDigital();

        miniSolenoid.set(false);
        largeSolenoid.set(DoubleSolenoid.Value.kOff);
    }


    public Command extendSolenoids() {
        return run( () -> {
            miniSolenoid.set(true);
            largeSolenoid.set(DoubleSolenoid.Value.kForward);
            SmartDashboard.putBoolean("Extended", true);
        });
    }

    public Command retractSolenoids() {
        return run( () -> {
            miniSolenoid.set(false);
            largeSolenoid.set(DoubleSolenoid.Value.kReverse);
            SmartDashboard.putBoolean("Extended", false);
        });
    }

    public Command extendMiniSolenoid() {
        return new InstantCommand(() -> miniSolenoid.set(true), this);
    }
    public Command retractMiniSolenoid() {
        return new InstantCommand(() -> miniSolenoid.set(false), this);
    }

    public Command extendLargeSolenoid() {
        return run( () -> {
            largeSolenoid.set(DoubleSolenoid.Value.kForward);
        });
    }

    public Command retractLargeSolenoid() {
        return run( () -> {
            largeSolenoid.set(DoubleSolenoid.Value.kReverse);
        });
    }
}
