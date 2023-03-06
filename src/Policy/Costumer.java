package Policy;

import java.io.Serializable;
import java.sql.*;
public class Costumer implements Serializable {
        private String firstName;
        private String lastName;
        private String city;
        private String phoneNumber;
        private Policy policy;

        public Costumer(String firstName, String lastName, String city, String phoneNumber, Policy policy) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.city = city;
            this.phoneNumber = phoneNumber;
            this.policy = policy;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getCity() {
            return city;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public Policy getPolicy() {
            return policy;
        }




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