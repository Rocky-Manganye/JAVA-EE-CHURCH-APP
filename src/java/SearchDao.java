
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import rocksta.user.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author learner.One
 */
public class SearchDao {
    Statement statement;
    Connection connection;    
     public void open(String username, String password, String db) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(db, username, password);
        statement = connection.createStatement();
    }    
     
     public User search(String acc) throws SQLException{
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

}
