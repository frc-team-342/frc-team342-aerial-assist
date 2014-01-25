/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.first.team342.commands.lift;

import org.first.team342.commands.CommandBase;
import edu.wpi.first.wpilibj.command.Command;
import org.first.team342.subsystems.LiftSystem;

/**
 *
 * @author Team342
 */
public class StopLiftCommand extends CommandBase {
    
    private LiftSystem liftsystem;

    public StopLiftCommand() {
        this.liftsystem = LiftSystem.getInstance();
        this.requires(this.liftsystem);

    }

    public void initialize() {
       
    }

    public void execute() {
        this.liftsystem.stop();
        
    }

    public boolean isFinished() {
        return true;
       
    }

    public void end() {
        this.liftsystem.stop();
    }

    public void interrupted() {
        
    }
    
}
