package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class LowerHatchCommand extends Command {
	
	public LowerHatchCommand() {
		requires(Robot.hatchArm);
	}

	@Override
	protected void initialize() {
		Robot.hatchArm.setHatchArm(-0.1);
	}

	@Override
	protected void execute() {}

	@Override
	protected boolean isFinished() {
		return Robot.hatchArm.getAngle() < 45;
	}
	
	@Override
	protected void end() {
		Robot.hatchArm.setHatchArm(0);
	}

	@Override
	protected void interrupted() {
		end();
	}
}

