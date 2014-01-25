/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342.commands.catapult;

import org.first.team342.commands.CommandBase;
import org.first.team342.subsystems.CatapultSystem;
import edu.wpi.first.wpilibj.DriverStationLCD;

/**
 *
 * @author Team342
 */
public class CatapultReleaseCommand extends CommandBase {

    public CatapultSystem catapult;
    private DriverStationLCD lcd;

    public CatapultReleaseCommand() {
        this.catapult = CatapultSystem.getInstance();
        this.requires(this.catapult);
        lcd = DriverStationLCD.getInstance();
        
    }

    protected void initialize() {
    }

    protected void execute() {
        //put firing code hereeeeeeee
        lcd.println(DriverStationLCD.Line.kUser1, 0, "Firing code does not exist yet");
        lcd.updateLCD();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }

}
