/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.DriverStationLCD;
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

    private static final DriverStationLCD LCD = DriverStationLCD.getInstance();
    private static String driveStatus = "";
    private static String liftStatus = "";
    private static String catapultStatus = "";
    private static String shotsfiredStatus = "";

    /**
     * Initialize a CAN Jaguar device with the given device address.
     *
     * @param deviceNumber the CAN device address.
     *
     * @return the initialized CAN device. If an error occurs then <code>null<code> is returned.
     *
     * public static CANJaguar initializeCANJaguar(int deviceNumber) {
     * CANJaguar jaguar = null;
     *
     * try {
     * jaguar = new CANJaguar(deviceNumber);
     * } catch (CANTimeoutException ex) {
     * System.out.println(ex.getMessage() + " - Device Number: " + deviceNumber);
     * }
     *
     * return jaguar;
     * }
     */
    public static Jaguar initializeJaguar(int slot, int channel) {
        Jaguar jaguar = new Jaguar(slot, channel);
        return jaguar;
    }

    public static void updateLiftStatus(String status) {
        liftStatus = status;
        updateStatus();
    }

    public static void updateDriveStatus(String status) {
        driveStatus = status;
        updateStatus();
    }

    public static void updateCatapultStatus(String status) {
        catapultStatus = status;
        updateStatus();
    }

    public static void updateShotsFiredStatus(String status) {
        shotsfiredStatus = status;
        updateStatus();
    }

    public static void updateStatus() {
        LCD.clear();
        LCD.println(DriverStationLCD.Line.kUser1, 1, "Drive: " + driveStatus);
        LCD.println(DriverStationLCD.Line.kUser2, 1, "Lift: " + liftStatus);
        LCD.println(DriverStationLCD.Line.kUser3, 1, "Catapult: " + catapultStatus);
        LCD.println(DriverStationLCD.Line.kUser4, 1, "Times Fired: " + shotsfiredStatus);
        LCD.updateLCD();
    }
}
