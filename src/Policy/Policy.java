package Policy;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class Policy implements Serializable {
    static int poilcyNb=0;
    Vehicle vehicle;
    List<String> riskcoveredLIST;
    List<Float> CoverageLIST;
    List<Float> ceilingLIST;
    List<Float> premiumLIST;
    int validityYear;
    LocalDate policyDate;


    public Policy(Vehicle vehicle, List<String> riskcoveredLIST, List<Float> coverageLIST, List<Float> ceilingLIST,List<Float> premiumLIST, int validityYear, LocalDate policyDate) {
        this.vehicle = vehicle;
        this.riskcoveredLIST = riskcoveredLIST;
        CoverageLIST = coverageLIST;
        this.ceilingLIST = ceilingLIST;
        this.validityYear = validityYear;
        this.policyDate = policyDate;
        this.premiumLIST= premiumLIST;
        poilcyNb+=1 ;
    }

    public static int getPoilcyNb() {
        return poilcyNb;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public List<String> getRiskcoveredLIST() {
        return riskcoveredLIST;
    }

    public List<Float> getCoverageLIST() {
        return CoverageLIST;
    }

    public List<Float> getCeilingLIST() {
        return ceilingLIST;
    }

    public int getValidityYear() {
        return validityYear;
    }

    public List<Float> getPremiumLIST() {
        return premiumLIST;
    }

    public LocalDate getPolicyDate() {
        return policyDate;
    }

    @Override
    public String toString() {
        return "Policy NB: " + poilcyNb +
                "\n" + vehicle +
                "\n ValidityYear=" + validityYear;
    }
}
