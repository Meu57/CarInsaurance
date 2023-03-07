
package Policy;
import java.io.Serializable;
/**

 This class represents a vehicle, containing information about its plate number,
 model year, manufacturer, estimated value, and car damage.
 */
public class Vehicle implements Serializable {
    /**
     * The license plate number of the vehicle.
     */
    int plateNb;

    /**
     * The model year of the vehicle.
     */
    int modelYear;

    /**
     * The manufacturer of the vehicle.
     */
    String manufacture;

    /**
     * The estimated value of the vehicle.
     */
    int estimateValue;

    /**
     * The amount of damage to the vehicle.
     */
    int carDamage;

    /**
     * Creates a new instance of the Vehicle class with the specified attributes.
     * @param plateNb the vehicle's plate number
     * @param modelYear the vehicle's model year
     * @param manufacture the vehicle's manufacturer
     * @param estimateValue the vehicle's estimated value
     * @param carDamage the vehicle's car damage
     */
    public Vehicle(int plateNb, int modelYear, String manufacture, int estimateValue, int carDamage) {
        this.plateNb = plateNb;
        this.modelYear = modelYear;
        this.manufacture = manufacture;
        this.estimateValue = estimateValue;
        this.carDamage = carDamage;
    }

    /**
     * Returns the plate number of the vehicle.
     * @return the plate number
     */
    public int getPlateNb() {
        return plateNb;
    }

    /**
     * Sets the plate number of the vehicle.
     * @param plateNb the plate number to set
     */
    public void setPlateNb(int plateNb) {
        this.plateNb = plateNb;
    }

    /**
     * Returns the model year of the vehicle.
     * @return the model year
     */
    public int getModelYear() {
        return modelYear;
    }

    /**
     * Sets the model year of the vehicle.
     * @param modelYear the model year to set
     */
    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    /**
     * Returns the manufacturer of the vehicle.
     * @return the manufacturer
     */
    public String getManufacture() {
        return manufacture;
    }

    /**
     * Sets the manufacturer of the vehicle.
     * @param manufacture the manufacturer to set
     */
    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    /**
     * Returns the estimated value of the vehicle.
     * @return the estimated value
     */
    public int getEstimateValue() {
        return estimateValue;
    }

    /**
     * Sets the estimated value of the vehicle.
     * @param estimateValue the estimated value to set
     */
    public void setEstimateValue(int estimateValue) {
        this.estimateValue = estimateValue;
    }

    /**
     * Returns the carDamage the vehicle class.
     * @return the car damage
     */
    public int getCarDamage() {
        return carDamage;
    }

    /**
     * Sets the carDamage variable value of the vehicle class.
     * @param carDamage the car damage to set
     */
    public void setCarDamage(int carDamage) {
        this.carDamage = carDamage;
    }

    /**
     * Returns a string representation of the vehicle object.
     * @return a string representation of the vehicle object
     */
    @Override
    public String toString() {
        return "" +
                "plateNb=" + plateNb +
                "\n modelYear=" + modelYear +
                "\n manufacture='" + manufacture +
                "\n estimateValue=" + estimateValue +
                "\n carDamage=" + carDamage;
    }}
