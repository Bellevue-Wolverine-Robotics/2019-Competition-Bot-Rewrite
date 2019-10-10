package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class HatchOpenCommand extends Command {

	private boolean isDone;

	public HatchOpenCommand() {
		requires(Robot.hatchSolenoid);
	}

	@Override
	protected void initialize() {
		this.isDone = false;
	}

	@Override
	protected void execute() {
		Robot.hatchSolenoid.openHatch();
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
