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
 * Represents a geographic location with x and y coordinates (0-100).
 * Includes distance calculation functionality.
 */
public class Location {
    private final int x;
    private final int y;

    public Location(int x, int y) {
        if (x < 0 || x > 100 || y < 0 || y > 100) {
            throw new IllegalArgumentException("Coordinates must be between 0 and 100.");
        }
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    /**
     * Calculates Euclidean distance to another location
     * @param other The destination location
     * @return Distance between the two points
     */
    public double distanceTo(Location other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }
}
