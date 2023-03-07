package Plan;

/**
 * AssistanceRisk class represents a specific type of Risk for an insurance company that provides assistance to its clients.
 * This class extends the Risk class and provides specific values for the premium, coverage, and ceiling attributes.
 */
public class AssistanceRisk extends Risk{

    /**
     * Returns the premium value for the AssistanceRisk type of risk.
     * @return A float representing the premium value (5%).
     */
    @Override
    public float getPremium() {
        return 0.05f;
    }

    /**
     * Returns the coverage value for the AssistanceRisk type of risk.
     * @return A float representing the coverage value (80%).
     */
    @Override
    public float getCoverage() {
        return 0.8f;
    }

    /**
     * Returns the ceiling value for the AssistanceRisk type of risk.
     * @return A float representing the ceiling value (8).
     */
    @Override
    public float getCeiling() {
        return 8;
    }

    /**
     * A String array that represents the assistance risks covered by the insurance company.
     */
    public String[] AssistanceRisksCovered={
            "Fire",
            "Robbery",
            "Transport",
            "Car Replacement"
    };
}
