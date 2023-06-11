/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HandlingStatus;

import admin.register.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class StudentApplicationDao {
    
    
    public static List<StudentApplication> getAllStudentApplication() throws ClassNotFoundException{
        List<StudentApplication> list = new ArrayList<StudentApplication>();
        
        try{
            Connection con = DBConnection.getConnection();

        String appQuery = "SELECT stu_email, financial_name, submission_datetime, application_status FROM applications";
        PreparedStatement myPS = con.prepareStatement(appQuery);
        ResultSet rs = myPS.executeQuery();
        
        while (rs.next()) {
            StudentApplication e = new StudentApplication();

            e.setStu_email(rs.getString("stu_email"));
            e.setFinancial_name(rs.getString("financial_name"));
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            String submissionDate = dateFormat.format(rs.getTimestamp("submission_datetime"));
            String submissionTime = timeFormat.format(rs.getTimestamp("submission_datetime"));
            e.setSubmissionDate(submissionDate);
            e.setSubmissionTime(submissionTime);
            e.setApplication_status(rs.getString("application_status"));
            
            list.add(e);
        }
        con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
        }
    
    public static int update(StudentApplication e) {
        int status = 0;
        try {
            Connection con = DBConnection.getConnection();
            String sUpdateQuery = "UPDATE applications SET application_status=? WHERE applicationId=?";

            PreparedStatement myPS = con.prepareStatement(sUpdateQuery);

            myPS.setString(6, e.getApplication_status());
            status = myPS.executeUpdate();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }
}
