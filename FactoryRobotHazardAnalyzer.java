import java.util.Scanner;

/**
 * FactoryRobotHazardAnalyzer
 *
 * UC5: Refactor Validation and Calculation into Separate Method
 *
 * This program:
 * - Collects user input in main()
 * - Delegates validation and hazard calculation to a separate method
 * - Returns hazard risk score if inputs are valid
 */

public class FactoryRobotHazardAnalyzer {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Arm Precision (0.0 - 1.0):");
        double armPrecision = scanner.nextDouble();

        System.out.println("Enter Worker Density (1 - 20):");
        int workerDensity = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Enter Machinery State (Worn/Faulty/Critical):");
        String machineryState = scanner.nextLine();

        double hazardRisk = calculateHazardRisk(
                armPrecision,
                workerDensity,
                machineryState
        );

        if (hazardRisk != -1) {
            System.out.println("Robot Hazard Risk Score: " + hazardRisk);
        }

        scanner.close();
    }

    /**
     * Calculates hazard risk after validating inputs.
     * Returns -1 if validation fails.
     */
    public static double calculateHazardRisk(
            double armPrecision,
            int workerDensity,
            String machineryState) {

        if (armPrecision < 0.0 || armPrecision > 1.0) {
            System.out.println("Error: Arm precision must be between 0.0 and 1.0");
            return -1;
        }

        if (workerDensity < 1 || workerDensity > 20) {
            System.out.println("Error: Worker density must be between 1 and 20");
            return -1;
        }

        double machineRiskFactor;

        if (machineryState.equals("Worn")) {
            machineRiskFactor = 1.3;
        } else if (machineryState.equals("Faulty")) {
            machineRiskFactor = 2.0;
        } else if (machineryState.equals("Critical")) {
            machineRiskFactor = 3.0;
        } else {
            System.out.println("Error: Unsupported machinery state");
            return -1;
        }

        return ((1.0 - armPrecision) * 15.0)
                + (workerDensity * machineRiskFactor);
    }
}
