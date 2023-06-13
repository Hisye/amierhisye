/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HandlingStatus;

import admin.register.DBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author User
 */
public class StudentApplicationDao {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String myURL = "jdbc:mysql://localhost/assignmenttest";
            con = DriverManager.getConnection(myURL, "root", "admin");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    public static List<StudentApplication> getAllStudentApplication() throws ClassNotFoundException {
        List<StudentApplication> list = new ArrayList<StudentApplication>();

        try {
            Connection con = StudentApplicationDao.getConnection();
            String appQuery = "SELECT * FROM applications";
            PreparedStatement myPS = con.prepareStatement(appQuery);
            ResultSet rs = myPS.executeQuery();

            while (rs.next()) {
                StudentApplication e = new StudentApplication();

                e.setApplicationId(rs.getInt(1));
                e.setPayslip(rs.getString(2));
                e.setCgpa(rs.getString(3));
                e.setPath(rs.getString(4));
                e.setSubmissionDate(rs.getDate(5)); // Assuming column 5 is the submission_datetime column
                e.setSubmissionTime(rs.getTime(5)); // Assuming column 5 is the submission_datetime column
                e.setApplication_status(rs.getString(6));
                e.setStu_email(rs.getString(7));
                e.setFinancial_name(rs.getString(8));

                list.add(e);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static int update(StudentApplication e) {
        int status = 0;
        try {
            Connection con = StudentApplicationDao.getConnection();
            String sUpdateQuery = "UPDATE applications SET application_status=? WHERE applicationId=?";

            PreparedStatement myPS = con.prepareStatement(sUpdateQuery);

            myPS.setString(1, e.getApplication_status()); // Set the value for the first parameter
            myPS.setInt(2, e.getApplicationId()); // Set the value for the second parameter

            status = myPS.executeUpdate();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static int updateStatus(StudentApplication e) {
        int status = 0;
        try {
            Connection con = StudentApplicationDao.getConnection();
            String sUpdateQuery = "UPDATE applications SET application_status=? WHERE applicationId=?";

            PreparedStatement myPS = con.prepareStatement(sUpdateQuery);
            myPS.setString(1, e.getApplication_status()); // Set the value for the first parameter
            myPS.setInt(2, e.getApplicationId()); // Set the value for the second parameter

            status = myPS.executeUpdate();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }

}
