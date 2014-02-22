/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342.commands.gyro;

import org.first.team342.RobotUtilities;
import org.first.team342.commands.CommandBase;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.AnalogChannel;
import org.first.team342.subsystems.DriveSystem;

/**
 *
 * @author Team342
 */
public class GyroReset extends CommandBase {

    private DriveSystem drive;

    public GyroReset() {
        this.drive = DriveSystem.getInstance();
        requires(this.drive);

    }

    protected void initialize() {
    }

    protected void execute() {
        this.drive.gyroReset();
    }

    public boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }

}
