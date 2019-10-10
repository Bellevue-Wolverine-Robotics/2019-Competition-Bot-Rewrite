package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * The actual Cargo Arm.
 */
public class CargoArm extends Subsystem {
		
	private double gearBoxReduction = 0.5;
	private double coefficient = (360 * gearBoxReduction / 4096);

	private WPI_TalonSRX arm = new WPI_TalonSRX(RobotMap.ARM_CARGO);

	public CargoArm() {
		this.arm.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0); 
		this.arm.configSelectedFeedbackCoefficient(coefficient);
		this.arm.setSensorPhase(false);
		this.arm.setSelectedSensorPosition(0, 0, 0);
	}

	@Override
	public void initDefaultCommand() {}

	public void setCargoArm(double speed) {
		this.arm.set(speed);
	}

	public double getVelocity() {
		return -1 * this.arm.getSelectedSensorVelocity();
	}
}
