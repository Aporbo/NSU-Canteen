/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canteensystem.model;

import java.util.Objects;


public class account {
      private String name;
    private String ID;
    private String email ;
    private String password ;
    private String retypepassword;

    public account(String name, String ID, String email, String password, String retypepassword) {
        this.name = name;
        this.ID = ID;
        this.email = email;
        this.password = password;
        this.retypepassword = retypepassword;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRetypepassword() {
        return retypepassword;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRetypepassword(String retypepassword) {
        this.retypepassword = retypepassword;
    }   
}
