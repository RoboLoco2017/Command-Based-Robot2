package org.usfirst.frc.team5338.robot.subsystems;

import org.usfirst.frc.team5338.robot.OI;
import org.usfirst.frc.team5338.robot.commands.HandleGears;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearHandler extends Subsystem
{

	private final Compressor COMPRESSOR = new Compressor();
	private final DoubleSolenoid DOOR = new DoubleSolenoid(1, 2); 

    public GearHandler()
	{
		super();
		COMPRESSOR.setClosedLoopControl(true);
		COMPRESSOR.start(); 
	}

    public void initDefaultCommand()
    {
    	setDefaultCommand(new HandleGears());
    }
    public void handleGears(OI oi)
	{
		if(oi.get(OI.Button.GEAR_OPEN))
			DOOR.set(DoubleSolenoid.Value.kForward);
		else if(oi.get(OI.Button.GEAR_CLOSE))
			DOOR.set(DoubleSolenoid.Value.kReverse);
		else
			DOOR.set(DoubleSolenoid.Value.kOff);
	}
    
    public void stopGears(){
		DOOR.set(DoubleSolenoid.Value.kOff);
    }
}
