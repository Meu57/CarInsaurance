
package Plan;
/**

 This class represents an All Risk plan, which is a type of insurance plan that covers a wide range of risks.
 It extends the abstract class Risk and implements its abstract methods.
 */
public class AllRisk extends Risk {
    /**
     * Returns the premium rate for the All Risk plan.
     *
     * @return the premium rate as a float value
     */
    @Override
    public float getPremium() {
        return 0.075f;
    }
    /**
     * Returns the coverage rate for the All Risk plan.
     *
     * @return the coverage rate as a float value
     */
    @Override
    public float getCoverage() {
        return 1f;
    }

    /**
     * Returns the maximum coverage ceiling for the All Risk plan.
     *
     * @return the maximum coverage ceiling as a float value
     */
    @Override
    public float getCeiling() {
        return 10;
    }

    /**
     * An array of all risks covered by the All Risk plan.
     */
    public String[] allRisksCovered={
            "Fire",
            "Robbery",
            "Third Party Damage",
            "Vehicle Damage",
            "Driver Damage",
            "Transport",
            "Car Replacement"
    };
}
