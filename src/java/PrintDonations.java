/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.OutputStream;
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
public class PrintDonations extends HttpServlet {

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
            response.setContentType("Invoice.pdf");
            //Get the output stream for writing PDF object
            OutputStream out = response.getOutputStream();
            SystemDao dao = new SystemDao();

            String username_dbase = getServletContext().getInitParameter("username");
            String dbasepsw = getServletContext().getInitParameter("password");
            String dbase = getServletContext().getInitParameter("jdbcConnection");
            dao.open(username_dbase, dbasepsw, dbase);
            
            Document document = new Document();
            /* Basic PDF Creation inside servlet */
            
            ArrayList<User> users = dao.gettAllUsers();
            //tithes
            ArrayList<Donation> list = dao.getAllDonations();
            ArrayList<String> projects = dao.getProjects();
            //donaations
            Vector<String> donations = dao.get_donation();
            
            PdfWriter.getInstance(document, out);
            
            document.open();
            document.addAuthor("LightHouse Chapel International");
            document.addCreationDate();
            document.addCreator("lci.com");
            
             document.add(new Paragraph(" "));
            document.add(new Paragraph("============ PROJECTS ==========="));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("NAME"+ "                  " +"NUMBER" + "                  " + "COST"));
            for (int x = 0; x < projects.size(); ++x) {
                String[] data = projects.get(x).split("@");
                document.add(new Paragraph("  " + data[1] + "                  " + data[0] + "                  " + data[4]));
            }
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" Total Projects : " + projects.size()));
            document.add(new Paragraph(" "));
            document.close();
        } catch (Exception ex) {
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
