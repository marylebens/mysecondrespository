/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package basicjdbc;

import java.sql.*;

/**
 *
 * @author mlebens
 */
public class BasicJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try { //Use a try/catch block to catch any database exceptions
            //Step 1 - Create a connection to the database
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/northwind", "root", "admin");

            //Step 2 - Create a new SQL statement using the connection
            Statement stmt = con.createStatement();

            //Step 3 - Execute the SQL statement to retrieve a result set of records from the database.
            ResultSet rs = stmt.executeQuery("select * from categories");  //This SQL query will retrieve all of the records in the categories table

            //Step 4 - Use a while loop to iterate through the resultset of records
            while (rs.next()) {
                //print out the data in each of the columns in the current record
                //The first column contains an integer, so we are calling the getInt method.
                //The remaining three columns are text values, so we are calling the getString method.
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  "
                        + rs.getString(3) + "  " + rs.getString(4));
            }//end while look

            //Insert a record in the database
            
            //Ste 5 - Close the connection to the database
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        } //end try catch

    }

}
