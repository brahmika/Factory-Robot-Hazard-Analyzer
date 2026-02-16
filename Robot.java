/**
 * Robot class represents a factory robot and
 * encapsulates hazard risk calculation logic.
 */

public class Robot {

    private double armPrecision;
    private int workerDensity;
    private MachineryState machineryState;

    public Robot(double armPrecision,
                 int workerDensity,
                 MachineryState machineryState)
            throws InvalidInputException {

        validate(armPrecision, workerDensity);

        this.armPrecision = armPrecision;
        this.workerDensity = workerDensity;
        this.machineryState = machineryState;
    }

    /**
     * Validates numeric parameters only.
     */
    private void validate(double armPrecision,
                          int workerDensity)
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
    }

    /**
     * Calculates hazard risk score.
     */
    public double calculateHazardRisk() {

        return ((1.0 - armPrecision) * 15.0)
                + (workerDensity * machineryState.getRiskFactor());
    }
}
