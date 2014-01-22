/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.first.team342.Controller;
import org.first.team342.RobotMap;
import org.first.team342.RobotUtilities;
import org.first.team342.commands.drive.DriveWithJoystick;

/**
 *
 * @author Team342
 */
public class Drive extends Subsystem {

    private static final Drive INSTANCE = new Drive();
    private Joystick driveJoystick;
    //  private static final DriveBase INSTANCE = new DriveCAN();
    private Jaguar leftFront;
    private Jaguar rightFront;
    private Jaguar leftRear;
    private Jaguar rightRear;
    private RobotDrive robotDrive;
    private DriverStation station;
    private final double DISTANCE_PER_ROTATION = 1.4995668990882067; //inches [6in * pi / 12.57gearratio]

    public Drive() {
        super();
        System.out.println("Drive start");
        this.leftFront = new Jaguar(1, RobotMap.PWM_DEVICE_LEFT_FRONT_DRIVE_MOTOR);
        this.rightFront = new Jaguar(1, RobotMap.PWM_DEVICE_RIGHT_FRONT_DRIVE_MOTOR);
        this.leftRear = new Jaguar(1, RobotMap.PWM_DEVICE_LEFT_REAR_DRIVE_MOTOR);
        this.rightRear = new Jaguar(1, RobotMap.PWM_DEVICE_RIGHT_REAR_DRIVE_MOTOR);
        this.robotDrive = new RobotDrive(leftFront, leftRear, rightFront, rightRear);
        this.robotDrive.setSafetyEnabled(false);
        this.robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        this.robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
    }
    public void initDefaultCommand() {
        this.setDefaultCommand(new DriveWithJoystick());
        System.out.println("Initialize default command");
    }

    public void driveWithJoystick(Joystick joystick) {
        this.robotDrive.mecanumDrive_Cartesian(joystick.getX(), joystick.getY() * -1, joystick.getZ(), 0.0);
    }

    public static Drive getInstance() {
        return INSTANCE;
    }

    public Joystick getDriveJoystick() {
        return driveJoystick;
    }
}