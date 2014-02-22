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
 * @author Team342
 */
public class CatapultPulldownCommand extends CommandBase {

    public CatapultSystem catapult;

   public CatapultPulldownCommand() {
        this.catapult = CatapultSystem.getInstance();
        this.requires(this.catapult);
    }

    protected void initialize() {
    }

    protected void execute() {
        this.catapult.reload();
    }

    protected void end() {
        this.catapult.stop();
    }
    
    protected boolean isFinished(){
        return this.catapult.isLowPower();
    }

    protected void interrupted() {
    }
    
}
