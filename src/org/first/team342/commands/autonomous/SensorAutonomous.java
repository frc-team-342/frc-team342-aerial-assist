/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342.commands.autonomous;

import edu.wpi.first.wpilibj.DriverStation;
import org.first.team342.commands.CommandBase;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.RobotDrive;
import org.first.team342.subsystems.DriveSystem;
import org.first.team342.subsystems.CatapultSystem;
import org.first.team342.commands.catapult.CatapultReleaseCommand;



/**
 *
 * @author FIRST Team 342
 */
public class SensorAutonomous extends CommandBase {
    
    private DriveSystem drive;
    private CatapultSystem catapult;
    private boolean status;

    public SensorAutonomous() {
        this.drive = DriveSystem.getInstance();
        this.catapult = CatapultSystem.getInstance();
        this.drive.getRange();
        requires(this.drive);
    }

    // Called just before this Command runs the first time
    public void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    public void execute() {
        double currentDistance = this.drive.getRange();
        // Below is Target Distance.  This should be edited.
        double targetDistance = 25;
        status = false;
        if (currentDistance >= targetDistance + 20) {
            this.drive.forward(0.5);
        } else if (currentDistance >= targetDistance + 10) {
            this.drive.forward(0.3);
        } else if (currentDistance < targetDistance - 20) {
            this.drive.reverse(-0.5);
        } else if (currentDistance <= targetDistance - 10) {
            this.drive.reverse(-0.3);
        } else {
            this.drive.stop(0.0);
            this.catapult.release();
            status = true;
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    public boolean isFinished() {
        return status;
    }

    // Called once after isFinished returns true
    public void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    public void interrupted() {
    }
}
