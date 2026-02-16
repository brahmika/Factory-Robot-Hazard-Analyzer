import java.util.Scanner;

/**
 * FactoryRobotHazardAnalyzer
 *
 * UC2: Accept Robot Hazard Inputs
 *
 * This program collects input values required
 * for hazard analysis from the user.
 *
 * Current Functionality:
 * - Accept arm precision (double)
 * - Accept worker density (int)
 * - Accept machinery state (String)
 * - Echo inputs back to the user
 */

public class FactoryRobotHazardAnalyzer {

    public static void main(String[] args) {

        // Create Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt and read arm precision
        System.out.println("Enter Arm Precision (0.0 - 1.0):");
        double armPrecision = scanner.nextDouble();

        // Prompt and read worker density
        System.out.println("Enter Worker Density (1 - 20):");
        int workerDensity = scanner.nextInt();

        // Consume leftover newline
        scanner.nextLine();

        // Prompt and read machinery state
        System.out.println("Enter Machinery State (Worn/Faulty/Critical):");
        String machineryState = scanner.nextLine();

        // Echo entered values
        System.out.println("\nInput Summary:");
        System.out.println("Arm Precision: " + armPrecision);
        System.out.println("Worker Density: " + workerDensity);
        System.out.println("Machinery State: " + machineryState);

        // Close scanner
        scanner.close();
    }
}
