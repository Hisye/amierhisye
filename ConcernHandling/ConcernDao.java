/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConcernHandling;

import financialAid.FinancialAid;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class ConcernDao {
    
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

    public static int save(Concern e) {
        int status = 0;
        try {
            Connection con = ConcernDao.getConnection();
            String sInsertQry = "INSERT INTO concern(email, concern) VALUES(?,?)";

            PreparedStatement myPS = con.prepareStatement(sInsertQry);

            myPS.setString(1, e.getEmail());
            myPS.setString(1, e.getConcern());
            

            status = myPS.executeUpdate();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static int update(Concern e) {
        int status = 0;
        try {
            Connection con = ConcernDao.getConnection();
            String sUpdateQuery = "UPDATE concern SET concern=? WHERE concern_id=?";

            PreparedStatement myPS = con.prepareStatement(sUpdateQuery);

            myPS.setString(1, e.getConcern());
            myPS.setString(2, e.getEmail());
            

            status = myPS.executeUpdate();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static int delete(int concern_id) {
        int status = 0;
        try {
            Connection con = ConcernDao.getConnection();
            String sInsertQry = "DELETE FROM concern WHERE concern_id=?";

            PreparedStatement myPS = con.prepareStatement(sInsertQry);

            myPS.setInt(1, concern_id);

            status = myPS.executeUpdate();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static Concern getConcernById(int concern_id) {
        Concern e = null;

        try {
            Connection con = ConcernDao.getConnection();
            String sSelectQry = "SELECT * FROM concern WHERE concern_id=?";
            PreparedStatement myPS = con.prepareStatement(sSelectQry);
            myPS.setInt(1, concern_id);
            ResultSet rs = myPS.executeQuery();
            if (rs.next()) {
                e = new Concern();
                e.setEmail(rs.getString(1));//tukar sini jugok maybe akan ada masalah
                e.setConcern(rs.getString(2));
                
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return e;
    }

    public static List<Concern> getAllConcern() {
        List<Concern> list = new ArrayList<Concern>();

        try {
            Connection con = ConcernDao.getConnection();
            String sInsertQry = "SELECT * FROM concern";
            PreparedStatement myPS = con.prepareStatement(sInsertQry);
            ResultSet rs = myPS.executeQuery();
            while (rs.next()) {
                Concern e = new Concern();

                e.setId(rs.getInt(1));
                e.setEmail(rs.getString(2));
                e.setConcern(rs.getString(3));
                

                list.add(e);
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return list;

    }
}


