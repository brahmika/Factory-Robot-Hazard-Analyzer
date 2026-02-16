/**
 * FactoryRobotHazardAnalyzer
 *
 * UC4: Introduce Validation Using Conditional Logic
 *
 * This program:
 * - Accepts hazard-related inputs
 * - Validates input ranges using if-else statements
 * - Calculates hazard risk only if inputs are valid
 */
import java.util.Scanner;
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

        // ===== Validation Section =====

        if (armPrecision < 0.0 || armPrecision > 1.0) {
            System.out.println("Error: Arm precision must be between 0.0 and 1.0");
            return;
        }

        if (workerDensity < 1 || workerDensity > 20) {
            System.out.println("Error: Worker density must be between 1 and 20");
            return;
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
            return;
        }

        // Hazard Calculation

        double hazardRisk =
                ((1.0 - armPrecision) * 15.0)
                        + (workerDensity * machineRiskFactor);

        System.out.println("Robot Hazard Risk Score: " + hazardRisk);

        scanner.close();
    }
}
