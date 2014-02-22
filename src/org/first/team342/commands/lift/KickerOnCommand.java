/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342.commands.lift;

import org.first.team342.commands.CommandBase;
import org.first.team342.subsystems.LiftSystem;

        
/**
 *
 * @author Team342
 */
public class KickerOnCommand extends CommandBase {

    private LiftSystem liftsystem;

    public KickerOnCommand() {
        this.liftsystem = LiftSystem.getInstance();
        this.requires(this.liftsystem);
    }

    public void initialize() {
    }

    public void execute() {
        this.liftsystem.kickerOn();
    }

    public boolean isFinished() {
        return true;
    }

    public void interrupted() {

    }

    protected void end() {
    }
}
