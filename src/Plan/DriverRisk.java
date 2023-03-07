package Plan;

/**
 * DriverRisk class represents a specific type of Risk for an insurance company that provides coverage for drivers.
 * This class extends the Risk class and provides specific values for the premium, coverage, and ceiling attributes.
 */
public class DriverRisk extends Risk {

    /**
     * Returns the premium value for the DriverRisk type of risk.
     * @return A float representing the premium value (5%).
     */
    @Override
    public float getPremium() {
        return 0.05f;
    }

    /**
     * Returns the coverage value for the DriverRisk type of risk.
     * @return A float representing the coverage value (70%).
     */
    @Override
    public float getCoverage() {
        return 0.7f;
    }

    /**
     * Returns the ceiling value for the DriverRisk type of risk.
     * @return A float representing the ceiling value (6).
     */
    @Override
    public float getCeiling() {
        return 6;
    }

    /**
     * A String array that represents the driver risks covered by the insurance company.
     */
    public String[] driverRisksCovered={
            "Driver Damage"
    };
}
