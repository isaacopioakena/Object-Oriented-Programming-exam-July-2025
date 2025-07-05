package balextranit;

import balextranit.enums.VehicleStatus;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages vehicles and handles ride scheduling
 */
public class Company {
    private final List<Vehicle> vehicles = new ArrayList<>();
    private int lostFares = 0;
    private static final String LOST_FARES_LOG = "lost_fares.log";

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public List<Vehicle> getVehicles() { return vehicles; }
    public int getLostFares() { return lostFares; }

    /**
     * Attempts to schedule a vehicle for a passenger
     * @param passenger The passenger needing transport
     * @return true if vehicle was assigned, false otherwise
     */
    public boolean scheduleVehicle(Passenger passenger) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getStatus() == VehicleStatus.IDLE) {
                vehicle.setStatus(VehicleStatus.IN_TRANSIT);
                return true;
            }
        }
        lostFares++;
        logLostFare();
        return false;
    }

    private void logLostFare() {
        String logEntry = "Lost fare at " + LocalDateTime.now() + "\n";
        try {
            Files.write(
                Paths.get(LOST_FARES_LOG),
                logEntry.getBytes(),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            System.err.println("Failed to log lost fare: " + e.getMessage());
        }
    }
}