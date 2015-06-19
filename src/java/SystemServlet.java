import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import rocksta.donation.Donation;
import rocksta.user.User;

public class SystemServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String selection = request.getParameter("selection");
        try {
            SystemDao dao = new SystemDao();
            String username_dbase = getServletContext().getInitParameter("username");
            String dbasepsw = getServletContext().getInitParameter("password");
            String dbase = getServletContext().getInitParameter("jdbcConnection");
            dao.open(username_dbase, dbasepsw, dbase);
            RequestDispatcher dispatcher = null;

            if (selection.equalsIgnoreCase("Register")) {
                String name = request.getParameter("user_name").trim();
                String surname = request.getParameter("usersurname").trim();

                String id = request.getParameter("userid").trim();
                String[] id_brk = id.split("");

                String gender = "male";
                if (Integer.parseInt(id_brk[6]) < 5) {
                    gender = "female";
                }

                String email = request.getParameter("useremail").trim();
                String username = request.getParameter("username").trim();
                String password = request.getParameter("password").trim();
                int rand = new Random().nextInt(1754569);
                String th_num = "THN" + rand;

                if (id.length() == 13) {
                    boolean validID = true;
                    String pattern = "^[a-zA-Z0-9]*$";

                    if (!id.matches("^\\d+$")) {
                        dispatcher = request.getRequestDispatcher("invalidID-management.jsp");
                        dispatcher.forward(request, response);
                    }

                    if (username.length() > 5 && password.length() > 8) {
                        ArrayList<User> users = dao.gettAllUsers();
                        boolean exist = false;
                        for (int x = 0; x < users.size(); x++) {
                            if (users.get(x).getEmail().equals(email) || users.get(x).getId().equals(id) || users.get(x).getPassword().equals(password) || users.get(x).getUsername().equals(username)) {
                                exist = true;
                                break;
                            }
                        }
                        if (exist == true) {
                            dispatcher = request.getRequestDispatcher("details-taken.jsp");
                            dispatcher.forward(request, response);
                        } else {
                            int reg = dao.register(new User(name, surname, id, th_num, gender, username, password, email, "member"));
                            if (reg > 0) {
                                request.setAttribute("user", new User(name, surname, id, th_num, gender, username, password, email, "member"));
                                dispatcher = request.getRequestDispatcher("reg-sucess.jsp");
                                dispatcher.forward(request, response);
                            } else {
                                dispatcher = request.getRequestDispatcher("registration-error.jsp");
                                dispatcher.forward(request, response);
                            }
                        }

                    } else {
                        dispatcher = request.getRequestDispatcher("registration-error.jsp");
                        dispatcher.forward(request, response);
                    }
                } else {
                    dispatcher = request.getRequestDispatcher("registration-error.jsp");
                    dispatcher.forward(request, response);
                }

            } else if (selection.equalsIgnoreCase("Login")) {
                String us_name = request.getParameter("uname");
                String ps_word = request.getParameter("psw");
                User user = dao.login(us_name, ps_word);
                if (user == null) {
                    dispatcher = request.getRequestDispatcher("login-error-home.jsp");
                    dispatcher.forward(request, response);
                } else {
                    request.setAttribute("user", user);
                    HttpSession sess = request.getSession();
                    sess.setAttribute("user", user);
                    if (user.getRole().equalsIgnoreCase("admin")) {
                        ArrayList<User> users = dao.gettAllUsers();
                        request.setAttribute("users", users);
                        dispatcher = request.getRequestDispatcher("admin-home.jsp");
                        dispatcher.forward(request, response);
                    } else if (user.getRole().equalsIgnoreCase("management")) {
                        ArrayList<Donation> list = dao.getAllDonations();
                        request.setAttribute("donations", list);
                        ArrayList<String> projects = dao.getProjects();
                        request.setAttribute("projects", projects);
                        Vector<String> donations = dao.get_donation();
                        request.setAttribute("dons", donations);
                        dispatcher = request.getRequestDispatcher("management-home.jsp");
                        dispatcher.forward(request, response);
                    } else {
                        ArrayList<Donation> list = dao.getAllDonations(user.getAccountNumber());
                        request.setAttribute("donations", list);
                        ArrayList<String> projects = dao.getProjects();
                        request.setAttribute("projects", projects);
                        Vector<String> donations = dao.get_donation();
                        request.setAttribute("dons", donations);
                        dispatcher = request.getRequestDispatcher("member-home.jsp");
                        dispatcher.forward(request, response);
                    }
                }
            } else if (selection.equalsIgnoreCase("Update User Information")) {
                String userid = request.getParameter("userid");
                User user = dao.getUser(userid);
                if (user != null) {
                    request.setAttribute("user", user);
                    dispatcher = request.getRequestDispatcher("update-user.jsp");
                    dispatcher.forward(request, response);
                }
            } else if (selection.equalsIgnoreCase("update")) {
                String name = request.getParameter("name");
                String surname = request.getParameter("surname");
                String account = request.getParameter("accnum");
                String gender = request.getParameter("gender");
                String id = request.getParameter("id");
                String email = request.getParameter("email");
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String role = request.getParameter("role");

                User user = new User(name, surname, id, account, gender, username, password, email, role);
                int update = dao.update(user);
                if (update > 0) {
                    ArrayList<User> users = dao.gettAllUsers();
                    request.setAttribute("users", users);
                    dispatcher = request.getRequestDispatcher("admin-home.jsp");
                    dispatcher.forward(request, response);
                } else {
                    dispatcher = request.getRequestDispatcher("admin-update-error.jsp");
                    dispatcher.forward(request, response);
                }
            } else if (selection.equalsIgnoreCase("update profile")) {
                String name = request.getParameter("name");
                String surname = request.getParameter("surname");
                String account = request.getParameter("accnum");
                String gender = request.getParameter("gender");
                String id = request.getParameter("id");
                String email = request.getParameter("email");
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String role = request.getParameter("role");

                User user = new User(name, surname, id, account, gender, username, password, email, role);
                int update = dao.update(user);
                if (update > 0) {
                    request.setAttribute("user", user);
                    dispatcher = request.getRequestDispatcher("member-home.jsp");
                    dispatcher.forward(request, response);
                } else {
                    dispatcher = request.getRequestDispatcher("admin-update-error.jsp");
                    dispatcher.forward(request, response);
                }
            } else if (selection.equalsIgnoreCase("delete")) {
                String id = request.getParameter("userid");
                int delete = dao.deleteUser(id);
                if (delete > 0) {
                    ArrayList<User> users = dao.gettAllUsers();
                    request.setAttribute("users", users);
                    dispatcher = request.getRequestDispatcher("admin-home.jsp");
                    dispatcher.forward(request, response);
                } else {
                    dispatcher = request.getRequestDispatcher("admin-update-error.jsp");
                    dispatcher.forward(request, response);
                }
            } else if (selection.equalsIgnoreCase("Register Management")) {
                String name = request.getParameter("user_name");
                String surname = request.getParameter("usersurname");

                String id = request.getParameter("userid");
                String[] id_brk = id.split("");

                String gender = "male";
                if (Integer.parseInt(id_brk[6]) < 5) {
                    gender = "female";
                }

                int rand = new Random().nextInt(1754569);
                String account = "THN" + rand;

                String email = request.getParameter("useremail");
                String username = request.getParameter("username");
                String password = request.getParameter("password");

                boolean validID = true;

                if (!id.matches("^\\d+$")) {
                    dispatcher = request.getRequestDispatcher("invalidID-management.jsp");
                    dispatcher.forward(request, response);
                }
                if (id.length() == 13) {
                    if (username.length() > 5 && password.length() > 8) {
                        ArrayList<User> users = dao.gettAllUsers();
                        boolean exist = false;
                        for (int x = 0; x < users.size(); x++) {
                            if (users.get(x).getEmail().equals(email) || users.get(x).getId().equals(id) || users.get(x).getPassword().equals(password) || users.get(x).getUsername().equals(username)) {
                                exist = true;
                                break;
                            }
                        }
                        if (exist == true) {
                            dispatcher = request.getRequestDispatcher("mamagement-details-taken.jsp");
                            dispatcher.forward(request, response);
                        } else {
                            int reg = dao.register(new User(name, surname, id, account, gender, username, password, email, "management"));
                            if (reg > 0) {
                                request.setAttribute("users", users);
                                dispatcher = request.getRequestDispatcher("admin-home.jsp");
                                dispatcher.forward(request, response);
                            } else {
                                dispatcher = request.getRequestDispatcher("admin-update-error.jsp");
                                dispatcher.forward(request, response);
                            }
                        }
                    }
                } else {
                    dispatcher = request.getRequestDispatcher("admin-management-reg-error.jsp");
                    dispatcher.forward(request, response);
                }

            } else if (selection.equalsIgnoreCase("Donate Money")) {
                String account = request.getParameter("accnumber");
                double amount = Double.parseDouble(request.getParameter("amount"));
                String id = request.getParameter("id");
                int donate = dao.donate(account, amount);
                if (donate > 0) {
                    ArrayList<Donation> list = dao.getUserDonation(account);
                    request.setAttribute("donations", list);
                    dispatcher = request.getRequestDispatcher("member-home.jsp");
                    dispatcher.forward(request, response);
                }
            } else if (selection.equalsIgnoreCase("Donate to project")) {

                String account = request.getParameter("account");
                double amount = Double.parseDouble(request.getParameter("amount"));
                String description = request.getParameter("description");

                int donate = dao.pay_donation(account, amount, description);

                if (donate > 0) {
                    String us_name = request.getParameter("uname");
                    String ps_word = request.getParameter("psw");
                    User user = dao.login(us_name, ps_word);

                    request.setAttribute("user", user);

                    ArrayList<Donation> list = dao.getAllDonations(account);
                    request.setAttribute("donations", list);
                    ArrayList<String> projects = dao.getProjects();
                    request.setAttribute("projects", projects);
                    Vector<String> donations = dao.get_donation();
                    request.setAttribute("dons", donations);
                    dispatcher = request.getRequestDispatcher("member-home.jsp");
                    dispatcher.forward(request, response);
                }
            } else if (selection.equalsIgnoreCase("Tithe")) {

                String account = request.getParameter("account");
                double amount = Double.parseDouble(request.getParameter("amount"));
                String date = request.getParameter("date");

                int tithe = dao.tithe(account, date, amount);

                String us_name = request.getParameter("uname");
                String ps_word = request.getParameter("psw");
                User user = dao.login(us_name, ps_word);

                request.setAttribute("user", user);

                ArrayList<Donation> list = dao.getAllDonations(account);
                request.setAttribute("donations", list);
                ArrayList<String> projects = dao.getProjects();
                request.setAttribute("projects", projects);
                Vector<String> donations = dao.get_donation();
                request.setAttribute("dons", donations);
                dispatcher = request.getRequestDispatcher("member-home.jsp");
                dispatcher.forward(request, response);

            } else if (selection.equalsIgnoreCase("Create New Project")) {
                HttpSession session = request.getSession();
                String start_day = request.getParameter("start_day");
                String start_month = request.getParameter("start_month");
                String start_year = request.getParameter("start_year");

                String start_date = start_day + "/" + start_month + "/" + start_year;

                String end_day = request.getParameter("end_day");
                String end_month = request.getParameter("end_month");
                String end_year = request.getParameter("end_year");

                String end_date = end_day + "/" + end_month + "/" + end_year;

                String amount = request.getParameter("proj_cost");
                String name = request.getParameter("proj_name");

                boolean valid = false;

                if (start_day.isEmpty()) {
                    valid = false;
                }

                if (end_day.isEmpty()) {
                    valid = false;
                }

                if (start_month.isEmpty()) {
                    valid = false;
                }

                if (end_month.isEmpty()) {
                    valid = false;
                }

                if (start_year.isEmpty()) {
                    valid = false;
                }

                if (end_year.isEmpty()) {
                    valid = false;
                }
                if (start_month.equals(end_month)) {
                    if (Integer.parseInt(end_day) > Integer.parseInt(start_day)) {
                        if (Integer.parseInt(end_year) >= Integer.parseInt(start_day)) {
                            valid = true;
                        }
                    }
                } else if (Integer.parseInt(start_month) < Integer.parseInt(end_month)) {
                    if (Integer.parseInt(end_year) >= Integer.parseInt(start_year)) {
                        valid = true;
                    }
                } else if (Integer.parseInt(start_month) > Integer.parseInt(end_month)) {
                    if (Integer.parseInt(end_year) > Integer.parseInt(start_year)) {
                        valid = true;
                    }
                } else if (Integer.parseInt(start_day) == Integer.parseInt(end_day)) {
                    if (Integer.parseInt(end_year) > Integer.parseInt(start_year)) {
                        if (Integer.parseInt(start_month) > Integer.parseInt(end_month)) {
                            valid = true;
                        }
                    }
                }

                if (valid) {
                    int rand = new Random().nextInt(521458796);
                    String proj_no = "#PRO" + rand;
                    int added = dao.registerProject(proj_no, name, start_date, end_date, Double.parseDouble(amount));
                    if (added > 0) {
                        User user = (User) session.getAttribute("user");
                        ArrayList<Donation> list = dao.getAllDonations();
                        request.setAttribute("donations", list);
                        ArrayList<String> projects = dao.getProjects();
                        request.setAttribute("projects", projects);
                        Vector<String> donations = dao.get_donation();
                        request.setAttribute("dons", donations);

                        dispatcher = request.getRequestDispatcher("management-home.jsp");
                        dispatcher.forward(request, response);
                    } else {

                        dispatcher = request.getRequestDispatcher("creation-error.jsp");
                        dispatcher.forward(request, response);
                    }
                } else {

                    dispatcher = request.getRequestDispatcher("creation-error.jsp");
                    dispatcher.forward(request, response);
                }
            }

        } catch (Exception ex) {
            System.out.println();
            ex.printStackTrace();
            request.setAttribute("error", ex);
            response.sendRedirect("systemError.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String selection = request.getParameter("selection");

            SystemDao dao = new SystemDao();
            String username_dbase = getServletContext().getInitParameter("username");
            String dbasepsw = getServletContext().getInitParameter("password");
            String dbase = getServletContext().getInitParameter("jdbcConnection");
            dao.open(username_dbase, dbasepsw, dbase);

            if (selection.equalsIgnoreCase("Proceed")) {
                HttpSession session = request.getSession();
                User user = (User) session.getAttribute("user");
                request.setAttribute("user", user);
                ArrayList<Donation> list = dao.getAllDonations();
                request.setAttribute("donations", list);
                ArrayList<String> projects = dao.getProjects();
                request.setAttribute("projects", projects);
                Vector<String> donations = dao.get_donation();
                request.setAttribute("dons", donations);

                request.getRequestDispatcher("management-home.jsp").forward(request, resp);
            }
        } catch (SQLException ex) {
           resp.sendRedirect("systemError.jsp");
        } catch (ClassNotFoundException ex) {
            resp.sendRedirect("systemError.jsp");
        }
    }

}
