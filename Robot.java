/**
 * Robot class represents a factory robot and
 * encapsulates hazard risk calculation logic.
 */

public class Robot {

    private double armPrecision;
    private int workerDensity;
    private String machineryState;

    public Robot(double armPrecision,
                 int workerDensity,
                 String machineryState)
            throws InvalidInputException {

        validate(armPrecision, workerDensity, machineryState);

        this.armPrecision = armPrecision;
        this.workerDensity = workerDensity;
        this.machineryState = machineryState;
    }

    /**
     * Validates robot hazard parameters.
     */
    private void validate(double armPrecision,
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

        if (!machineryState.equals("Worn") &&
                !machineryState.equals("Faulty") &&
                !machineryState.equals("Critical")) {

            throw new InvalidInputException(
                    "Unsupported machinery state"
            );
        }
    }

    /**
     * Calculates hazard risk score.
     */
    public double calculateHazardRisk() {

        double machineRiskFactor;

        if (machineryState.equals("Worn")) {
            machineRiskFactor = 1.3;
        } else if (machineryState.equals("Faulty")) {
            machineRiskFactor = 2.0;
        } else {
            machineRiskFactor = 3.0; // Critical
        }

        return ((1.0 - armPrecision) * 15.0)
                + (workerDensity * machineRiskFactor);
    }
}
