/**
 * FactoryRobotHazardAnalyzer
 *
 * UC3: Calculate Hazard Risk Score (No Validation)
 *
 * This program:
 * - Accepts hazard-related inputs
 * - Calculates hazard risk using business formula
 * - Displays computed hazard risk score
 *
 */
import java.util.Scanner;
public class FactoryRobotHazardAnalyzer {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Collect input
        System.out.println("Enter Arm Precision (0.0 - 1.0):");
        double armPrecision = scanner.nextDouble();

        System.out.println("Enter Worker Density (1 - 20):");
        int workerDensity = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Enter Machinery State (Worn/Faulty/Critical):");
        String machineryState = scanner.nextLine();

        /*
         * UC3 Requirement:
         * No validation yet.
         * We assume machinery risk factor = 2.0 (temporary).
         */
        double machineRiskFactor = 2.0;

        // Hazard Risk Formula
        double hazardRisk =
                ((1.0 - armPrecision) * 15.0)
                        + (workerDensity * machineRiskFactor);

        // Display result
        System.out.println("Robot Hazard Risk Score: " + hazardRisk);

        scanner.close();
    }
}
