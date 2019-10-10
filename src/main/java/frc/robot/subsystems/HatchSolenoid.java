/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.														 */
/* Open Source Software - may be modified and shared by FRC teams. The code	 */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.																															 */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class HatchSolenoid extends Subsystem {

	private DoubleSolenoid hatch = new DoubleSolenoid(RobotMap.HATCH_OUT, RobotMap.HATCH_IN);

	public HatchSolenoid() {

	}

	@Override
	public void initDefaultCommand() {}

	public void openHatch() {
		hatch.set(DoubleSolenoid.Value.kForward);
	}

	public void closeHatch() {
		hatch.set(DoubleSolenoid.Value.kReverse);
	}

	public void stopHatch() {
		hatch.set(DoubleSolenoid.Value.kOff);
	}
}
