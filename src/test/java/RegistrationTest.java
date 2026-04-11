/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.chatapp.Login;
import com.mycompany.chatapp.Registration;
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

// References used for JUnit testing:
// GeeksforGeeks [3], Codecademy [4]

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
    @Test
    public void testCheckUserNameTrue() {
        Registration registration = new Registration();
        assertTrue(registration.checkUserName("Kyl_1"));
    }
    @Test
    public void testCheckUserNameFalse() {
        Registration registration = new Registration();
        assertFalse(registration.checkUserName("Kyle!!!!!"));
    }
    @Test
    public void testCheckPasswordTrue() {
        Registration registration = new Registration();
        assertTrue(registration.checkPasswordComplexity("Ch&&sec@ke99!"));
    }
    @Test
    public void testCheckPasswordFalse() {
        Registration registration = new Registration();
        assertFalse(registration.checkPasswordComplexity("password"));
    }
    @Test
    public void testCheckCellPhoneNummberTrue() {
        Registration registration = new Registration();
        assertTrue(registration.checkCellPhoneNumber("+27838968976"));
    }
    @Test
    public void testCheckCellPhoneNummberFalse() {
        Registration registration = new Registration();
        assertFalse(registration.checkCellPhoneNumber("08966553"));
    }
    @Test
    public void testLoginSuccessful() {
        Login login = new Login("Kyl_1" ,"Ch&&sec@ke99!");
        assertTrue(login.loginUser("Kyl_1" ,"Ch&&sec@ke99!"));
    }
    @Test
    public void testLoginUnSuccessful() {
        Login login = new Login("Kyl_1" ,"Ch&&sec@ke99!");
        assertFalse(login.loginUser("WrongUser" ,"WrongPass"));
    }
}
