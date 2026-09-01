/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prog;

import java.util.Scanner;

/**
 *
 * @author letha
 */
public class Prog {

    public static void main(String[] args) {
        //Declarations
        String userName;
        int phoneNum;
        String passWord;
        //Inputs
        Scanner inputs = new Scanner(System.in);
        System.out.print("enter your UserName");
        userName = inputs.nextLine();
        System.out.print("Enter your phone number");
        phoneNum = inputs.nextInt();
        System.out.print("Enter your Password");
        passWord = inputs.nextLine();
    }
}
