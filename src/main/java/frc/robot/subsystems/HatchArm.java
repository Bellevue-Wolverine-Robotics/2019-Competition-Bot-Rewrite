package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class HatchArm extends Subsystem {
	
	private WPI_TalonSRX hatchFall = new WPI_TalonSRX(RobotMap.HATCH_FALL);

	private double gearBoxReduction = 56 / 50;

	private double coefficient =	(360 * gearBoxReduction / 4096);

	private double startingAngle = 0.0;

	public HatchArm() {
		hatchFall.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0); 
		hatchFall.configSelectedFeedbackCoefficient(coefficient);
		hatchFall.setSensorPhase(false); //????
		hatchFall.setSelectedSensorPosition(0, 0, 0);
	}

	@Override
	public void initDefaultCommand() {}

	public double getAngle() {
		return -1 * hatchFall.getSelectedSensorPosition() + startingAngle;
	}

	public double getVelocity() {
		return -1 * hatchFall.getSelectedSensorVelocity();
	}

	public void setHatchArm(double v) {
		hatchFall.set(v);
	}
}
