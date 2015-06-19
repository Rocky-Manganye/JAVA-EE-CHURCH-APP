import co.sender.net.codejava.swing.mail.SwingEmailSender;
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
import javax.servlet.http.HttpSession;
import rocksta.donation.Donation;
import rocksta.user.User;

/**
 *
 * @author learner.One
 */
public class SendMailServlet extends HttpServlet {

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
            response.setContentType("text/html;charset=UTF-8");
            String todo = request.getParameter("email");
            if(todo.equals("send")){
                SwingEmailSender sender = new SwingEmailSender();
                sender.setAlwaysOnTop(true);
                sender.setVisible(true);
            }
            SystemDao dao = new SystemDao();
            String username_dbase = getServletContext().getInitParameter("username");
            String dbasepsw = getServletContext().getInitParameter("password");
            String dbase = getServletContext().getInitParameter("jdbcConnection");
            dao.open(username_dbase, dbasepsw, dbase);
            
            
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            request.setAttribute("user", user);
            ArrayList<Donation> list = dao.getAllDonations();
            request.setAttribute("donations", list);
            ArrayList<String> projects = dao.getProjects();
            request.setAttribute("projects", projects);
            Vector<String> donations = dao.get_donation();
            request.setAttribute("dons", donations);
            
            request.getRequestDispatcher("management-home.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SendMailServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SendMailServlet.class.getName()).log(Level.SEVERE, null, ex);
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
