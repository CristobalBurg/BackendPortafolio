package com.TurismoApp.TurismoApp.Models.Entity;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {

    private String authority;

    @Override
    public String getAuthority() {
        return this.authority;
    }

    public Authority() {
    }

    public Authority(String authority) {
        this.authority = authority;
    }
    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Authority authority(String authority) {
        setAuthority(authority);
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " authority='" + getAuthority() + "'" +
            "}";
    }
    
}
