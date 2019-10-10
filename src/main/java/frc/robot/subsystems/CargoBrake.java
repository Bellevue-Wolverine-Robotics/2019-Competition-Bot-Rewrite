package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * The brake for the Cargo Arm
 */
public class CargoBrake extends Subsystem {

  private DoubleSolenoid cargoBrake = new DoubleSolenoid(RobotMap.ARM_STOP_IN, RobotMap.ARM_STOP_OUT);

  @Override
  public void initDefaultCommand() {}

  public void releaseBrake() {
    cargoBrake.set(DoubleSolenoid.Value.kReverse);
  }

  public void brake() {
    cargoBrake.set(DoubleSolenoid.Value.kForward);
  }
}
