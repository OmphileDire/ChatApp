/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;
/**
 *
 * @author omphi
 */
public class User {
    //Instance variables used to store user information
    private String username;
    private String password;
    private String cellPhoneNumber;
     
    //constructor to fill those variables for a new user
    public User(String username, String password, String cellPhoneNumber){
        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
    }           
}
