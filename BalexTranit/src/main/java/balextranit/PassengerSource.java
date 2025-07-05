/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package balextranit;

/**
 *
 * @author DELL
 */

import java.util.Random;

/**
 * Generates passenger pickup requests with random locations
 */
public class PassengerSource {
    private final Company company;
    private final Random random = new Random();

    public PassengerSource(Company company) {
        this.company = company;
    }

    /**
     * Creates a pickup request with random locations
     * @return true if vehicle was assigned, false otherwise
     */
    public boolean requestPickup() {
        Location pickup = new Location(random.nextInt(101), random.nextInt(101));
        Location destination = new Location(random.nextInt(101), random.nextInt(101));
        Passenger passenger = new Passenger(pickup, destination);
        return company.scheduleVehicle(passenger);
    }
}