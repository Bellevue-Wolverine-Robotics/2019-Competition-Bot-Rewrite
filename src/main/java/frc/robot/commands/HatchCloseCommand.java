package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class HatchCloseCommand extends Command {

	private boolean isDone;

	public HatchCloseCommand() {
		requires(Robot.hatchSolenoid);
	}

	@Override
	protected void initialize() {
		this.isDone = false;
	}

	@Override
	protected void execute() {
		Robot.hatchSolenoid.closeHatch();
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
