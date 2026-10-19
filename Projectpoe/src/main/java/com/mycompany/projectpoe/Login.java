/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectpoe;

/**
 *
 * @author letha
 */
public class Login {
    //storing of registration 
    private String registeredUserName;
    private String registeredpassword;
    private String registeredcellnumber;
    private String registeredfirstName;
    private String registeredlastName;
    //Constructors
    public Login(){
       this.registeredUserName = "userName";
       this.registeredpassword = "password";
       this.registeredcellnumber = "cellnumber";
       this.registeredfirstName = "lastName";
       this.registeredlastName = "lastName";
    }

    //Check if username contains underscore and is no more than 5 characters
    public boolean checkUserName(String userName){
        return userName != null 
        && userName.contains("_") && userName.length()<=5;
    }
    //Check password complexity
    public boolean checkPasswordComplexity(String password){
        if (password == null || password.length() < 8){
            return false;
        }
        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;
    
        
        for (int i = 0; i < password.length(); i++){
            char current = password.charAt(i);
            
            if (Character.isUpperCase(current)){
                hasCapital = true;
            }
        
        
            if(Character.isDigit(current)){
                hasNumber = true;
            }
            if (!Character.isLetterOrDigit(current)){
                hasSpecial = true;
            
            }
        }
        
            return hasCapital && hasNumber && hasSpecial;
        }
    

        //check cellphone number if it is SouthAfrican
        public boolean checkCellPhoneNumber(String cellnumber){
            if (cellnumber== null){
                return false;
            }
                String regex = "^\\+27\\d{9}$";
                return cellnumber.matches(regex);
        
            }
        //process registration and returns system notification
        public String registerUser(String userName, String password, String cellnumber, String firstName, String lastName){
            if (!checkUserName(userName)){
                return "userName is not correctly formatted, please ensure that your username contains underscore and is no more than five characters i length";
            }
            if (!checkPasswordComplexity(password)){
                return "Password is not correctly formatted,please ensure that the password contains at least eight characters, a capital letter, a number and a special character.";
            }
            if (!checkCellPhoneNumber(cellnumber)){
                return "Cell phone number incorrectly formatted or does not contain international code.";
            }
            //save registration parameters
            this.registeredUserName = userName;
            this.registeredpassword = password;
            this.registeredcellnumber= cellnumber;
            this.registeredfirstName = firstName;
            this.registeredlastName = lastName;
            return "password successfully captured";
        }
        //confirms authentication
        public boolean loginUser(String userName, String password){
            return this.registeredUserName != null
                    && this.registeredUserName.equals(userName) && this.registeredpassword.equals(password);
        }
        // A greeting test
        public String returnLoginStatus(boolean loggedIn){
            if(loggedIn){
                return"Welcome" + this.registeredfirstName + "," + this.registeredlastName+" it is geat to see you again";
            }else{
                return "userName or password incorrect, please try again.";
            }
            }
        }
            
        
    

    

        
    
    
    

