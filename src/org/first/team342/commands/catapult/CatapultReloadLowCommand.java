/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342.commands.catapult;

import org.first.team342.commands.CommandBase;
import org.first.team342.subsystems.CatapultSystem;

/**
 *
 * @author FIRST Team 342
 */
public class CatapultReloadLowCommand extends CommandBase {

    public CatapultSystem catapult;

    public CatapultReloadLowCommand() {
        this.catapult = CatapultSystem.getInstance();
        this.requires(this.catapult);
    }

    protected void initialize() {
    }

    protected void execute() {
        if (!catapult.switchLocked()) {
            catapult.reloadRelease();
        } else {
            this.catapult.stopRelease();
            if (!catapult.isHighPower() && !catapult.isLowPower()) {
                this.catapult.reload();
            } else {
                this.catapult.stop();
            }
        }
    }

    protected boolean isFinished() {
        return this.catapult.isLowPower();
    }

    protected void end() {
        catapult.stop();
    }

    protected void interrupted() {
    }
}
