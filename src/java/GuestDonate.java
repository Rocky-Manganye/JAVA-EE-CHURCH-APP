/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import rocksta.donation.Donation;
import rocksta.user.User;

/**
 *
 * @author learner.One
 */
public class GuestDonate extends HttpServlet {

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
            throws ServletException, IOException {

        try {

            SystemDao dao = new SystemDao();
            String username_dbase = getServletContext().getInitParameter("username");
            String dbasepsw = getServletContext().getInitParameter("password");
            String dbase = getServletContext().getInitParameter("jdbcConnection");
            dao.open(username_dbase, dbasepsw, dbase);
            
            String account = "GUEST";
            double amount = Double.parseDouble(request.getParameter("amount"));
            String description = request.getParameter("guest_name");
            
            int donate = dao.pay_donation(account, amount, description);
            if (donate > 0) {                
                request.getRequestDispatcher("donate-success.html").forward(request, response);
            }else{
                request.getRequestDispatcher("donate-failed.html").forward(request, response);
            }
        } catch (Exception ex) {
            response.sendRedirect("systemError.jsp");
            System.out.println(ex.getMessage());
        }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
