package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;

public class DriveTrain extends Subsystem {

  // Left motor controllers
  private CANSparkMax left1 = new CANSparkMax(RobotMap.LEFT_DRIVE_1, MotorType.kBrushless);
  private CANSparkMax left2 = new CANSparkMax(RobotMap.LEFT_DRIVE_2, MotorType.kBrushless);
  private CANSparkMax left3 = new CANSparkMax(RobotMap.LEFT_DRIVE_3, MotorType.kBrushless);

  private SpeedControllerGroup leftMotors = new SpeedControllerGroup(left1, left2, left3);

  // Right motor controllers
  private CANSparkMax right1 = new CANSparkMax(RobotMap.RIGHT_DRIVE_1, MotorType.kBrushless);
  private CANSparkMax right2 = new CANSparkMax(RobotMap.RIGHT_DRIVE_2, MotorType.kBrushless);
  private CANSparkMax right3 = new CANSparkMax(RobotMap.RIGHT_DRIVE_3, MotorType.kBrushless);

  private SpeedControllerGroup rightMotors = new SpeedControllerGroup(right1, right2, right3);

  // Drive controller
  private DifferentialDrive drive;

  // Orientation Swap
  private int reverseDirection = 1;

  public DriveTrain() {
    drive = new DifferentialDrive(leftMotors, rightMotors);
    right2.setInverted(true);
    left3.setInverted(true);
    
    drive.setSafetyEnabled(false);
  }

  @Override
  public void initDefaultCommand() {
  }

  public void tank(double left, double right) {
    drive.tankDrive(left * reverseDirection, right * reverseDirection);
  }

  public void arcade(double ySpeed, double zRotation) {
    drive.arcadeDrive(ySpeed, zRotation, true);
  }

  public void reverseDirection() {
    reverseDirection = reverseDirection * -1;
  }
}
