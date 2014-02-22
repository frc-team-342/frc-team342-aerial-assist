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
import org.first.team342.RobotMap;

public class CatapultSystem extends Subsystem {

    public SpeedController catapultMotor;
    public SpeedController catapultReleaseMotor;
    private static final CatapultSystem INSTANCE = new CatapultSystem();
    private final DigitalInput lowLightSensor;
    private final DigitalInput highLightSensor;
    private final DigitalInput switchLocked;
    private final DigitalInput switchReleased;

    private CatapultSystem() {
        this.catapultMotor = new Talon(RobotMap.PWM_CHANNEL_CATAPULT_MOTOR);
        this.catapultReleaseMotor = new Talon(RobotMap.PWM_CHANNEL_RELEASE_MOTOR);
        this.lowLightSensor = new DigitalInput(RobotMap.DIO_CHANNEL_LOW_SENSOR);
        this.highLightSensor = new DigitalInput(RobotMap.DIO_CHANNEL_HIGH_SENSOR);
        this.switchLocked = new DigitalInput(RobotMap.DIO_CHANNEL_LOCKED_SWITCH);
        this.switchReleased = new DigitalInput(RobotMap.DIO_CHANNEL_RELEASED_SWITCH);
    }

    protected void initDefaultCommand() {
    }

    public static CatapultSystem getInstance() {
        return INSTANCE;
    }

    public void release() {
        if (!this.switchReleased()) {
            System.out.println("Setting Speed");
            this.catapultReleaseMotor.set(-1.00);
        } else {
            System.out.println("Stopping Release");
            this.catapultReleaseMotor.set(0.0);
        }
    }

    public void reloadRelease() {
        if (!this.switchLocked()) {
            this.catapultMotor.set(-0.40);
            this.catapultReleaseMotor.set(0.60);
        } else {
            this.catapultMotor.set(0.0);
            this.catapultReleaseMotor.set(0.0);
        }
    }

    public void reload() {
        if (!this.isHighPower()) {
            this.catapultMotor.set(-1.0);
        } else {
            this.catapultMotor.set(0.0);
        }
    }

    public void stop() {
        this.catapultMotor.set(0.0);
    }

    public void stopRelease() {
        this.catapultReleaseMotor.set(0.0);
    }

    public boolean isLowPower() {
        return !this.lowLightSensor.get();
    }

    public boolean isHighPower() {
        return !this.highLightSensor.get();
    }

    public boolean switchLocked() {
        return !this.switchLocked.get();
    }

    public boolean switchReleased() {
        return !this.switchReleased.get();
    }

}
