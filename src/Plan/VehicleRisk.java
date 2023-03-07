package Plan;

/**
 * VehicleRisk is a subclass of Risk that represents a type of risk for an insurance company
 * that covers damage to a customer's vehicle. This class provides specific implementations
 * for the getPremium(), getCoverage(), and getCeiling() methods, as well as an attribute
 * for the specific risks covered by this type of insurance.
 */
public class VehicleRisk extends Risk{

    /**
     * Returns the premium value for this type of insurance.
     * @return A float representing the premium value.
     */
    @Override
    public float getPremium() {
        return 0.05f;
    }

    /**
     * Returns the coverage value for this type of insurance.
     * @return A float representing the coverage value.
     */
    @Override
    public float getCoverage() {
        return 0.9f;
    }

    /**
     * Returns the ceiling value for this type of insurance.
     * @return A float representing the ceiling value.
     */
    @Override
    public float getCeiling() {
        return 6;
    }

    /**
     * An array of Strings representing the specific risks covered by this type of insurance.
     */
    public String[] vehicleRisksCovered={
            "Vehicle Damage"
    };
}
