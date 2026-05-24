
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatapp;
import java.util.Scanner;
/**
 *
 * @author omphi
 */

/*
 REFERENCES
 [1] Bro Code, "Java Full Course for free," YouTube.
     [Online]. Available: https://www.youtube.com/@BroCodez
     [Accessed: 11 Apr. 2026].

 [2] Programming with Mosh, "Java Tutorial for Beginners," YouTube.
     [Online]. Available: https://www.youtube.com/@programmingwithmosh
     [Accessed: 11 Apr. 2026].

 [3] GeeksforGeeks, "Java Programming Language," geeksforgeeks.org.
     [Online]. Available: https://www.geeksforgeeks.org/java/
     [Accessed: 11 Apr. 2026].

 [4] Codecademy, "Learn Java," codecademy.com.
     [Online]. Available: https://www.codecademy.com/learn/learn-java
     [Accessed: 11 Apr. 2026].

 [5] Sololearn, "Java Introduction," sololearn.com.
     [Online]. Available: https://www.sololearn.com/learn/courses/java-introduction
     [Accessed: 11 Apr. 2026].

 [6] Learn Java Online, "Learn Java Online," learnjavaonline.org.
     [Online]. Available: https://www.learnjavaonline.org
     [Accessed: 11 Apr. 2026].
 */

// References used build this app:
// Bro Code [1], Programming with Mosh [2], 
// Sololearn [5], LearnJavaOnline [6]

public class ChatApp {

    public static void main(String[] args) {
        //A scanner to read the user's input
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the WhatsApp chatbox.");
        //Registration object to access validation methods
        Registration registration = new Registration();
        
        System.out.println("---> Registration <---");
        //Prompting user to enter their login details
        System.out.println("Enter your first name: ");
        String firstName = input.nextLine();
        
        System.out.println("Enter your last name: ");
        String lastName = input.nextLine();
        
        //Prompting the user to enter their login details
        
        String username;
        do{
        System.out.println("Enter your username: " + "(must cointain an underscore, and be less than 5 characters)");
        username = input.nextLine();
        System.out.println(registration.returnUserNameMessage(username));
        }while (!registration.checkUserName(username));
        
        String password;
        do{
        System.out.println("Enter your password: " + "(password must be: "
                + "atleast 8 characters long, "
                + "contain a capital letter, "
                + "contain a number,"
                + "contain a special character.)");
        password = input.nextLine();
        System.out.println(registration.returnCheckPasswordMessage(password));
        }while (!registration.checkPasswordComplexity(password));
        
        String cellPhoneNumber;
        do{
        System.out.println("Enter your cellphone number: " + " (must contain a international country code(+27)");
        cellPhoneNumber = input.nextLine();
        System.out.println(registration.returncheckCellPhoneNumberMessage(cellPhoneNumber));
        }while (!registration.checkCellPhoneNumber(cellPhoneNumber));
        
        System.out.println("---> Login <---");
        //Login object with registration credentials
        Login login = new Login(username, password);
        
        //Variable to track login status
        boolean loggedIn = false;
        
        //loop will continue until user enters the right credentials
        while (!loggedIn) {
            System.out.println("Enter your username: ");
        String loginUserName = input.nextLine();
        
        System.out.println("Enter your password: ");
        String loginPassword = input.nextLine();
        
        //check if entered credentials match the stored credentials
        if (login.loginUser(loginUserName, loginPassword)) {
          System.out.println("Welcome " + firstName + " " + lastName + ", " +"it is great to see you again.");
          loggedIn = true;
        } else {
            System.out.println("Username or password incorrect, please try again.");
            
        }
        }
        
        //PART 2
        // Display welcome message
System.out.println("Welcome to QuickChat.");

// Menu loop
int menuChoice = 0;

// List to store all sent messages
java.util.ArrayList<String> sentMessages = new java.util.ArrayList<>();
int totalMessagesSent = 0;

do {
    System.out.println("Please select an option:");
    System.out.println("1) Send Messages");
    System.out.println("2) Show recently sent messages");
    System.out.println("3) Quit");
    menuChoice = Integer.parseInt(input.nextLine());

    if (menuChoice == 1) {
        System.out.println("How many messages do you want to send?");
        int numMessages = Integer.parseInt(input.nextLine());
    
        for (int i = 0; i < numMessages; i++) {
            System.out.println("Enter recipient number: ");
            String recipientNumber = input.nextLine();

            System.out.println("Enter message: ");
            String messageText = input.nextLine();

            Message tempMessage = new Message("0000000000", "0000000000", messageText, i);
            String lengthCheck = tempMessage.checkMessageLength(messageText);
            System.out.println(lengthCheck);

            if (lengthCheck.equals("Message ready to send.")) {
                String messageID = String.valueOf((long)(Math.random() * 9000000000L) + 1000000000L);
                Message message = new Message(messageID, recipientNumber, messageText, i);
                String messageHash = message.createMessageHash(messageID, i, messageText);

                System.out.println(message.printMessages(messageID, recipientNumber,
                        messageText, messageHash));

                System.out.println("1) Send Message");
                System.out.println("2) Disregard Message");
                System.out.println("3) Store Message");
                int choice = Integer.parseInt(input.nextLine());
                
                

    if (choice == 1) {
                System.out.println(message.SentMessage(choice));
                sentMessages.add(message.printMessages(messageID, recipientNumber,
                    messageText, messageHash));
    totalMessagesSent++;
   } else if (choice == 2) {
                System.out.println(message.SentMessage(choice));
   } else if (choice == 3) {
                message.storeMessage(messageID, recipientNumber, messageText, messageHash);
                sentMessages.add(message.printMessages(messageID, recipientNumber,
                    messageText, messageHash));
    totalMessagesSent++;
    } 
     }
     }
    } else if (menuChoice == 2) {
     System.out.println("Coming Soon.");   
    }
} while (menuChoice != 3);

// Display total messages sent
System.out.println("Total messages sent: " + totalMessagesSent);
System.out.println("Messages sent during this session:");

for (String msg : sentMessages) {
    System.out.println(msg);
}
System.out.println("Goodbye!");
    }
}
