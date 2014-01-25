/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.first.team342.RobotMap;

public class CatapultSystem extends Subsystem {

    public SpeedController catapultMotor;
    private static final CatapultSystem INSTANCE = new CatapultSystem();

    private CatapultSystem() {
        this.catapultMotor = new Talon(RobotMap.PWM_CHANNEL_CATAPULTSYSTEM);
    }

    protected void initDefaultCommand() {
    }

    public static CatapultSystem getInstance() {
        return INSTANCE;
    }

    public void release() {
    }

    public void reload() {
    }

    public boolean isLoaded() {
        return false; //DUNNO YET PROBABLY A SWITTTTTTTTTTTTTTTCH
    }

}
