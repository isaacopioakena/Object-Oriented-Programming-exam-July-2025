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
 * Main class to demonstrate the transportation system
 */
public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        company.addVehicle(new Vehicle(4, new Driver("DRV-001")));
        company.addVehicle(new Vehicle(8, new Driver("DRV-002")));
        
        PassengerSource source = new PassengerSource(company);

        // Simulate 5 pickup requests
        for (int i = 0; i < 5; i++) {
            boolean success = source.requestPickup();
            System.out.println("Request " + (i+1) + ": " + 
                (success ? "Assigned vehicle" : "No vehicles available"));
        }

        System.out.println("Total lost fares: " + company.getLostFares());
    }
}
