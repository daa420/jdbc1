import java.sql.*;
import java.util.*;

public class InsertDetails {
    public static void main(String[] args) {
        String usn, name, dept;
        Scanner obj = new Scanner(System.in);
        
        System.out.println("Enter Student Name:");
        name = obj.nextLine();
        
        System.out.println("Enter Student USN:");
        usn = obj.nextLine();
        
        System.out.println("Enter Student Dept:");
        dept = obj.nextLine();

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student", "root", "root");

            // Prepare the SQL statement
            String q1 = "INSERT INTO student (usn, name, dept) VALUES (?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(q1);
            pstmt.setString(1, usn);
            pstmt.setString(2, name);
            pstmt.setString(3, dept);

            // Execute the statement
            int x = pstmt.executeUpdate();
            if (x > 0) {
                System.out.println("Successfully Inserted");
            } else {
                System.out.println("Insert Failed");
            }

            // Close the connection
            pstmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
