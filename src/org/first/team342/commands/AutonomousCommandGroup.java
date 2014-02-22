/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.first.team342.subsystems.DriveSystem;
import org.first.team342.subsystems.CatapultSystem;
import org.first.team342.commands.autonomous.SensorAutonomous;
import org.first.team342.commands.catapult.CatapultReleaseCommand;


/**
 *
 * @author Team 342
 */
public class AutonomousCommandGroup extends CommandGroup {
    
    DriveSystem drive;
    CatapultSystem catapult;
    
    public AutonomousCommandGroup() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
        this.drive = drive.getInstance();
        this.catapult = catapult.getInstance();
        this.requires(this.drive);
        this.requires(this.catapult);
        addSequential(new SensorAutonomous());
        addSequential(new CatapultReleaseCommand());
        
    }
    protected void initialize(){
        
    }
    
    public void execute() {
        
    }

    public boolean isFinished() {
        return true;
    }

    public void interrupted() {

    }

    protected void end() {

    }

}
