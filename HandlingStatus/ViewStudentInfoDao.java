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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class ViewStudentInfoDao {

    public static ViewStudentInfo getStudentInfoByEmail(String email) {
        ViewStudentInfo e = null;

        try {
            Connection con = DBConnection.getConnection();
            String sSelectQry = "SELECT * FROM student WHERE email=?";//sini kena tukar
            //String fSelectQry = "SELECT * FROM financial WHERE id=?";//cuba cek jugak sini betul dak
            PreparedStatement studentPS = con.prepareStatement(sSelectQry);
            //PreparedStatement financialPS = con.prepareStatement(fSelectQry);
            studentPS.setString(1, email);
            ResultSet rs = studentPS.executeQuery();
            if (rs.next()) {
                e = new ViewStudentInfo();
                //tukar sini jugok maybe akan ada masalah
                e.setName(rs.getString(1));
                e.setEmail(rs.getString(2));
                e.setPassword(rs.getString(3));
                e.setPhoneNumber(rs.getString(4));
                e.setMatric(rs.getString(5)); // Corrected column index
                e.setIncome(rs.getDouble(6));
                e.setBank(rs.getString(7)); // Corrected column index
                e.setAcc(rs.getString(8));
                e.setRace(rs.getString(9));
                e.setReligion(rs.getString(10));
                e.setStatus(rs.getString(11));
                e.setIc(rs.getString(12));
                e.setCourse(rs.getString(13));
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return e;
    }

    public static List<ViewStudentInfo> getAllStudentInfo() throws ClassNotFoundException, SQLException {
        List<ViewStudentInfo> list = new ArrayList<ViewStudentInfo>();

        try {
            Connection con = DBConnection.getConnection();
            String sInsertQry = "SELECT * FROM student";
            PreparedStatement myPS = con.prepareStatement(sInsertQry);
            ResultSet rs = myPS.executeQuery();
            while (rs.next()) {
                ViewStudentInfo e = new ViewStudentInfo();

                e.setName(rs.getString(1));
                e.setEmail(rs.getString(2));
                e.setPassword(rs.getString(3));
                e.setPhoneNumber(rs.getString(4));
                e.setMatric(rs.getString(5)); // Corrected column index
                e.setIncome(rs.getDouble(6));
                e.setBank(rs.getString(7)); // Corrected column index
                e.setAcc(rs.getString(8));
                e.setRace(rs.getString(9));
                e.setReligion(rs.getString(10));
                e.setStatus(rs.getString(11));
                e.setIc(rs.getString(12));
                e.setCourse(rs.getString(13));
                
                list.add(e);
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
    public static int delete(String name) {
        int status = 0;
        try {
            Connection con = DBConnection.getConnection();
            String sInsertQry = "DELETE FROM student WHERE name=?";

            PreparedStatement myPS = con.prepareStatement(sInsertQry);

            myPS.setString(1, name);

            status = myPS.executeUpdate();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }
}
