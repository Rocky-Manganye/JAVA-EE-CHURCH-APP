package rocksta.user;

import java.util.Random;

public class User {
    private String name;
    private String surname;
    private String id;
    private String gender;
    private String th_num;
    private String username;
    private String password;
    private String email;
    private String role;
    public User() {
    }

    public User(String name, String surname, String id, String th_num,String gender, String username, String password, String email,String role) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.gender = gender;
       
        this.th_num = th_num;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAccountNumber() {
        return th_num;
    }

    public void setAccountNumber(String th_num) {
        this.th_num = th_num;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
    
    
}
