/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.												*/
/* Open Source Software - may be modified and shared by FRC teams. The code	 */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.																															 */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

	public static DriveTrain driveTrain = new DriveTrain();

	public static CargoBrake cargoBrake = new CargoBrake();
	public static CargoShoot cargoShoot = new CargoShoot();
	public static CargoArm cargoArm = new CargoArm();
	public static PIDCargoArm pidCargoArm = new PIDCargoArm();

	public static HatchArm hatchArm = new HatchArm();
	public static HatchSolenoid hatchSolenoid = new HatchSolenoid();
	//public static UsbCamera Camera= new UsbCamera("Camera0", 0);

	public static OI oi = new OI();

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	@Override
	public void robotInit() {
		
		UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
		camera.setResolution(160,90);
		System.out.println("set resolution");
		camera.setFPS(25);
		System.out.println("set fps");
	}

	/**
	 * This function is called every robot packet, no matter the mode. Use this for
	 * items like diagnostics that you want ran during disabled, autonomous,
	 * teleoperated and test.
	 *
	 * <p>
	 * This runs after the mode specific periodic functions, but before LiveWindow
	 * and SmartDashboard integrated updating.
	 */
	@Override
	public void robotPeriodic() {
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable chooser
	 * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
	 * remove all of the chooser code and uncomment the getString line to get the
	 * auto name from the text box below the Gyro
	 *
	 * <p>
	 * You can add additional auto modes by adding additional comparisons to the
	 * switch structure below with additional strings. If using the SendableChooser
	 * make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() {
		super.autonomousInit();
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		super.teleopInit();

		Robot.pidCargoArm.setSetpoint(0.0);
		Robot.pidCargoArm.enable();
		Robot.cargoBrake.releaseBrake();
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
		this.driveTrain();
		this.cargoShoot();
		this.arm();
	}

	@Override
	public void disabledInit() {
		super.disabledInit();
		
		Robot.pidCargoArm.disable();
		Robot.hatchSolenoid.stopHatch();
	}

	@Override
	public void testPeriodic() {}
	
	private void driveTrain() {
		double y = -1 * oi.getDriveY();
		double z = oi.getDriveZ();

		// y = y < -0.05 || y > 0.05 ? y : 0.0;
		// z = z < -0.05 || z > 0.05 ? z : 0.0;

		Robot.driveTrain.arcade(y, 0.4 * z);
	}

	private void cargoShoot() {
		if (Robot.oi.isOperatorButtonDown(RobotMap.SHOOT_IN_BUTTON)) {
			Robot.cargoShoot.shootIn();
		} else if (Robot.oi.isOperatorButtonDown(RobotMap.SHOOT_OUT_BUTTON)) {
			Robot.cargoShoot.shootOut();
		} else {
			Robot.cargoShoot.stopShoot();
		}
	}

	private void arm() {
		double y = Robot.oi.getOperatorY();
		if (y > 0.2 || y < -0.2) {
			Robot.pidCargoArm.setSetpoint(y * 0.2);
		} else {
			Robot.pidCargoArm.setSetpoint(0);
		}
	}

}
