
package Policy;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;
/**

 A class that represents a policy.
 */
public class Policy implements Serializable {
    /**
     * The policy number for the policy.
     */
    static int poilcyNb = 0;

    /**
     * The vehicle associated with the policy.
     */
    Vehicle vehicle;

    /**
     * The list of risks covered by the policy.
     */
    List<String> riskcoveredLIST;

    /**
     * The list of coverage amounts for the policy.
     */
    List<Float> CoverageLIST;

    /**
     * The list of ceiling amounts for the policy.
     */
    List<Float> ceilingLIST;

    /**
     * The list of premium amounts for the policy.
     */
    List<Float> premiumLIST;

    /**
     * The number of years that the policy is valid for.
     */
    int validityYear;

    /**
     * The date that the policy was created.
     */
    LocalDate policyDate;


    /**
     * Constructs a Policy object with the given parameters.
     *
     * @param vehicle         the vehicle associated with the policy
     * @param riskcoveredLIST the list of risks covered by the policy
     * @param coverageLIST    the list of coverage values for each risk
     * @param ceilingLIST     the list of ceiling values for each risk
     * @param premiumLIST     the list of premium amounts for each risk
     * @param validityYear    the number of years for which the policy is valid
     * @param policyDate      the date on which the policy was created
     */
    public Policy(Vehicle vehicle, List<String> riskcoveredLIST, List<Float> coverageLIST, List<Float> ceilingLIST, List<Float> premiumLIST, int validityYear, LocalDate policyDate) {
        this.vehicle = vehicle;
        this.riskcoveredLIST = riskcoveredLIST;
        CoverageLIST = coverageLIST;
        this.ceilingLIST = ceilingLIST;
        this.validityYear = validityYear;
        this.policyDate = policyDate;
        this.premiumLIST = premiumLIST;
        poilcyNb += 1;
    }

    /**
     * Returns the number of policies that have been created.
     *
     * @return the number of policies that have been created
     */
    public static int getPoilcyNb() {
        return poilcyNb;
    }

    /**
     * Returns the vehicle associated with the policy.
     *
     * @return the vehicle associated with the policy
     */
    public Vehicle getVehicle() {
        return vehicle;
    }

    /**
     * Returns the list of risks covered by the policy.
     *
     * @return the list of risks covered by the policy
     */
    public List<String> getRiskcoveredLIST() {
        return riskcoveredLIST;
    }

    /**
     * Returns the list of coverage values for each risk.
     *
     * @return the list of coverage values for each risk
     */
    public List<Float> getCoverageLIST() {
        return CoverageLIST;
    }

    /**
     * Returns the list of ceiling values for each risk.
     *
     * @return the list of ceiling values for each risk
     */
    public List<Float> getCeilingLIST() {
        return ceilingLIST;
    }

    /**
     * Returns the number of years for which the policy is valid.
     *
     * @return the number of years for which the policy is valid
     */
    public int getValidityYear() {
        return validityYear;
    }

    /**
     * Returns the list of premium amounts for each risk.
     *
     * @return the list of premium amounts for each risk
     */
    public List<Float> getPremiumLIST() {
        return premiumLIST;
    }

    /**
     * Returns the date on which the policy was created.
     *
     * @return the date on which the policy was created
     */
    public LocalDate getPolicyDate() {
        return policyDate;
    }

    /**
     * Returns a string representation of the policy.
     *
     * @return a string representation of the policy
     */
    @Override
    public String toString() {
        return "Policy NB: " + poilcyNb +
                "\n" + vehicle +
                "\n ValidityYear=" + validityYear;
    }
}