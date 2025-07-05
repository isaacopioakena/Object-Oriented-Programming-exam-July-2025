/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package balextranit;

/**
 *
 * @author DELL
 */

import balextranit.enums.VehicleStatus;

/**
 * Represents a driver who receives vehicle status updates
 */
public class Driver {
    private final String id;

    public Driver(String id) {
        this.id = id;
    }

    public String getId() { return id; }

    public void notifyStatusChange(VehicleStatus status) {
        System.out.println("Driver " + id + " notified: Vehicle is now " + status);
    }
}