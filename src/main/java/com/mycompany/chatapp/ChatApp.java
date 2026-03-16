/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatapp;
import java.util.Scanner;
/**
 *
 * @author omphi
 */
public class ChatApp {

    public static void main(String[] args) {
        //A scanner to read the user's input
        Scanner input = new Scanner(System.in);
        Registration registration = new Registration();
        
        //Prompting the user to enter their detaails
        System.out.println("Enter your username: ");
        String username = input.nextLine();
        System.out.println(registration.returnUserNameMessage(username));
        
        System.out.println("Enter your password: ");
        String password = input.nextLine();
        System.out.println(registration.returnCheckPasswordMessage(password));
        
        System.out.println("Enter your cellphone number: ");
        String cellPhoneNumber = input.nextLine();
        System.out.println(registration.returncheckCellPhoneNumberMessage(cellPhoneNumber));
    }
}
