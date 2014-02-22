/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342.commands.catapult;

import org.first.team342.commands.CommandBase;
import org.first.team342.subsystems.CatapultSystem;
import org.first.team342.RobotUtilities;

/**
 *
 * @author Team342
 */
public class CatapultReleaseCommand extends CommandBase {

    public CatapultSystem catapult;
    
    public CatapultReleaseCommand() {
        this.catapult = CatapultSystem.getInstance();
        this.requires(this.catapult);
    }

    protected void initialize() {
    }

    protected void execute() {
        RobotUtilities.updateCatapultStatus("Releasing...");
        System.out.println(this.catapult.switchReleased());
        this.catapult.release();        
        
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }

}
