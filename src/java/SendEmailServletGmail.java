/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
public class SendEmailServletGmail extends HttpServlet {

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

            HttpSession session = request.getSession();

            User user = (User) session.getAttribute("user");

            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");

            Session msession = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication("kandym23@gmail.com", "lufunomaboho");
                      }
                    });

            //compose message
            MimeMessage message = new MimeMessage(msession);
            message.setFrom(new InternetAddress("kandym23@gmail.com"));
            
           ArrayList<User> users = dao.gettAllMembers();
           /*for (User user1 : users) {
               System.out.print(user.getEmail());
                     message.addRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
                       
            }*/

           InternetAddress [] emails =  {/*new InternetAddress("Pntombela9@gmail.com"),*/
                                         new InternetAddress("Sphamandlakube@gmail.com"),
                                            new InternetAddress("Mpofu.mp17@gmail.com"),
                                            new InternetAddress("nrmanganye04@gmail.com")};
           
           message.addRecipients(Message.RecipientType.TO, emails);
           //message.addRecipient(Message.RecipientType.TO,);
           
            message.setSubject("Projects");
            message.setText("Dear Member \n\n\n"
                    + "Please know that a new project has been added please be kind to donate.\n\n\n "
                    + "Regards \n\n\n" + "Management");

            //send message
            Transport t = msession.getTransport();
            t.send(message);
t.close();
            request.getRequestDispatcher("management-home.jsp").forward(request, response);
        } catch (SQLException ex) {
            response.sendRedirect("emailError.jsp");
            System.out.println(ex.getMessage());
        } catch (MessagingException ex) {
            response.sendRedirect("sessionTimeOut.jsp");
        } catch (ClassNotFoundException ex) {
             response.sendRedirect("emailError.jsp");
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
