public class RainfallAnalyzer {
    // Instance variable
    private int[] rainfall;
    
    // Constructor
    public RainfallAnalyzer(int[] measurements) {
        // Create a copy of the array to avoid external modifications
        rainfall = new int[measurements.length];
        for (int i = 0; i < measurements.length; i++) {
            rainfall[i] = measurements[i];
        }
    }
    
    // Method to find average daily rainfall
    public double getAverageRainfall() {
        if (rainfall.length == 0) {
            return 0.0;
        }
        
        int sum = 0;
        for (int amount : rainfall) {
            sum += amount;
        }
        
        return (double) sum / rainfall.length;
    }
    
    // Method to find the number of dry days
    public int countDryDays() {
        int count = 0;
        for (int amount : rainfall) {
            if (amount == 0) {
                count++;
            }
        }
        return count;
    }
    
    // Method to find the wettest day
    public int getMaxRainfall() {
        if (rainfall.length == 0) {
            return 0;
        }
        
        int max = rainfall[0];
        for (int i = 1; i < rainfall.length; i++) {
            if (rainfall[i] > max) {
                max = rainfall[i];
            }
        }
        return max;
    }
    
    // Method to get an array of wet days only
    public int[] getWetDaysOnly() {
        // Count wet days first
        int wetDayCount = rainfall.length - countDryDays();
        
        // Create array of the right size
        int[] wetDays = new int[wetDayCount];
        
        // Fill the array with non-zero rainfall amounts
        int index = 0;
        for (int amount : rainfall) {
            if (amount > 0) {
                wetDays[index] = amount;
                index++;
            }
        }
        
        return wetDays;
    }
    
    // Method to check for 3 or more consecutive dry days
    public boolean hasThreeConsecutiveDryDays() {
        int currentStreak = 0;
        
        for (int amount : rainfall) {
            if (amount == 0) {
                currentStreak++;
                if (currentStreak >= 3) {
                    return true;
                }
            } else {
                currentStreak = 0;
            }
        }
        
        return false;
    }
}