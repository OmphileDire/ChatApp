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
public class MessageTest {
    @Test
    public void testCheckMessageLengthValid() {
        Message message = new Message("0000000000", "+27718693002", 
                                   "Hi Mike, can you join us for dinner tonight?", 0);
    assertEquals("Message ready to send.", 
                  message.checkMessageLength("Hi Mike, can you join us for dinner tonight?"));
}

@Test
public void testCheckMessageLengthInvalid() {
    Message message = new Message("0000000000", "+27718693002", 
                                   "Hi Mike, can you join us for dinner tonight?", 0);
    String longMessage = "A".repeat(251);
    assertEquals("Message exceeds 250 characters by 1; please reduce the size.", 
                  message.checkMessageLength(longMessage));
}

@Test
public void testCheckRecipientCellValid() {
    Message message = new Message("0000000000", "+27718693002", "test", 0);
    assertEquals("Cell phone number successfully captured.", 
                  message.checkRecipientCellMessage("+27718693002"));
}

@Test
public void testCheckRecipientCellInvalid() {
    Message message = new Message("0000000000", "08575975889", "test", 0);
    assertEquals("Cell phone number is incorrectly formatted or does not contain " +
                 "an international code. Please correct the number and try again.", 
                  message.checkRecipientCellMessage("08575975889"));
    }
@Test
public void testCheckRecipientCellTrue() {
    Message message = new Message("0000000000", "+27718693002", "test", 0);
    assertTrue(message.checkRecipientCell("+27718693002"));
}

@Test
public void testCheckRecipientCellFalse() {
    Message message = new Message("0000000000", "08575975889", "test", 0);
    assertFalse(message.checkRecipientCell("08575975889"));
}

@Test
public void testCheckMessageIDTrue() {
    Message message = new Message("0000000000", "+27718693002", "test", 0);
    assertTrue(message.checkMessage("0000000000"));
}

@Test
public void testCheckMessageIDFalse() {
    Message message = new Message("00000000000", "+27718693002", "test", 0);
    assertFalse(message.checkMessage("00000000000"));
}    
}
