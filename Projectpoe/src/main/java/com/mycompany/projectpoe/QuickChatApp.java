/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectpoe;

import java.util.Scanner;

/**
 *
 * @author letha
 */
public class QuickChatApp {
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
