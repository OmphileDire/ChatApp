/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.chatapp;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author omphi
 */
public class ChatAppTest {
    
    public ChatAppTest() {
    }
    @Test
    public void testSentMessagesArrayPopulated() {
        Message.addSentMessage("Did you get the cake?");
        Message.addSentMessage("It is dinner time!");
        ArrayList<String> sent = Message.getSentMessages();
        assertTrue(sent.contains("Did you get the cake?"));
        assertTrue(sent.contains("It is dinner time!"));
    }
    @Test
    public void testLongestMessage() {
        Message.addStoredMessage("Where are you? You are late! I have asked you to be on time.");
        Message.addStoredMessage("Did you get the cake?");
        ArrayList<String> stored = Message.getStoredMessages();
        String longest = "";
    for (String msg : stored) {
        if (msg.length() > longest.length()) {
            longest = msg;
        }
    }
    assertEquals("Where are you? You are late! I have asked you to be on time.", longest);
  }
    @Test
    public void testSearchMessageID() {
        Message.addMessageID("0838884567");
        Message.addStoredMessage("It is dinner time!");
        ArrayList<String> ids = Message.getMessageIDs();
        int index = ids.indexOf("0838884567");
        assertNotEquals(-1, index);
        assertEquals("It is dinner time!", Message.getStoredMessages().get(index)); 
}
    @Test
    public void testSearchByRecipient() {
        Message.addStoredMessage("Where are you? You are late! I have asked you to be on time.");
        Message.addStoredMessage("Ok, I am leaving without you.");
        ArrayList<String> stored = Message.getStoredMessages();
        boolean found = false;
    for (String msg : stored) {
        if (msg.contains("+27838884567")) {
            found = true;
        }
    }
    assertFalse(stored.isEmpty());
}

    @Test
    public void testDeleteMessageUsingHash() {
        Message.addStoredMessage("Where are you? You are late! I have asked you to be on time.");
        Message.addMessageHash("WH:1:WHERETIME");
        ArrayList<String> hashes = Message.getMessageHashes();
        int index = hashes.indexOf("WH:1:WHERETIME");
        assertNotEquals(-1, index);
        Message.getStoredMessages().remove(index);
        Message.getMessageHashes().remove(index);
        assertFalse(Message.getMessageHashes().contains("WH:1:WHERETIME"));
}

    @Test
    public void testDisplayReport() {
        Message.addStoredMessage("Did you get the cake?");
        Message.addMessageHash("DI:0:DIDCAKE");
        ArrayList<String> stored = Message.getStoredMessages();
        ArrayList<String> hashes = Message.getMessageHashes();
        assertFalse(stored.isEmpty());
        assertFalse(hashes.isEmpty());
 }
}
   
