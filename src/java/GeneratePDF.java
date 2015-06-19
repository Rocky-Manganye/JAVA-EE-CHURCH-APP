/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
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
 * @author ROCKSTA
 */
public class GeneratePDF extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
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
            document.addTitle("USER INFORMATION SUMMARY");
            document.add(new Paragraph("LightHouse Chapel International"));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("INFORMATION SUMMARY"));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("=========== TITHES ==============="));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Amount " + "                  " + "Date "));
            document.add(new Paragraph(""));
            document.add(new Paragraph(""));
            
            double total = 0.00;
            for (int x = 0; x < list.size(); ++x) {
                total += list.get(x).getAmount();
                document.add(new Paragraph(x + " " + list.get(x).getAmount() + "   " + list.get(x).getDate()));
            }
            
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("============ USERS ==========="));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("   NAME     " + "   SURNAME   " + "  ACCOUNT NUMBER  "));
            for (User user : users) {
                document.add(new Paragraph("  " + user.getName() + "  " + "  " + user.getSurname() + "  " + "  " + user.getAccountNumber()));
            }
            
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("============ PROJECTS ==========="));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("   NAME     " + "   NUMBER   " + "  COST  "));
            for (int x = 0; x < projects.size(); ++x) {
                String[] data = projects.get(x).split("@");
                document.add(new Paragraph("  " + data[1] + "  " + "  " + data[0] + "  " + "  " + data[4]));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GeneratePDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GeneratePDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(GeneratePDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            String select = request.getParameter("select");

            SystemDao dao = new SystemDao();

            String username_dbase = getServletContext().getInitParameter("username");
            String dbasepsw = getServletContext().getInitParameter("password");
            String dbase = getServletContext().getInitParameter("jdbcConnection");

            if (select.equalsIgnoreCase("Print Report")) {
                String user_id = request.getParameter("account");
                response.setContentType("Invoice.pdf");
                //Get the output stream for writing PDF object
                OutputStream out = response.getOutputStream();

                dao.open(username_dbase, dbasepsw, dbase);

                Vector<String> data1 = dao.get_donation();
                int numbItem = 0;
                Vector<String> userdons = new Vector<String>();
                if (!data1.isEmpty()) {
                    for (int x = 0; x < data1.size(); ++x) {
                        String elements[] = data1.get(x).split("@");
                        if (elements[1].equalsIgnoreCase(user_id)) {
                            numbItem++;

                        }
                    }
                }
                String us_name = request.getParameter("uname");
                String ps_word = request.getParameter("psw");
                User user = dao.login(us_name, ps_word);
                Document document = new Document();
                /* Basic PDF Creation inside servlet */

                PdfWriter.getInstance(document, out);

                document.open();
                document.addAuthor("\t\t\t\t\t\t\t\t\tLightHouse Chapel International");
                document.addCreationDate();
                document.addCreator("lci.com");
                document.addTitle("\t\t\t\t\t\t\t\t\tDonation Receipt");
                document.add(new Paragraph("\t\t\t\t\t\t\t\t\tLightHouse Chapel International"));
                document.add(new Paragraph(""));
                document.add(new Paragraph(""));
                document.add(new Paragraph(""));
                document.add(new Paragraph(""));
                document.add(new Paragraph("\t\t\t\t\t\t\t\t\tDonation slip"));
                document.add(new Paragraph(" "));
                document.add(new Paragraph(" "));
                document.add(new Paragraph(" "));
                document.add(new Paragraph(" "));

                document.add(new Paragraph("\t\t\t\t\t\t\t\t\t=========== CLIENT INFORMATION ==============="));

                document.add(new Paragraph("\t\t\t\t\t\t\t\t\tName : \t\t\t\t\t\t\t\t\t" + user.getName()));
                document.add(new Paragraph("\t\t\t\t\t\t\t\t\tSurname : \t\t\t\t\t\t\t\t\t" + user.getSurname()));
                document.add(new Paragraph("\t\t\t\t\t\t\t\t\tAcount Number : : \t\t\t\t\t\t\t\t\t" + user.getAccountNumber()));
                document.add(new Paragraph("\t\t\t\t\t\t\t\t\tEmail Address : \t\t\t\t\t\t\t\t\t" + user.getEmail()));

                document.add(new Paragraph("\t\t\t\t\t\t\t\t\t=================================="));
                document.add(new Paragraph("\t\t\t\t\t\t\t\t\tNumber of Donationst: " + numbItem));
                document.add(new Paragraph("\t\t\t\t\t\t\t\t\t=================================="));

                double totalAmount = 0.00;
                if (!data1.isEmpty()) {
                    for (int x = 0; x < data1.size(); ++x) {
                        String elements[] = data1.get(x).split("@");
                        if (elements[1].equalsIgnoreCase(user_id)) {
                            numbItem++;
                            totalAmount += Double.parseDouble(elements[2]);
                            document.add(new Paragraph("\t\t\t\t\t\t\t\t\t" + elements[0] + "\t R" + elements[2]));

                        }
                    }
                }

                document.add(new Paragraph("\t\t\t\t\t\t\t\t\t=================================="));

                Random rand = new Random();
                document.add(new Paragraph("\t\t\t\t\t\t\t\t\tRecord Number: " + "#" + rand.nextInt(150)));
                document.add(new Paragraph("\t\t\t\t\t\t\t\t\tSub-total Amount: R" + totalAmount));

                document.add(new Paragraph(" "));
                document.add(new Paragraph(" "));
                document.add(new Paragraph("\t\t\t\t\t\t\t\t\tThank you for donating!!"));
                document.close();
            } else if (select.equalsIgnoreCase("Print Information")) {
                
                
            }

        } catch (DocumentException ex) {
            Logger.getLogger(GeneratePDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GeneratePDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GeneratePDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
