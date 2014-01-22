/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.TableKeyNotDefinedException;

/**
 *
 * @author Team342
 */
public class RobotUtilities {

    /**
     * Initialize a CAN Jaguar device with the given device address.
     *
     * @param deviceNumber the CAN device address.
     *
     * @return the initialized CAN device. If an error occurs then <code>null<code> is returned.
     
    public static CANJaguar initializeCANJaguar(int deviceNumber) {
        CANJaguar jaguar = null;

        try {
            jaguar = new CANJaguar(deviceNumber);
        } catch (CANTimeoutException ex) {
            System.out.println(ex.getMessage() + " - Device Number: " + deviceNumber);
        }

        return jaguar;
    }
*/
    
    public static Jaguar initializeJaguar(int slot, int channel) {
        Jaguar jaguar = new Jaguar(slot, channel);
        return jaguar;
    }
}
