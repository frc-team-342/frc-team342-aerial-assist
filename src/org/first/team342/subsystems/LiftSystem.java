/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import org.first.team342.RobotMap;



/**
 *
 * @author Team342
 */
public class LiftSystem extends Subsystem {

    public SpeedController liftMotor;
    public static final double DEFAULT_SPEED_UP = 0.80;
    public static final double DEFAULT_SPEED_DOWN = -0.40;
    private static final LiftSystem INSTANCE = new LiftSystem();
    private final DigitalInput forkUp;
    private final DigitalInput forkDown;
    private final Relay kicker;


    private LiftSystem() {
        this.liftMotor = new Talon(RobotMap.PWM_CHANNEL_LIFTSYSTEM);
        this.forkUp = new DigitalInput(RobotMap.DIO_CHANNEL_FORKUP);
        this.forkDown = new DigitalInput(RobotMap.DIO_CHANNEL_FORKDOWN);
        this.kicker = new Relay(RobotMap.RELAY_CHANNEL_KICKER);
    }

    public static LiftSystem getInstance() {

        return INSTANCE;
    }

    public void down() {
        if (!this.forkDown()) {
            this.liftMotor.set(DEFAULT_SPEED_DOWN);
        } else {
            this.liftMotor.set(0.0);
        }
    }

    public void up() {
        if (!this.forkUp()) {
            this.liftMotor.set(DEFAULT_SPEED_UP);
        } else {
            this.liftMotor.set(0.0);
        }
    }

    public void stop() {
        this.liftMotor.set(0.0);
    }
    
    public void kickerOn() {
//        this.kicker.setDirection(Relay.Direction.kBoth);
        this.kicker.set(Relay.Value.kForward);
    }
    
    public void kickerOff() {
        this.kicker.set(Relay.Value.kOff);
    }
    
    public boolean forkUp() {
        return !this.forkUp.get();
    }
    
    public boolean forkDown() {
        return !this.forkDown.get();
    }


    protected void initDefaultCommand() {
    }
}
