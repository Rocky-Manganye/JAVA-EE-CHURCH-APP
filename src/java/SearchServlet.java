/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import rocksta.donation.Donation;
import rocksta.user.User;

/**
 *
 * @author learner.One
 */
public class SearchServlet extends HttpServlet {

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

        String account = request.getParameter("acc");

        SearchDao dao = new SearchDao();
        SystemDao dao1 = new SystemDao();
        String username_dbase = getServletContext().getInitParameter("username");
        String dbasepsw = getServletContext().getInitParameter("password");
        String dbase = getServletContext().getInitParameter("jdbcConnection");

        try {
            dao.open(username_dbase,dbasepsw,dbase);
            dao1.open(username_dbase,dbasepsw,dbase);
              User user= dao.search(account.trim());
             
            HttpSession hs = request.getSession();
            hs.setAttribute("userResults", user);
            if (user != null) {
                ArrayList<Donation> list = dao1.getAllDonations(user.getAccountNumber());
                request.setAttribute("donations", list);
                ArrayList<String> projects = dao1.getProjects();
                request.setAttribute("projects", projects);
                Vector<String> donations = dao1.get_donation();
                request.setAttribute("dons", donations);
                
                String username = request.getParameter("uname");
                String password = request.getParameter("psw");
                hs.setAttribute("username", username);
                hs.setAttribute("password", password);
            }
            request.getRequestDispatcher("search-user.jsp").forward(request, response);
        } catch (Exception e) {
          response.sendRedirect("systemError.jsp");
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
