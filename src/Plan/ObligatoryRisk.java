package Plan;

/**
 * ObligatoryRisk class represents a specific type of Risk for an insurance company that provides obligatory coverage.
 * This class extends the Risk class and provides specific values for the premium, coverage, and ceiling attributes.
 */
public class ObligatoryRisk extends Risk {

    /**
     * Returns the premium value for the ObligatoryRisk type of risk.
     * @return A float representing the premium value (1%).
     */
    @Override
    public float getPremium() {
        return 0.01f;
    }

    /**
     * Returns the coverage value for the ObligatoryRisk type of risk.
     * @return A float representing the coverage value (60%).
     */
    @Override
    public float getCoverage() {
        return 0.6f;
    }

    /**
     * Returns the ceiling value for the ObligatoryRisk type of risk.
     * @return A float representing the ceiling value (4).
     */
    @Override
    public float getCeiling() {
        return 4;
    }

    /**
     * A String array that represents the obligatory risks covered by the insurance company.
     */
    public String[] obligatoryRisksCovered={
            "Third Party Damage"
    };
}
