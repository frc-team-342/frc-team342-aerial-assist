package org.first.team342;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.first.team342.commands.drive.DriveWithJoystick;
import org.first.team342.commands.lift.LiftDownCommand;
import org.first.team342.commands.lift.LiftUpCommand;
import org.first.team342.commands.lift.StopLiftCommand;

public class OI {

    private Joystick driveController;
    private static final OI INSTANCE = new OI();

    private OI() {
        Preferences preferences = Preferences.getInstance();
        this.driveController = new Controller(RobotMap.JOYSTICK_DRIVE_CONTROL);
        JoystickButton liftDown = new JoystickButton(driveController, 3);
        JoystickButton liftUp = new JoystickButton(driveController, 2);
        liftDown.whileHeld(new LiftDownCommand());
        liftDown.whenReleased(new StopLiftCommand());
        liftUp.whileHeld(new LiftUpCommand());
        liftUp.whenReleased(new StopLiftCommand());

    }

    public static OI getInstance() {
        return INSTANCE;
    }

    public Joystick getJoystick() {
        return driveController;
    }
}
