/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projectpoe;

import java.util.Scanner;

/**
 *
 * @author letha
 */
public class Projectpoe {

    public static void main(String[] args) {
       Scanner inputs = new Scanner(System.in);
       Login login = new Login();
       //Declarations
       String userName;
       String password;
       String cellnumber;
       String firstName;
       String lastName;
       
      System.out.println("ACCOUNT REGISTRATION");
       
      System.out.print("Enter first name: ");
      firstName = inputs.nextLine();
      System.out.print("Enter Last name: ");
      lastName = inputs.nextLine();
      //loop for  credentials
      //loop until valid username
      System.out.print("Enter username: ");
      userName = inputs.nextLine();
      while (!login.checkUserName(userName)){
          System.out.println("Username is not correctly formatted, please ensure that username contains an underscore and is no more than five characters in length. ");
          System.out.print("Please username enter again:");
          userName = inputs.nextLine();
      }
      System.out.println("username successfully captured.");
      //loop until valid password
      System.out.print("Enter password: ");
      password = inputs.nextLine();
      while (!login.checkPasswordComplexity(password)){
          System.out.println("Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
          System.out.print("Enter password again:");
          password = inputs.nextLine();
      }
      System.out.println("password successfully captured");
      // loop unlid valid cellphone
      System.out.print("Enter SouthAfrican cellnumber: ");
      cellnumber = inputs.nextLine();
      while (!login.checkCellPhoneNumber(cellnumber)){
          System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
          System.out.print("Please enter valid cell phone number: ");
          cellnumber = inputs.nextLine();
      }
      System.out.println("Cell phine number successfully captured ");
      //finalising state submission and check message back 
      String registrationOutPut = login.registerUser( userName, password, cellnumber, firstName, lastName);
      System.out.println("\n" + registrationOutPut);
      
      System.out.println("ACCOUNT LOGIN");
      
      //collects login credentials
      System.out.print("Enter username: ");
      String loginuserName = inputs.nextLine();
      System.out.print("Enter password: ");
      String loginpassword = inputs.nextLine();
      
      //complete user validation process
      boolean isConnected = login.loginUser(loginuserName, loginpassword );
      String finalStatusMessage = login.returnLoginStatus(isConnected);
      
      System.out.println("\n"+ finalStatusMessage);
      inputs.close();
      
      }
      
      
       
       
       
    }

