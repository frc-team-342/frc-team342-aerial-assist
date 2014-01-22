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
import org.first.team342.Controller;
import org.first.team342.OI;
import org.first.team342.commands.CommandBase;
import org.first.team342.subsystems.Drive;

/*
 * @author FIRST Team 342
 */
public class DriveWithJoystick extends CommandBase {

    private Drive drive = Drive.getInstance();
    private Joystick joystick;

    public DriveWithJoystick() {
        this.drive = Drive.getInstance();
        this.requires(this.drive);
        System.out.println("Constructing joystick");

    }

    // Called just before this Command runs the first time
    protected void initialize() {
        OI oi = OI.getInstance();
        this.joystick = oi.getJoystick();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        this.drive.driveWithJoystick(this.joystick);
        //System.out.println(joystick.getMovX()+ " " +joystick.getMovY()+ " " +joystick.getRot());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
