/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package balextranit;

/**
 *
 * @author DELL
 */


/**
 * Represents a passenger with pickup/destination locations
 */
public class Passenger {
    private final Location pickup;
    private final Location destination;

    public Passenger(Location pickup, Location destination) {
        this.pickup = pickup;
        this.destination = destination;
    }

    public Location getPickup() { return pickup; }
    public Location getDestination() { return destination; }

    /**
     * Estimates fare based on distance and vehicle type
     * @param isShuttle Whether the vehicle is a shuttle
     * @return Estimated fare amount
     */
    public double estimateFare(boolean isShuttle) {
        double distance = pickup.distanceTo(destination);
        return isShuttle ? distance * 0.5 : distance * 1.0;
    }
}