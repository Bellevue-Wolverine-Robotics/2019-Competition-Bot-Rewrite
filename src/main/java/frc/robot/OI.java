package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	public final Joystick driveStick;
	public final Joystick operatorStick;

    public final Button brakeOnButton;
	public final Button brakeOffButton;
	
	public final Button hatchOpenButton;
	public final Button hatchCloseButton;
	
	public final Button hatchUpButton;
	public final Button hatchDownButton;

	public OI() {
        this.driveStick = new Joystick(0);
        this.operatorStick = new Joystick(1);

        this.brakeOnButton = new JoystickButton(this.operatorStick, RobotMap.BRAKE);
        this.brakeOffButton = new JoystickButton(this.operatorStick, RobotMap.BRAKE_RELEASE);

        this.brakeOnButton.whenPressed(new BrakeOnCommand());
		this.brakeOffButton.whenPressed(new BrakeOffCommand());
		
		this.hatchOpenButton = new JoystickButton(this.operatorStick, RobotMap.HATCH_OPEN);
		this.hatchCloseButton = new JoystickButton(this.operatorStick, RobotMap.HATCH_CLOSE);

		this.hatchOpenButton.whenPressed(new HatchOpenCommand());
		this.hatchCloseButton.whenPressed(new HatchCloseCommand());

		this.hatchUpButton = new JoystickButton(this.operatorStick, RobotMap.RAISE_HATCH);
		this.hatchDownButton = new JoystickButton(this.operatorStick, RobotMap.LOWER_HATCH);

		this.hatchUpButton.whenPressed(new RaiseHatchCommand());
		this.hatchDownButton.whenPressed(new LowerHatchCommand());
	}

	public double getDriveX() {
		return driveStick.getX();
	}

	public double getDriveY() {
		return driveStick.getY();
	}

	public double getDriveZ() {
		return driveStick.getZ();
	}
	
	public double getDriveThrottle() {
		return driveStick.getThrottle();
	}
	
	public boolean isDriveButtonDown(int buttonNumber) {
		return driveStick.getRawButton(buttonNumber);
	}
	
	public double getOperatorX() {
		return operatorStick.getX();
	}
	
	public double getOperatorY() {
		return operatorStick.getY();
	}
	
	public double getOperatorZ() {
		return operatorStick.getZ();
	}
	
	public double getOperatorThrottle() {
		return operatorStick.getThrottle();
	}
	
	public boolean isOperatorButtonDown(int buttonNumber) {
		return operatorStick.getRawButton(buttonNumber);
	}
	
	public int getOperatorPOV() {
		return operatorStick.getPOV();
	}
}
