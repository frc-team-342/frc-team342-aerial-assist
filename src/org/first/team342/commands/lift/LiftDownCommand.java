/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342.commands.lift;

import org.first.team342.RobotUtilities;
import org.first.team342.commands.CommandBase;
import org.first.team342.subsystems.LiftSystem;

/**
 *
 * @author Team342
 */
public class LiftDownCommand extends CommandBase {

    private LiftSystem liftsystem;

    public LiftDownCommand() {
        this.liftsystem = LiftSystem.getInstance();
        this.requires(this.liftsystem);
    }

    protected void initialize() {
    }

    protected void execute() {
        RobotUtilities.updateLiftStatus("Going Down");
        this.liftsystem.down();
    }

    protected boolean isFinished() {
        return this.liftsystem.forkDown();
    }

    protected void end() {
    }

    protected void interrupted() {
    }

}
