package org.first.team342;

public class RobotMap {

    //lift
    public static final int PWM_CHANNEL_LIFTSYSTEM = 6;
    //limit switches for LIFTSYSTEM
    public static final int DIO_CHANNEL_FORKUP = 5;
    public static final int DIO_CHANNEL_FORKDOWN = 6;
    //catapult
    public static final int PWM_CHANNEL_CATAPULT_MOTOR = 8;
    //light sensors catapult
    public static final int DIO_CHANNEL_LOW_SENSOR = 3;
    public static final int DIO_CHANNEL_HIGH_SENSOR = 4;
    //catapult release mechanism
    public static final int PWM_CHANNEL_RELEASE_MOTOR = 9;
    public static final int DIO_CHANNEL_LOCKED_SWITCH = 2;
    public static final int DIO_CHANNEL_RELEASED_SWITCH = 1;
    //kicker
    public static final int PWM_CHANNEL_KICKER = 10;
    //joystick ports
    public static final int JOYSTICK_DRIVE_CONTROL = 1;
    //drive system
    public static final int PWM_CHANNEL_RIGHT_FRONT_DRIVE_MOTOR = 2;
    public static final int PWM_CHANNEL_LEFT_FRONT_DRIVE_MOTOR = 1;
    public static final int PWM_CHANNEL_LEFT_REAR_DRIVE_MOTOR = 4;
    public static final int PWM_CHANNEL_RIGHT_REAR_DRIVE_MOTOR = 3;
    public static final int ANALOG_CHANNEL_RANGE_SENSOR = 1;
    public static final int ANALOG_CHANNEL_GYRO_SENSOR = 2;
}
