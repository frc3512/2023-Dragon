package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Motors extends SubsystemBase {
    private final CANSparkMax motor1;
    private final CANSparkMax motor2;
    private final CANSparkMax motor3;

    public Motors() {
        motor1 = new CANSparkMax(2, MotorType.kBrushless);
        motor2 = new CANSparkMax(3, MotorType.kBrushless);
        motor3 = new CANSparkMax(5, MotorType.kBrushless);
    }

    public Command runMotors(double speed) {
        return run(
            () -> {
                motor1.set(speed);
                motor2.set(speed);
                motor3.set(speed);
            }
        );
    }

    public Command stopMotors() {
        return run(
            () -> {
                motor1.set(0);
                motor2.set(0);
                motor3.set(0);
            }
        );
    }
}
