package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * The Cargo Shoot mechanism.
 */
public class CargoShoot extends Subsystem {

	private CANSparkMax shoot = new CANSparkMax(RobotMap.SHOOT, MotorType.kBrushed);

	@Override
	public void initDefaultCommand() {}

	public void shootOut() {
		shoot.set(-1.0);
	}

	public void stopShoot() {
		shoot.set(0);
	}

	public void shootIn() {
		shoot.set(0.5);
	}
}
