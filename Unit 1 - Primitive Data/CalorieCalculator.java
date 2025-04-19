import java.util.Scanner;

public class CalorieCalculator {
    public static void main(String[] args) {
        // Declare variables
        int weight;          // weight in pounds
        int activityCode;    // code for activity type
        int duration;        // exercise duration in minutes
        double activityFactor;
        double caloriesBurned;
        
        // Create Scanner for input
        Scanner input = new Scanner(System.in);
        
        // Get user input
        System.out.print("Enter your weight in pounds: ");
        weight = input.nextInt();
        
        System.out.print("Enter activity code (1=walking, 2=jogging, 3=swimming, 4=cycling): ");
        activityCode = input.nextInt();
        
        System.out.print("Enter duration in minutes: ");
        duration = input.nextInt();
        
        // Determine activity factor based on code
        if (activityCode == 1) {
            activityFactor = 4.5;
        } else if (activityCode == 2) {
            activityFactor = 7.5;
        } else if (activityCode == 3) {
            activityFactor = 8.0;
        } else if (activityCode == 4) {
            activityFactor = 6.0;
        } else {
            activityFactor = 0.0;  // Invalid activity code
            System.out.println("Error: Invalid activity code. Using 0.0 as factor.");
        }
        
        // Calculate calories burned
        // Note: Using double division to get precise result
        caloriesBurned = (weight * activityFactor * duration) / 100.0;
        
        // Display result
        System.out.println("Calories burned: " + caloriesBurned);
        
        // Close Scanner
        input.close();
    }
}