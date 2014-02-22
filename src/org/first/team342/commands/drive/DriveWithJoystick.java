/*
 * Copyright 2013 FRC Team 342
 *
 * This file is part of "FRC Team 342 Ultimate Ascent Robot".
 *
 * "FRC Team 342 Ultimate Ascent Robot" is free software: you can redistribute
 * it and/or modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * "FRC Team 342 Ultimate Ascent Robot" is distributed in the hope that it
 * will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General
 * Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with "FRC Team 342 Ultimate Ascent Robot".  If not, see
 * <http://www.gnu.org/licenses/>.
 */
package org.first.team342.commands.drive;

import edu.wpi.first.wpilibj.Joystick;
import org.first.team342.OI;
import org.first.team342.RobotUtilities;
import org.first.team342.commands.CommandBase;
import org.first.team342.subsystems.DriveSystem;

/*
 * @author FIRST Team 342
 */
public class DriveWithJoystick extends CommandBase {

    private DriveSystem drive = DriveSystem.getInstance();
    private Joystick joystick;

    public DriveWithJoystick() {
        this.drive = DriveSystem.getInstance();
        this.requires(this.drive);
    }

    protected void initialize() {
        OI oi = OI.getInstance();
        this.joystick = oi.getJoystick();
    }

    protected void execute() {
        RobotUtilities.updateDriveStatus("Connected");
        this.drive.driveWithJoystick(this.joystick);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
