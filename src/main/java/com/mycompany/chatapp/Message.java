/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;

/**
 *
 * @author omphi
 */
public class Message {
    //Instance variables to store message information
    private String messageID;
    private String recipientNumber;
    private String messageText;
    private int numMessagesSent;
    
    // Constructor to initialise message details
    public Message(String messageID, String recipientNumber,
            String messageText, int numMessagesSent) {
        this.messageID = messageID;
        this.recipientNumber = recipientNumber;
        this.messageText = messageText;
        this.numMessagesSent = numMessagesSent;
    }
    // Method to check if message ID is no more than 10 characters
    public boolean checkMessage(String messageID) {
        return messageID.length() <= 10;
    }
    // Method to check if recipient cell number is valid
    public boolean checkRecipientCell(String recipientNumber) {
        return recipientNumber.matches("\\+27\\d{9}");
    }
    // Method to return appropriate recipient cell message
    public String checkRecipientCellMessage(String recipientNumber) {
        if (checkRecipientCell(recipientNumber)) {
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain " +
                  "an international code. Please correct the number and try again.";  
        }
    }
    // Method to create the message hash
    public String createMessageHash(String messageID, int messageNumber, String messageText) {
        String[] words = messageText.split(" ");
        String firstWord = words[0].replaceAll("[^a-zA-Z0-9]", "");
        String lastWord = words[words.length - 1].replaceAll("[^a-zA-Z0-9]", "");
        String hash = messageID.substring(0, 2) + ":" + messageNumber + ":" 
                + firstWord + lastWord;
        return hash.toUpperCase();
    }
    // Method to allow user to choose to send, store or disregard message
    public String SentMessage(int choice) {
        if (choice == 1) {
            return "Message successfully sent.";
        } else if ( choice ==2) {
            return "Press 0 to delete the message.";
        }else if (choice ==3) {
                    return "Message successfully stored.";
                    } else {
            return "Invalid option selected.";
        }
        }
    // Method to return all messages sent
    public String printMessages(String messageID, String recipientNumber,
            String messageText, String messageHash) {
        return "Message ID: " + messageID + "\n" +
               "Message Hash: " + messageHash + "\n" +
               "Recipient: " + recipientNumber + "\n" +
               "Message: " + messageText;
    }
    // Method to return total number of messages sent
    public int returnTotalMessages(int numMessagesSent) {
        return numMessagesSent;
    }
    // Method to store message in JSON file
   // Reference: GeeksforGeeks [3]
    public void storeMessage(String messageID, String recipientNumber,
            String messageText, String messageHash) {
         String jsonMessage = "{\n" +
                 "  \"messageID\": \"" + messageID + "\",\n" +
                 "  \"recipientNumber\": \"" + recipientNumber + "\",\n" +
                 "  \"messageText\": \"" + messageText + "\",\n" +
                 "  \"messageHash\": \"" + messageHash + "\"\n" +
                 "}";
         
         try {
             //Writing to JSON File
             java.io.FileWriter fileWriter =new java.io.FileWriter("message.json", true);
             fileWriter.write(jsonMessage);
             fileWriter.close();
             System.out.println("Message successfully stored.");
         } catch (java.io.IOException e) {
            System.out.println("Error storing message: " + e.getMessage()); 
         }
    }
    // Method to check if message is not more than 250 characters
    public String checkMessageLength(String messageText) {
        if (messageText.length() <= 250) {
            return "Message ready to send.";
        } else {
            int excess = messageText.length() - 250;
            return "Message exceeds 250 characters by " + excess
                    + "; please reduce the size.";
        }
    }
    }

