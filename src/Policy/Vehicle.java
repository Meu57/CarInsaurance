package Policy;

import java.io.Serializable;

public class Vehicle implements Serializable {
    int plateNb;
    int modelYear;
    String manufacture;
    int estimateValue;
    int carDamage;

    public Vehicle(int plateNb, int modelYear, String manufacture, int estimateValue, int carDamage) {
        this.plateNb = plateNb;
        this.modelYear = modelYear;
        this.manufacture = manufacture;
        this.estimateValue = estimateValue;
        this.carDamage = carDamage;
    }

    public int getPlateNb() {
        return plateNb;
    }

    public void setPlateNb(int plateNb) {
        this.plateNb = plateNb;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public int getEstimateValue() {
        return estimateValue;
    }

    public void setEstimateValue(int estimateValue) {
        this.estimateValue = estimateValue;
    }

    public int getCarDamage() {
        return carDamage;
    }

    public void setCarDamage(int carDamage) {
        this.carDamage = carDamage;
    }

    @Override
    public String toString() {
        return "" +
                "plateNb=" + plateNb +
                "\n modelYear=" + modelYear +
                "\n manufacture='" + manufacture +
                "\n estimateValue=" + estimateValue +
                "\n carDamage=" + carDamage;
    }
}
