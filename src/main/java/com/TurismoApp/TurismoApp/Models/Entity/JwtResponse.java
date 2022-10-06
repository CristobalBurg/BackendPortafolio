package com.TurismoApp.TurismoApp.Models.Entity;

public class JwtResponse {

    private String token;


    public JwtResponse() {
    }

    public JwtResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public JwtResponse token(String token) {
        setToken(token);
        return this;
    }



    @Override
    public String toString() {
        return "{" +
            " token='" + getToken() + "'" +
            "}";
    }

    
}
