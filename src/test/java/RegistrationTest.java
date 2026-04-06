/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.chatapp;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author omphi
 */
public class RegistrationTest {
 

    @Test
    //Test a correctly formatted username to return message
    public void testCheckUserNameCorrect() {
        Registration registration = new Registration();
        assertEquals("Username successfully captured.",
                registration.returnUserNameMessage("Kyl_1"));
    }
    @Test
    //Test a incorrectly formatted username to return message
    public void testCheckUserNameIncorrect() {
        Registration registration = new Registration();
        assertEquals("Username is not correctly formatted, please ensure that "
                    + "your username contains an underscore and is no more than "
                    + "five characters in length.",
                registration.returnUserNameMessage("Kyle!!!!!"));
    }
    @Test
    //Test a correctly formatted password to return message
    public void testCheckPasswordCorrect() {
        Registration registration = new Registration();
        assertEquals("Password successfully captured.",
                registration.returnCheckPasswordMessage("Ch&&sec@ke99!"));
    }
    @Test
    //Test a incorrectly formatted password to return message
    public void testCheckPasswordIncorrect() {
        Registration registration = new Registration();
        assertEquals("Password is not correctly formatted, "
                    + "please ensure that the password contains atleast eight characters,"
                    + "a capital letter, a number, and a special character.",
                registration.returnCheckPasswordMessage("password"));
    }
    @Test
    //Test a correctly formatted cell number to return message
    public void testCheckCellPhoneNumberCorrect() {
        Registration registration = new Registration();
        assertEquals("Cell phone number successfully added." , 
                registration.returncheckCellPhoneNumberMessage("+27838968976"));
    }
    @Test
    //Test a incorrectly formatted cell number to return message
    public void testCheckCellPhoneNumberIncorrect() {
        Registration registration = new Registration();
        assertEquals("Cell phone number incorrectly formatted or does not contain international code; please correct the number and try again." ,
                registration.returncheckCellPhoneNumberMessage("08966553"));
    }
}
