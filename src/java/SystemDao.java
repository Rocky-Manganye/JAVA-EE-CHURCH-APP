import java.sql.*;
import java.util.ArrayList;
import rocksta.donation.Donation;
import rocksta.user.User;
import java.util.Date;
import java.util.Random;
import java.util.Vector;

public class SystemDao {

    Statement statement;
    Connection connection;    

    public SystemDao() {        
    }    

    public void open(String username, String password, String db) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(db, username, password);
        statement = connection.createStatement();
    }    
    
    private void updateAccount(double amount) throws SQLException{
        statement.executeUpdate("insert into tbl_account(amount)values ("+amount+")");
    }

    public int register(User user) throws SQLException {
        String name = user.getName();
        String surname = user.getSurname();
        String account = user.getAccountNumber();
        String gender = user.getGender();
        String id = user.getId();
        String email = user.getEmail();
        String username = user.getUsername();
        String password = user.getPassword();
        String role = user.getRole();
        String sql = "insert into tbluser(name,surname,account,gender,id,email,username,password,role) values('" + name + "','" + surname + "','" + account + "','" + gender + "','" + id + "','" + email + "','" + username + "','" + password + "','" + role + "')";
        return statement.executeUpdate(sql);
    }    

    public User login(String username, String password) throws SQLException {
        User user = null;
        String sql = "select name,surname,account,gender,id,email,username,password,role from tbluser where username like '" + username + "' and password like '" + password + "'";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            String name = rs.getString(1);
            String surname = rs.getString(2);
            String account = rs.getString(3);
            String gender = rs.getString(4);
            String id = rs.getString(5);
            String email = rs.getString(6);
            String user_name = rs.getString(7);
            String pass_word = rs.getString(8);
            String role = rs.getString(9);            
            user = new User(name, surname, id, account, gender, user_name, pass_word, email, role);
        }        
        return user;
    }

    public ArrayList<Donation> getUserDonation(String acc) throws SQLException {
        ArrayList<Donation> donations = new ArrayList<Donation>();
        String sql = "select amount,date from tbldonation where account = " + acc;
        ResultSet rs = statement.executeQuery(sql);
        
        while (rs.next()) {
            donations.add(new Donation(rs.getString(2), rs.getDouble(1)));
        }
        return donations;
    }    
    
    public ArrayList<User> gettAllUsers() throws SQLException {        
        ArrayList<User> users = new ArrayList<User>();
        String sql = "select name,surname,account,gender,id,email,username,password,role from tbluser WHERE role NOT LIKE  'admin'";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            String name = rs.getString(1);
            String surname = rs.getString(2);
            String account = rs.getString(3);
            String gender = rs.getString(4);
            String id = rs.getString(5);
            String email = rs.getString(6);
            String user_name = rs.getString(7);
            String pass_word = rs.getString(8);
            String role = rs.getString(9);            
            
            users.add(new User(name, surname, id, account, gender, user_name, pass_word, email, role));
        }
        
        return users;
    }
    
    public ArrayList<User> gettAllMembers() throws SQLException {        
        ArrayList<User> users = new ArrayList<User>();
        String sql = "select name,surname,account,gender,id,email,username,password,role from tbluser WHERE role LIKE  'member'";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            String name = rs.getString(1);
            String surname = rs.getString(2);
            String account = rs.getString(3);
            String gender = rs.getString(4);
            String id = rs.getString(5);
            String email = rs.getString(6);
            String user_name = rs.getString(7);
            String pass_word = rs.getString(8);
            String role = rs.getString(9);            
            
            users.add(new User(name, surname, id, account, gender, user_name, pass_word, email, role));
        }
          return users;
    }
    
    public int update(User user) throws SQLException {
        String name = user.getName();
        String surname = user.getSurname();
        String account = user.getAccountNumber();
        String gender = user.getGender();
        String id = user.getId();
        String email = user.getEmail();
        String username = user.getUsername();
        String password = user.getPassword();
        String role = user.getRole();
        String update = "update tbluser set name ='" + name + 
                "',surname ='" + surname + "',account = '" + 
                account + "',gender ='" + gender + "',id ='" + id 
                + "',email ='" + email + "',username ='" + username 
                + "',password ='" + password + "',role='" + role + 
                "' where id like '" + user.getId() + "'";
        
        return statement.executeUpdate(update);
    }
    
    public User getUser(String idnum) throws SQLException {
        User user = null;
        String sql = "select name,surname,account,gender,id,email,username,password,role from tbluser where id like '" + idnum + "'";
        ResultSet rs = statement.executeQuery(sql);
        if (rs.next()) {
            String name = rs.getString(1);
            String surname = rs.getString(2);
            String account = rs.getString(3);
            String gender = rs.getString(4);
            String id = rs.getString(5);
            String email = rs.getString(6);
            String user_name = rs.getString(7);
            String pass_word = rs.getString(8);
            String role = rs.getString(9);            
            user = new User(name, surname, id, gender, account, user_name, pass_word, email, role);
        }        
        return user;
    }
    
    public int deleteUser(String id) throws SQLException {        
        String sql = "delete from tbluser where id like '" + id + "'";
        return statement.executeUpdate(sql);
    }
    
    public int donate(String account, double amount) throws SQLException {
        Date date = new Date();
        String strDate = date.toString();
        updateAccount(amount);
        String donateSQL = "insert into tbl_tithe(date,amount,account) "
                + "values('" + strDate + "'," + amount + ",'" + account + "')";
        return statement.executeUpdate(donateSQL);
    }
    
    public ArrayList<Donation> getAllDonations() throws SQLException {
        ArrayList<Donation> donations = new ArrayList<Donation>();
        String sql = "select amount,date from tbl_tithe";
        ResultSet rs = statement.executeQuery(sql);
        
        while (rs.next()) {
            donations.add(new Donation(rs.getString(2), rs.getDouble(1)));
        }
        return donations;
    }
    
    public ArrayList<Donation> getAllDonations(String account) throws SQLException {
        ArrayList<Donation> donations = new ArrayList<Donation>();
        String sql = "select amount,date from tbl_tithe where account like '" + account + "'";
        ResultSet rs = statement.executeQuery(sql);
        
        while (rs.next()) {
            donations.add(new Donation(rs.getString(2), rs.getDouble(1)));
        }
        return donations;
    }

    public int registerProject(String proj_num, String name, String start_date, String end_date, double cost) throws SQLException {
        String sql = "insert into tbl_project(Project_no,Project_name,Start_date,End_Date,Amount)"
                + " values('" + proj_num + "','" + name + "','" + start_date + "','" + end_date + "'," + cost + ")";
        return statement.executeUpdate(sql);
    }
    
    public ArrayList<String> getProjects() throws SQLException {
        String sql = "select * from tbl_project";
        ResultSet rs = statement.executeQuery(sql);
        ArrayList<String> projects = new ArrayList<String>();
        while (rs.next()) {
            String proj_num = rs.getString(1);
            String name = rs.getString(2);
            String start_date = rs.getString(3);
            String end_date = rs.getString(4);
            double cost = rs.getDouble(5);
            
            String data = proj_num + "@" + name + "@" + start_date + "@" + end_date + "@" + cost;
            projects.add(data);
        }
        
        return projects;
    }
    
    public int pay_donation(String account, double amount, String description) throws SQLException {
        int rand = new Random().nextInt(6523654);
        String don_cde = "DON" + rand;
         updateAccount(amount);
        String sql = "insert into tbl_donation(donation_no,account_no,donation_description,Amount) "
                + "values('" + don_cde + "','" + account + "','" + description + "'," + amount + ")";
        return statement.executeUpdate(sql);        
    }

    public User getUser_(String acc) throws SQLException {
        User user = null;
        String sql = "select name,surname,account,gender,id,email,username,password,role from tbluser where account like '" + acc + "'";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            String name = rs.getString(1);
            String surname = rs.getString(2);
            String account = rs.getString(3);
            String gender = rs.getString(4);
            String id = rs.getString(5);
            String email = rs.getString(6);
            String user_name = rs.getString(7);
            String pass_word = rs.getString(8);
            String role = rs.getString(9);            
            user = new User(name, surname, id, account, gender, user_name, pass_word, email, role);
        }        
        return user;
    }
    
    public int tithe(String account, String date, double amount) throws SQLException {
         updateAccount(amount);
        String sql = "insert into tbl_tithe(date,amount,account) values('" + date + "'," + amount + ",'" + account + "')";
        return statement.executeUpdate(sql);
    }    
    
    public Vector<String> get_donation() throws SQLException {        
        String sql = "select donation_no,account_no,Amount from tbl_donation ";
        Vector<String> donations = new Vector<String>();
        ResultSet rs = statement.executeQuery(sql);
        while(rs.next()){
            String data = rs.getString(1) + "@" + rs.getString(2) + "@" + rs.getDouble(3);
            donations.add(data);
        }
        return donations;        
    }
}
