/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;
/**
 *
 * @author omphi
 */
public class Registration {
    //the method to validate the username
    public boolean checkUserName(String username){
        
      if(username.contains("_") && username.length()<=5) {
            return true;
        } else {
            return false;
        
        }
    }
    //Method returning the correct message
    public String returnUserNameMessage(String username){
        if (checkUserName(username)) {
            return "Username successfully captured.";
        } else {
            return "Username is not correctly formatted, please ensure that "
                    + "your username contains an underscore and is no more than "
                    + "five characters in length.";
                 
        }
    }
    //the method to validate the password
    public boolean checkPasswordComplexity(String password){
        
        if (password.length()>=8 &&
           password.matches(".*[A-Z].*") &&
           password.matches(".*[0-9].*") &&
           password.matches(".*[^a-zA-Z0-9].*")){
             return true;
        } else {
            return false;
        }
    }
    //Method returning the correct message
    public String returnCheckPasswordMessage(String password){
        if (checkPasswordComplexity(password)){
          return "Password successfully captured.";  
        } else {
            return "Password is not correctly formatted, "
                    + "please ensure that the password contains atleast eight characters,"
                    + "a capital letter, a number, and a special character.";
        }
    }
    //the method to validate the cellphone number
    public boolean checkCellPhoneNumber(String cellPhoneNumber){
        if (cellPhoneNumber.matches("\\+27\\d{9}")) {
          return true;  
        } else {
            return false;
        }
         
    }
    //Method returning the correct message
    public String returncheckCellPhoneNumberMessage(String cellPhoneNumber) {
        if (checkCellPhoneNumber(cellPhoneNumber)){
            return "Cell phone number successfully added.";
        } else {
            return "Cell phone number incorrectly formatted or does not contain international code";
        }
    }
 }
