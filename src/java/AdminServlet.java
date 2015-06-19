/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import rocksta.user.User;

/**
 *
 * @author ROCKY
 */
public class AdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SystemDao dao = new SystemDao();
        String username_dbase = getServletContext().getInitParameter("username");
        String dbasepsw = getServletContext().getInitParameter("password");
        String dbase = getServletContext().getInitParameter("jdbcConnection");

        
        try {
            dao.open(username_dbase, dbasepsw, dbase);
            ArrayList<User> users = dao.gettAllUsers();
            request.setAttribute("users", users);
            request.getRequestDispatcher("admin-home.jsp").forward(request, response);
        } catch (SQLException ex) {
           response.sendRedirect("systemError.jsp");
        } catch (ClassNotFoundException ex) {
            response.sendRedirect("systemError.jsp");
        }

    }

}
