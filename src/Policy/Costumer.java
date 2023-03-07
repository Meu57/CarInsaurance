
package Policy;
import java.io.Serializable;
import java.sql.*;
/**

 The Costumer class represents a customer of an insurance company.
 It contains the customer's first name, last name, city, phone number and policy information.
 It also provides a method to add the customer to a MySQL database and a toString method to convert the object to a string.
 */
public class Costumer implements Serializable {
    /**
     * The first name of the policy holder.
     */
    private String firstName;

    /**
     * The last name of the policy holder.
     */
    private String lastName;

    /**
     * The city where the policy holder resides.
     */
    private String city;

    /**
     * The phone number of the policy holder.
     */
    private String phoneNumber;

    /**
     * The policy associated with the policy holder.
     */
    private Policy policy;

    /**
     * Constructs a Costumer object with the specified first name, last name, city, phone number and policy.
     * @param firstName The first name of the customer.
     * @param lastName The last name of the customer.
     * @param city The city where the customer lives.
     * @param phoneNumber The phone number of the customer.
     * @param policy The policy of the customer.
     */
    public Costumer(String firstName, String lastName, String city, String phoneNumber, Policy policy) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.policy = policy;
    }

    /**
     * Returns the first name of the customer.
     * @return The first name of the customer.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the last name of the customer.
     * @return The last name of the customer.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns the city where the customer lives.
     * @return The city where the customer lives.
     */
    public String getCity() {
        return city;
    }

    /**
     * Returns the phone number of the customer.
     * @return The phone number of the customer.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Returns the policy of the customer.
     * @return The policy of the customer.
     */
    public Policy getPolicy() {
        return policy;
    }

    /**
     * Adds the customer to a MySQL database.
     */
    public void addToDB() {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/insurance_db", "root", "password");
            stmt = conn.createStatement();
            String sql = "INSERT INTO customers (first_name, last_name, city, phone_number) VALUES ('" + firstName + "', '" + lastName + "', '" + city + "', '" + phoneNumber + "')";
            stmt.executeUpdate(sql);
            System.out.println("Customer added to the database.");
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    /**
     * Returns a string representation of the Costumer object.
     * @return A string representation of the Costumer object.
     */
    @Override
    public String toString() {
        return "Costumer{" +
                "First Name='" + firstName + '\'' +
                ", Last Name='" + lastName + '\'' +
                ", City='" + city + '\'' +
                ", Phone No.'" + phoneNumber + '\'' +
                ", Policy=" + policy +
                '}';
    }
}
