
/**
 * UC7: Object-Oriented Refactor
 *
 * Main class now:
 * - Collects user input
 * - Creates Robot object
 * - Delegates hazard calculation to object
 * - Handles exceptions
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

            Robot robot = new Robot(
                    armPrecision,
                    workerDensity,
                    machineryState
            );

            double hazardRisk = robot.calculateHazardRisk();

            System.out.println("Robot Hazard Risk Score: " + hazardRisk);

        } catch (InvalidInputException e) {

            System.out.println("Validation Error: " + e.getMessage());

        } finally {
            scanner.close();
        }
    }
}
