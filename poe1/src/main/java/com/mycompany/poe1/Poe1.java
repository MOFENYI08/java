/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe1;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author letha
 */
public class Poe1 {

    public static void main(String[] args) {
        //Declarations
        String userName;
        String password;
        String phoneNum;
       
        //inputs
        Scanner inputs = new Scanner(System.in);
        System.out.print("Enter your username: ");
        userName = inputs.nextLine();
        System.out.print("Enter your password: ");
        password = inputs.nextLine();
        System.out.print("Enter your number phone: ");
        phoneNum = inputs.nextLine();
        
        //if statements
        // checking user name
        if (userName.contains("_") && userName.length()<=5){
            System.out.println("username successfully capture");
        }else{
            System.out.println("username is not correctly formmeted, please ensure that your username contains an underscore and there is no more than five characters in length ");
        }
        //checking password
        if (password.length() >= 8 && password.matches(".*[A-Z].*") && 

            password.matches(".*[0-9].*") && password.contains("@")) {
            System.out.println("Password succcessfully captured");
        } else {
            System.out.println("Password is not correctly formatted, please ensure that the password contains at least eisght characters , a capital letter, a number and a special character");
        }
        //checking phone number 
        if (phoneNum.startsWith("+27") && phoneNum.length() == 12) {
        System.out.println(" cell phone number is successfully added");
        }else {
            System.out.println("cell phone number incorrectly formetted or does not contain international code");
            }
        inputs.close();
        
        
        
        
      
    }
}




 class Login{
    //instance variables to store registreted user data
    private String userName;
    private String passWord;
    private String phoneNum;
    private String firstName;
    private String lastName;
    //Constructors
    public Login(){
        this.userName= "";
        this.passWord ="";
        this.phoneNum="";
        this.firstName ="";
        this.lastName ="";
    }
        //setters used for redistration
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
     //checking conditions
    public boolean checkUserName(){
    return this.userName.contains("_") && this.userName.length()<=5;
    }
    public boolean checkPasswordComplexity(){
        if(this.passWord.length()<8) return false;
        boolean hasUppercase = !this.passWord.equals(this.passWord.toLowerCase());
        boolean hasDigit =this.passWord.matches(".*\\d.*");
        boolean hasSpecial = this.passWord.matches("@");
        return hasUppercase && hasDigit && hasSpecial;
    }
      public boolean checkCellPhoneNumber() {
        if (phoneNum.startsWith("+27") && phoneNum.length() == 12) {
            return true;
        } else {
            return false;
        }
        }
        public String registerUser(){
        
            if(!checkUserName()){
                return"Username is incorrectly formetted";
            }
            if (!checkPasswordComplexity()){
                return"password does not meet the complexity requirements";
            }
            if(!checkCellPhoneNumber()){
                return"Cellphone number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
                }
              return "Registration successful";
        }
 
 
            public boolean loginUser(String entereduserName, String enteredpassword){
                return this.userName.equals(entereduserName)&& this.passWord.equals(enteredpassword);
            }
 
             public String returnLoginStatus(boolean isLoggedIn) {
        if (isLoggedIn) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you.";
        } else {
            return "Username or password incorrect, please try again.";
        }
             
    }
}
    
             
 

 

            
  