import java.util.Scanner;

/**
 * UC8: Enum-Based Machinery State
 */

public class FactoryRobotHazardAnalyzer {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {

            System.out.println("Enter Arm Precision (0.0 - 1.0):");
            double armPrecision = scanner.nextDouble();

            System.out.println("Enter Worker Density (1 - 20):");
            int workerDensity = scanner.nextInt();

            scanner.nextLine();

            System.out.println("Enter Machinery State (WORN/FAULTY/CRITICAL):");
            String stateInput = scanner.nextLine().toUpperCase();

            MachineryState machineryState =
                    MachineryState.valueOf(stateInput);

            Robot robot = new Robot(
                    armPrecision,
                    workerDensity,
                    machineryState
            );

            double hazardRisk = robot.calculateHazardRisk();

            System.out.println("Robot Hazard Risk Score: " + hazardRisk);

        } catch (IllegalArgumentException e) {

            System.out.println("Invalid machinery state entered.");

        } catch (InvalidInputException e) {

            System.out.println("Validation Error: " + e.getMessage());

        } finally {
            scanner.close();
        }
    }
}
