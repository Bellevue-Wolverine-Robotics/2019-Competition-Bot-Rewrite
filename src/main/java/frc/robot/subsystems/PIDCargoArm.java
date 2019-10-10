package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.Robot;

/**
 * Raising and lowering the Cargo Arm
 */
public class PIDCargoArm extends PIDSubsystem {
	
	public PIDCargoArm() {
		super("PIDCargoArm", 0.4, 0.05, 0);
		setOutputRange(-1, 1);
	}

	public void setP(double P) {
		getPIDController().setP(P);
	}

	public void setI(double I) {
		getPIDController().setI(I);
	}

	public void setD(double D) {
		getPIDController().setD(D);
	}

	@Override
	public void initDefaultCommand() {}

	@Override
	protected double returnPIDInput() {
		return Robot.cargoArm.getVelocity() / 15.0;
	}

	@Override
	protected void usePIDOutput(double output) {
		Robot.cargoArm.setCargoArm(output);
	}
}
