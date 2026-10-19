/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectpoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    
        }
    }
    
    
}
