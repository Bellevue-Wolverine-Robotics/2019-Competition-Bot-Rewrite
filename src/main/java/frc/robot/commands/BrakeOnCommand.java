package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class BrakeOnCommand extends Command {

	private boolean isDone;

	public BrakeOnCommand() {
		requires(Robot.cargoBrake);
	}

	@Override
	protected void initialize() {
		this.isDone = false;
	}

	@Override
	protected void execute() {
		Robot.cargoBrake.brake();
		Robot.pidCargoArm.disable();
		this.isDone = true;
	}

	@Override
	protected boolean isFinished() {
		return this.isDone;
	}

	@Override
	protected void end() {}

	@Override
	protected void interrupted() {}
}
