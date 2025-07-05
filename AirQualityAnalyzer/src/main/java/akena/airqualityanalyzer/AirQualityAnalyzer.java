/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package akena.airqualityanalyzer;

/**
 *
 * @author DELL
 */
import java.util.Arrays;

public class AirQualityAnalyzer {
    public static void main(String[] args) {
        // i) Generate 30 random AQI readings between 1 and 300
        int[] aqiReadings = generateAQIReadings(30);
        System.out.println("Generated AQI Readings:");
        System.out.println(Arrays.toString(aqiReadings));

        // ii) Compute and display the median AQI value
        double median = calculateMedian(aqiReadings);
        System.out.printf("\nMedian AQI: %.1f\n", median);

        // iii) Identify and count hazardous days (AQI > 200)
        int hazardousDays = countHazardousDays(aqiReadings);
        System.out.println("Number of hazardous days (AQI > 200): " + hazardousDays);
    }

    /**
     * Generates an array of random AQI readings
     * @param count Number of readings to generate
     * @return Array of random AQI values between 1-300
     */
    public static int[] generateAQIReadings(int count) {
        int[] readings = new int[count];
        for (int i = 0; i < count; i++) {
            // Generate random number between 1-300 (inclusive)
            readings[i] = (int)(Math.random() * 300) + 1;
        }
        return readings;
    }

    /**
     * Calculates the median value of AQI readings
     * @param readings Array of AQI values
     * @return Median value as double
     */
    public static double calculateMedian(int[] readings) {
        // Create a copy to avoid modifying original array
        int[] sorted = Arrays.copyOf(readings, readings.length);
        Arrays.sort(sorted); // Sort for median calculation

        int length = sorted.length;
        if (length % 2 == 0) {
            // If even number of elements, average middle two
            return (sorted[length/2 - 1] + sorted[length/2]) / 2.0;
        } else {
            // If odd number, return middle element
            return sorted[length/2];
        }
    }

    /**
     * Counts days with hazardous AQI levels (>200)
     * @param readings Array of AQI values
     * @return Count of hazardous days
     */
    public static int countHazardousDays(int[] readings) {
        int count = 0;
        for (int aqi : readings) {
            if (aqi > 200) {
                count++;
            }
        }
        return count;
    }
}