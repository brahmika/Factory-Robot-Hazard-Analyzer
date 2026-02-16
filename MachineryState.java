/**
 * Enum representing valid machinery states.
 * Replaces String-based state handling.
 */
public enum MachineryState {

    WORN(1.3),
    FAULTY(2.0),
    CRITICAL(3.0);

    private final double riskFactor;

    MachineryState(double riskFactor) {
        this.riskFactor = riskFactor;
    }

    public double getRiskFactor() {
        return riskFactor;
    }
}
