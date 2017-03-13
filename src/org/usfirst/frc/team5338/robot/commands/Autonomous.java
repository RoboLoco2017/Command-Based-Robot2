package org.usfirst.frc.team5338.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous extends CommandGroup
{
	public Autonomous()
	{
		switch("CENTERGEAR-RIGHT")
		{
			case "CENTERGEAR-LEFT":
				addSequential(new MoveSlowly(4));
				addSequential(new DepositGear());
				addSequential(new Turn(-90));
				addSequential(new MoveFast(1));
				addSequential(new Turn(100));
				addSequential(new MoveFast(3));
				break;
			case "CENTERGEAR-RIGHT":
				addSequential(new MoveSlowly(4));
				addSequential(new DepositGear());
				addSequential(new MoveSlowly(-1));
				addSequential(new Turn(100));
				addSequential(new MoveFast(1));
				addSequential(new Turn(-100));
				addSequential(new MoveFast(3));
				break;
			case "LEFTGEAR":
				addSequential(new MoveSlowly(3));
				addSequential(new Turn(60));
				addSequential(new MoveSlowly(4));
				addSequential(new DepositGear());
				addSequential(new MoveSlowly(-1));
				addSequential(new Turn(-60));
				addSequential(new MoveFast(3));
				break;
			case "RIGHTGEAR":
				addSequential(new MoveSlowly(3));
				addSequential(new Turn(-60));
				addSequential(new MoveSlowly(4));
				addSequential(new DepositGear());
				addSequential(new MoveSlowly(-1));
				addSequential(new Turn(60));
				addSequential(new MoveFast(3));
				break;
			case "BASELINE":
				addSequential(new MoveFast(4));
				break;
			default:
				break;
		}
	}
}