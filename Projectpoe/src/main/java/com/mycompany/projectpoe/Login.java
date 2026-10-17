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
    public login(){
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
            
            if (character.isUpperCase(current)){
                hasCapital = true;
            }
            if(character.isDigit(current)){
                hasNumber = true;
            }
            if (!character.isLetterOrDigit(current)){
                hasSpecial = true;
            }
            return hasCapital && hasNumber && hasSpecial;
        }
        //check cellphone number if it is SouthAfrican
        public boolean checkCellPhoneNumber(String cellnumber){
            if (cellnumber== null){
                return false;
                String regex = "^\\+27\\d{9}$";
                return cellnumber.matches(regex);
            }
            
                
            }
        
    }
    
    
}
