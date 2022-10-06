package com.TurismoApp.TurismoApp.Models.Entity;

public class JwtRequest {

    private String username;
    private String password;



    public JwtRequest() {
    }


    public JwtRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public JwtRequest username(String username) {
        setUsername(username);
        return this;
    }

    public JwtRequest password(String password) {
        setPassword(password);
        return this;
    }



    @Override
    public String toString() {
        return "{" +
            " username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            "}";
    }

    
}
