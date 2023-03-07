package Plan;

/**
 * Risk class is an abstract class that represents a generic type of risk for an insurance company.
 * This class provides attributes for premium, coverage, and ceiling, as well as an abstract method
 * for each of these attributes.
 */
public abstract class Risk {
    private int premium;
    float coverage;
    float ceiling;

    /**
     * Checks if a given list of claimed risks is covered by the insurance company.
     * @param risksCovered An array of Strings representing the risks covered by the insurance company.
     * @param claimed An array of Strings representing the risks claimed by the customer.
     * @return A boolean indicating whether all of the claimed risks are covered by the insurance company.
     */
    public boolean isCovered(String[] risksCovered, String[] claimed){
        int i=0;
        int j=0;
        for(i=0;i<claimed.length;i++){
            for(j=0;j<risksCovered.length;j++){

                if(claimed[i] == risksCovered[j]){
                    break;
                }
                if(j== risksCovered.length){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * An abstract method that returns the premium value for a specific type of risk.
     * @return A float representing the premium value.
     */
    public abstract float getPremium();

    /**
     * An abstract method that returns the coverage value for a specific type of risk.
     * @return A float representing the coverage value.
     */
    public abstract float getCoverage();

    /**
     * An abstract method that returns the ceiling value for a specific type of risk.
     * @return A float representing the ceiling value.
     */
    public abstract float getCeiling();

}
