/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.first.team342.RobotMap;
import org.first.team342.commands.drive.DriveWithJoystick;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Gyro;

/**
 *
 * @author Team342
 */
public class DriveSystem extends Subsystem {

    private static final DriveSystem INSTANCE = new DriveSystem();
    private final Jaguar leftFront;
    private final Jaguar rightFront;
    private final Jaguar leftRear;
    private final Jaguar rightRear;
    private final RobotDrive robotDrive;
    private final AnalogChannel rangeSensor;
    private final Gyro gyro;

    private DriveSystem() {
        super();
        System.out.println("Drive start");
        this.leftFront = new Jaguar(1, RobotMap.PWM_CHANNEL_LEFT_FRONT_DRIVE_MOTOR);
        this.rightFront = new Jaguar(1, RobotMap.PWM_CHANNEL_RIGHT_FRONT_DRIVE_MOTOR);
        this.leftRear = new Jaguar(1, RobotMap.PWM_CHANNEL_LEFT_REAR_DRIVE_MOTOR);
        this.rightRear = new Jaguar(1, RobotMap.PWM_CHANNEL_RIGHT_REAR_DRIVE_MOTOR);
        this.robotDrive = new RobotDrive(leftFront, leftRear, rightFront, rightRear);
        this.robotDrive.setSafetyEnabled(false);
        this.robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        this.robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        this.rangeSensor = new AnalogChannel(RobotMap.ANALOG_CHANNEL_RANGE_SENSOR);
        this.gyro = new Gyro(RobotMap.ANALOG_CHANNEL_GYRO_SENSOR);
        this.gyro.reset();
    }
    
    public void gyroReset() {
        this.gyro.reset();
    }

    public void initDefaultCommand() {
        this.setDefaultCommand(new DriveWithJoystick());
        System.out.println("Initialize default command");
    }

    public void driveWithJoystick(Joystick joystick) {
        //double angle = this.gyro.getAngle();// +360) % 360);
        double x = joystick.getX() * -1;
        double y = joystick.getY() * -1;
        double rotation = joystick.getZ() * -1;
        double angle = 0.0;
        this.robotDrive.mecanumDrive_Cartesian(x, y, rotation, angle);
       // System.out.println(angle);
    }


    public static DriveSystem getInstance() {
        return INSTANCE;
    }

    public void forward(double speed) {
        this.robotDrive.mecanumDrive_Polar(speed, 1.0, 0.0);
    }

    public void reverse(double speed) {
        this.robotDrive.mecanumDrive_Polar(speed, 1.0, 0.0);
    }

    public void stop(double speed) {
        this.robotDrive.mecanumDrive_Polar(0.0, 0.0, 0.0);
    }

    public double getRange() {
        double voltage = rangeSensor.getVoltage();
        double CurrentDistance = voltage * 100;
        return CurrentDistance;
    }
    /* Below is the target distance, the distance desired to fire at
     in autonomous mode. Just kidding I removed it.
     */


}
