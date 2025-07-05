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
 * Represents a vehicle (taxi/shuttle) with capacity and status tracking
 */
public class Vehicle {
    private final int seats;
    private VehicleStatus status;
    private final Driver driver;

    public Vehicle(int seats, Driver driver) {
        if (seats <= 0) {
            throw new IllegalArgumentException("Vehicle must have at least 1 seat.");
        }
        this.seats = seats;
        this.driver = driver;
        this.status = VehicleStatus.IDLE;
    }

    public int getSeats() { return seats; }
    public VehicleStatus getStatus() { return status; }
    public Driver getDriver() { return driver; }

    public void setStatus(VehicleStatus status) {
        this.status = status;
        driver.notifyStatusChange(status);
    }
}




