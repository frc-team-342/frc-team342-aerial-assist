package org.first.team342;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.first.team342.commands.lift.LiftDownCommand;
import org.first.team342.commands.lift.LiftUpCommand;
import org.first.team342.commands.lift.StopLiftCommand;
import org.first.team342.commands.lift.KickerOnCommand;
import org.first.team342.commands.lift.KickerOffCommand;
import org.first.team342.commands.catapult.CatapultReleaseCommand;
import org.first.team342.commands.catapult.CatapultReloadHighCommand;
import org.first.team342.commands.catapult.CatapultReloadLowCommand;
import org.first.team342.commands.catapult.CatapultStopCommand;
import org.first.team342.commands.catapult.TestLightSensorsCommand;


public class OI {

    private Joystick driveController;
    private static final OI INSTANCE = new OI();

    private OI() {
        Preferences preferences = Preferences.getInstance();
        this.driveController = new Controller(RobotMap.JOYSTICK_DRIVE_CONTROL);
        JoystickButton liftDown = new JoystickButton(driveController, 3);
        JoystickButton liftUp = new JoystickButton(driveController, 2);
        JoystickButton catapultReloadLow = new JoystickButton(driveController, 6);
        JoystickButton catapultReloadHigh = new JoystickButton(driveController, 4);
        JoystickButton catapultRelease = new JoystickButton(driveController, 1);
        JoystickButton kicker = new JoystickButton(driveController, 11);
        
        liftDown.whileHeld(new LiftDownCommand());
        liftDown.whenReleased(new StopLiftCommand());
        
        liftUp.whileHeld(new LiftUpCommand());
        liftUp.whenReleased(new StopLiftCommand());
        
        kicker.whileHeld(new KickerOnCommand());
        kicker.whenReleased(new KickerOffCommand());
        
        catapultRelease.whileHeld(new CatapultReleaseCommand());
        catapultRelease.whenReleased(new CatapultStopCommand());
        
        catapultReloadLow.whenPressed(new CatapultReloadLowCommand());
        catapultReloadHigh.whenPressed(new CatapultReloadHighCommand());

        JoystickButton testLightSensors = new JoystickButton(driveController, 7);
        testLightSensors.whileHeld(new TestLightSensorsCommand());
//        catapultReload.whileHeld(new CatapultReloadCommand());
//        catapultReload.whileHeld(new CatapultReloadCommand());
//        catapultReload.whenReleased(new CatapultStopCommand());
//        catapultRelease.whenReleased(new CatapultStopCommand());
    }

    public static OI getInstance() {
        return INSTANCE;
    }

    public Joystick getJoystick() {
        return driveController;
    }
}
