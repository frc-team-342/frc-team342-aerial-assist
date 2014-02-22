/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.first.team342.commands.catapult;

import org.first.team342.commands.CommandBase;
import org.first.team342.subsystems.CatapultSystem;
import org.first.team342.subsystems.LiftSystem;

/**
 *
 * @author Team342
 */
public class TestLightSensorsCommand extends CommandBase {

    private CatapultSystem catapult;
    private LiftSystem liftsystem;
    
    public TestLightSensorsCommand() {
        this.catapult = CatapultSystem.getInstance();
        this.liftsystem = LiftSystem.getInstance();
        this.requires(this.catapult);
        this.requires(this.liftsystem);
    }
    
    protected void initialize() {
    }

    protected void execute() {
        System.out.println("Low Sensor: " + this.catapult.isLowPower());
        System.out.println("High Sensor: " + this.catapult.isHighPower());
        System.out.println("Lift Down: "+this.liftsystem.forkDown());
        System.out.println("Lift Up: "+this.liftsystem.forkUp());
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
