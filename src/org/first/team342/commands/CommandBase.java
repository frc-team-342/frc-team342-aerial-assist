package org.first.team342.commands;

import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.command.Command;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use
 * CommandBase.exampleSubsystem
 *
 * @author Author
 */
public abstract class CommandBase extends Command {

    private boolean finished;

    public CommandBase(String name) {
        super(name);
        this.finished = false;
    }

    public CommandBase() {
        super();
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    protected boolean isFinished() {
        return this.finished;
    }

    public void updateStatus() {
        DriverStationLCD lcd = DriverStationLCD.getInstance();
        lcd.println(DriverStationLCD.Line.kUser1, 1, this.getName());
        lcd.updateLCD();
    }
}
