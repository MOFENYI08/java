/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectpoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author letha
 */
public class projectpoe2 {
   
    //Instance variables
    private String messageID;
    private int messageNumber;
    private String recipient;
    private String messageContent;
    private String messageHash;
    
    //static list to track all sent or stored message while application runs 
    private static List<Message> allMessages = new ArrayList<>();
    private static int totalMessageCounter = 0 ;

    //default constructor that autogenerates IDs and counters
    public projectpoe2(){
        this.messageID = generateRandom10DigitID();
        this.messageNumber = totalMessageCounter;
    }
     //  constructors with parameters
    public projectpoe2 (String messageID, int messageNumber, String recipient, String messageContent ){
        this.messageID = messageID;
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageContent = messageContent;
    }
    //method to generate a random 10 digit number as string
    private String genetrateRandom10DigitID(){
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i< 10; i++){
            sb.append(rand.nextInt(10));
        }
        return sb.toString();
       }
    //checkMessageID
    public boolean checkMessageID(){
        return this.messageID!= null && this.messageID.length()<= 10;
    }
    //message status
    public String getMessageIDCreationStatus(){
        return "MessageID genrated:" + this.messageID;
    }
    //check recipient
    public String checkRecipientCell(){
        if (this.recipient!= null && this.recipient.length() <= 10 && this.recipient.startsWith("+")){
            return "cell phone number successfully captured.";
        }else{
            return "cell phone is incorrectly formatted or does not contain and international code, please correct the number and try again.";
        }
    }
    //message length
    public String validateMessageLength(){
        if (this.messageContent == null) return "message content is empty.";
        if(this.messageContent.length() <= 250){
            return "Message ready to send.";
        }else{
            int exceededBy = this.messageContent.length() - 250;
            return"Message exceede 250 characters by" + exceedBy + ", please reduce size";
        }
    }
    // message hash
    public String createMessageHash(){
        if (this.messageID == null || this.messageContent ==null || this.messageContent.trim().isEmpty()){
            return "message hash invalid";
        }
        //first two numbers of message Id
        String idPrefix = this.messageID.substring(0, math.min(2, this.messageID.length()));
        
        //extract first and last words
        String [] words = this.messageContent.trim().split("\\s+");
        String firstWords = words [0];
        String lastWord = words[words.length - 1];
        
        // Assemble and capitalize
        this.messageHash = (idPrefix + ":" + this.messageNumber + ":" + firstWord + lastWord).toUpperCase();
        return this.messageHash;
    }
    //sent message
    public String sentMessage (int choice){
        switch (choice){
            case 1:
                totalMessageCounter++;
                allMessages.add(this);
                return "Message successfully sent.";
            case 2:
                return "press 0 to delete the message";
            case 3:
                totalMessagesCounter++;
                allMessages.add(this);
                return "Message successfully stored";
            default:
                return "invalid option";
        }
    }
    
    // print message
    public String printMessage(){
        StringBuilder sb = new StringBuilder();
        for (message msg: allMessages){
            sb.append("Message ID:" ).append(msg.getMessageId()).append("\n")
                    .append ("message Hash:").append(msg.getMessageHash()).append("\n")
                    .append ("recipient:").append(msg.getRecipient()).append("\n")
                    .append ("message :").append(msg.getMessageContent()).append("\n")
                    .append("---------\n");
        }
        return sb.toString();
    }
    
    // return total message 
    public int returnTotalMessage(){
        return totalMessageCounter;
    }
    // store message 
    public void storeMessage(){
        System.out.println("{\"messageId\" : \"" + this.messageID + "\", \"Hash\" : \"" + this.messageHash + "\"} successfully serialised to storage JSON.");
    }
    
    // getters and setters
    public String getMessageId(){ return messageId;}
    public void setMessageId (String messageId ){ this.messageID = messageId;}
    public int getMessageNumber(){return messageNumber; }
    public String getRecipient() {return recipient; }
    public  void setRecipient (String recipient){this. recipient = recipient;}
    public String getMessageContent() {return messageContent; }
    public void setMessageCounter(String messageContent) {this.messageContent = messageContent;}
    public String grtMessageHash(){return messageHash; }
}

// the main driver class
public class QuickChatApp{
    public static void main (String[] args){
        Scanner input = new Scanner (System.in);
        boolean running = true;
        System.out.println("Welcome to quickChat");
        
        while(running){
           System.out.println("\nPease choose an option from menu:");
           System.out.println("1) Send message");
           System.out.println("2) Show recently sent messages");
           System.out.println("3) Quit");
           System.out.print("Enter code: ");
           
           int menuChoice = input.nextInt();
           input.nextLine();
           
           switch(menuChoice){
               case 1:
                   System.out.print("How many messages do you wish to enter?");
                   int numMessages = input.nextInt();
                   input.nextLine();
                   
                   for (int i = 0; i < numMessages; i++) {
                       Message msg = new Message();
                       System.out.println("\n--- "+ msg.getMessageIdCreationStatus() + "---");
                       
                       while(true){
                           System.out.print("Enter recipient cell:");
                           msg.setRecipient(input.nextLine());
                           String validation = msg.checkRecipientCell();
                           System.out.println(validation );
                           if (validation.contains("successfully")) break;
                       }
                       
                       while(true){
                           System.out.print("Enter short message (Max 250 chars) : ");
                           msg.setMessageContent(input.nextLine());
                           String validation = msg.validateMessageLength();
                           System.out.println(validation);
                           if (validation.contains("ready")) break;
                       }
                       msg.createMessageHash();
                       System.out.println("\nChoose action:\n1) send\n2) Disregard\n3) Store");
                     
                       int action = input.nextInt();
                       input.nextLine();
                       
                       System.out.printIn(msg.SentMessage(action));
                       if (action == 3)msg.storeMessage();
                   }
                   break;
                   case2:
                   System.out.println("comming soon.");
                   break;
               case 3:
                   running = false;
                   Message summary = new Message();
                   System.out.println("\nTotal accumulated message processed:" + summary.returnTotalMessages());
                   break;
               default:
                   System.out.println("invalid selection");
           }
        }
        input.close();
    }
}
                           
                           
                       
           
