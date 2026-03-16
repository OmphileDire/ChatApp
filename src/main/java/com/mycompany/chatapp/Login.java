/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;

/**
 *
 * @author omphi
 */
public class Login {
    ////Instance variables used to store user credentials
    private String storedUserName;
    private String storedPassword;
    
    //constructor to fill those variables
    public Login(String storedUserName, String storedPassword) {
        this.storedUserName = storedUserName;
        this.storedPassword = storedPassword;
    }
    //Method to verify credentials
    public boolean loginUser(String enteredUserName, String enteredPassword){
        if (storedUserName.equals(enteredUserName) && storedPassword.equals(enteredPassword)) {
            return true;
        } else {
            return false;
        }
        
    }
    //Method to return the correct message
    public String returnLoginStatus(String enteredUserName, String enteredPassword, 
                                    String firstName, String lastName) {
        if(loginUser(enteredUserName, enteredPassword)) {
            return "Welcome " + firstName + " " + lastName + ", " +"it is great to see you again.";
        } else
            return "Username or password incorrect, please try again.";
    }
}
