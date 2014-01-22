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
package org.first.team342;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author Team 342
 */
public class Controller extends Joystick {

    private int ControllerMode;

    public Controller(int port) {
        super(port);
        ControllerMode = 1;
    }

    public double getMovX() {
        double MovX = 0;
        MovX = this.getX();
        //System.out.println("Moving X");
        return MovX;
    }

    public double getMovY() {
        double MovY = 0;
        if (ControllerMode == 1) {
            MovY = this.getY();
        }
        return MovY;
    }

    public double getRot() {
        double Rot = 0;
        if (ControllerMode == 1) {
            Rot = (this.getAxis(AxisType.kZ));
        }
        return Rot;
    }

    /*public double getLeftY(){
     return this.getY();
     }
     public double getLeftX(){
     return this.getX();
     }
     public double getRightY(){
     return this.getRawAxis(5);
    
     }
     public double getRightX(){
     return this.getRawAxis(4);
     }
    
     public double getBackTrigger(){
     return this.getZ();
     }
     */
}
