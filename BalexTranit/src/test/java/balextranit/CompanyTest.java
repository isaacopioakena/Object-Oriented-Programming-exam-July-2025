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
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class CompanyTest {
    private Company company;
    private Vehicle availableVehicle;
    private Vehicle busyVehicle;

    @Before
    public void setUp() {
        company = new Company();
        availableVehicle = new Vehicle(4, new Driver("DRV-001"));
        busyVehicle = new Vehicle(6, new Driver("DRV-002"));
        busyVehicle.setStatus(VehicleStatus.IN_TRANSIT);
    }

    @Test
    public void testScheduleVehicle_WithAvailableVehicle_ReturnsTrue() {
        company.addVehicle(availableVehicle);
        Passenger passenger = new Passenger(new Location(10, 10), new Location(20, 20));
        assertTrue(company.scheduleVehicle(passenger));
        assertEquals(VehicleStatus.IN_TRANSIT, availableVehicle.getStatus());
    }

    @Test
    public void testScheduleVehicle_WhenNoVehiclesAvailable_IncrementsLostFares() {
        company.addVehicle(busyVehicle); // Only busy vehicle available
        Passenger passenger = new Passenger(new Location(30, 30), new Location(40, 40));
        
        assertFalse(company.scheduleVehicle(passenger));
        assertEquals(1, company.getLostFares());
    }
}