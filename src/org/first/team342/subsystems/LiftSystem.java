/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.first.team342.RobotMap;

/**
 *
 * @author Team342
 */
public class LiftSystem extends Subsystem {

    public SpeedController liftMotor;
    public static final double DEFAULT_SPEED_UP = -0.90;
    public static final double DEFAULT_SPEED_DOWN = 0.40;
        private static final LiftSystem INSTANCE = new LiftSystem();


    private LiftSystem() {
        this.liftMotor = new Victor(RobotMap.PWM_CHANNEL_LIFTSYSTEM);

    }

    public static LiftSystem getInstance() {

        return INSTANCE;
    }

    public void down() {
        this.liftMotor.set(DEFAULT_SPEED_DOWN);
    }

    public void up() {
        this.liftMotor.set(DEFAULT_SPEED_UP);
    }

    public void stop() {
        this.liftMotor.set(0.0);
        System.out.println("Stopping lifter");
    }

    protected void initDefaultCommand() {
    }
}
