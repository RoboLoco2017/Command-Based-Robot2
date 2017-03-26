package org.usfirst.frc.team5338.robot.commands;

import org.usfirst.frc.team5338.robot.Robot;

import edu.wpi.first.wpilibj.command.PIDCommand;

public class Turn extends PIDCommand
{
    public Turn(int angle)
    {
	super(0.1, 0.0, 0.0, 0.005);
	requires(Robot.drivetrain);
	Robot.ahrs.reset();
	Robot.ahrs.zeroYaw();
	getPIDController().setOutputRange(0.0, 0.25);
	getPIDController().setInputRange(0.0, 360.0);
	getPIDController().setContinuous();
	double targetHeading = ((double)(Robot.ahrs.getCompassHeading()) + angle) % 360.0;
	if(targetHeading < 0)
	{
	    setSetpoint(360.0 + targetHeading);
	}
	else
	{
	    setSetpoint(targetHeading);
	}
    }
    protected void execute()
    {
    }
    protected boolean isFinished()
    {
	return getPIDController().onTarget();
    }
    protected void end()
    {
	Robot.drivetrain.drive(0.0, 0.0);
    }
    protected double returnPIDInput()
    {
	return Robot.ahrs.getCompassHeading();
    }
    protected void usePIDOutput(double output)
    {
	Robot.drivetrain.drive(-output, output);
    }
}
