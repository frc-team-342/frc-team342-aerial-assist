package org.first.team342;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    private static final OI INSTANCE = new OI();

    private Joystick driveJoystick = null;

    private OI() {
        this.driveJoystick = new Joystick(RobotMap.DRIVE_JOYSTICK_USB_PORT);
    }

    public static OI getInstance() {
        return INSTANCE;
    }

    public Joystick getDriveJoystick() {
        return this.driveJoystick;
    }
}
