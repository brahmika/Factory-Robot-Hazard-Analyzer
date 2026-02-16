/**
 * FactoryRobotHazardAnalyzer
 *
 * UC6: Introduce Custom Exception for Invalid Input
 *
 * Concepts Demonstrated:
 * - Custom Exception
 * - Exception throwing
 * - Try-catch handling
 * - Method abstraction
 */
import java.util.Scanner;
public class FactoryRobotHazardAnalyzer {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {

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

            System.out.println("Robot Hazard Risk Score: " + hazardRisk);

        } catch (InvalidInputException e) {

            System.out.println("Validation Error: " + e.getMessage());

        } finally {
            scanner.close();
        }
    }

    /**
     * Validates input and calculates hazard risk.
     * Throws InvalidInputException if validation fails.
     */
    public static double calculateHazardRisk(
            double armPrecision,
            int workerDensity,
            String machineryState)
            throws InvalidInputException {

        if (armPrecision < 0.0 || armPrecision > 1.0) {
            throw new InvalidInputException(
                    "Arm precision must be between 0.0 and 1.0"
            );
        }

        if (workerDensity < 1 || workerDensity > 20) {
            throw new InvalidInputException(
                    "Worker density must be between 1 and 20"
            );
        }

        double machineRiskFactor;

        if (machineryState.equals("Worn")) {
            machineRiskFactor = 1.3;
        } else if (machineryState.equals("Faulty")) {
            machineRiskFactor = 2.0;
        } else if (machineryState.equals("Critical")) {
            machineRiskFactor = 3.0;
        } else {
            throw new InvalidInputException(
                    "Unsupported machinery state"
            );
        }

        return ((1.0 - armPrecision) * 15.0)
                + (workerDensity * machineRiskFactor);
    }
}
