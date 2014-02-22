/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342.commands.catapult;

import org.first.team342.RobotUtilities;
import org.first.team342.commands.CommandBase;
import org.first.team342.subsystems.CatapultSystem;

/**
 *
 * @author Team342
 */
public class CatapultResetLockCommand extends CommandBase {

    public CatapultSystem catapult;

    public CatapultResetLockCommand() {
        this.catapult = CatapultSystem.getInstance();
        this.requires(this.catapult);
    }

    protected void initialize() {
    }

    protected void execute() {
        RobotUtilities.updateCatapultStatus("Reloading...");
        this.catapult.reloadRelease();
    }

    protected boolean isFinished() {
        return this.catapult.switchLocked();
    }

    protected void end() {
        this.catapult.stop();
        this.catapult.stopRelease();
    }

    protected void interrupted() {
    }
}
