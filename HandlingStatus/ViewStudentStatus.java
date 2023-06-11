/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package HandlingStatus;

import admin.register.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */

public class ViewStudentStatus extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title> ViewFinancialAid</title>");
        out.println("</head>");
        out.println("<body>");
        
        List<StudentApplication> list = new ArrayList<StudentApplication>();

        out.print("<table class='financial-aid-table'");
        out.print("<tr><th>Email</th><th>Financial Aid</th><th>Date</th><th>Time</th><th>View</th><th>Application Status</th><th>Update</th></tr>");
        for (StudentApplication e : list) {
            out.print("<tr>");
            out.print("<td>" + e.getStu_email()+ "</td>");
            out.print("<td>" + e.getFinancial_name()+ "</td>");
            out.print("<td>" + e.getSubmissionDate()+ "</td>");
            out.print("<td>" + e.getSubmissionTime()+ "</td>");
            out.print("<td><a href='viewStudentApplication.jsp?applicationId=" + e.getApplicationId() + "'>View</a></td>");
            out.print("<td><select name='application_status'>");
            out.print("<option value='pending'" + e.getApplication_status()+ ">Pending</option>");
            out.print("<option value='accept'" + e.getApplication_status()+ ">Accepted</option>");
            out.print("<option value='decline '" + e.getApplication_status()+ ">Declined</option>");
            out.print("</select></td>");
            out.print("<td><a href='ViewStudentServlet?applicationId=" + e.getApplicationId() + "'><button type='submit' class='btn btn-primary form' id='submitBtn' value='Update'>Update</button></a></td>");
            out.print("</tr>");
        }
        out.print("</table>");

        out.println("</body>");
        out.println("</html>");

        out.close();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewStudentStatus.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ViewStudentStatus.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewStudentStatus.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ViewStudentStatus.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
