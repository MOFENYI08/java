/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package testclasses;

import com.mycompany.projectpoe.Login;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author letha
 */
public class testlogin {
    
    public testlogin() {
      }

    
    // ASSERTIONS FOR BOOLEAN METHODS (assertTrue / assertFalse)
    

    @Test
    public void testUsernameCorrectlyFormatted() {
        Login login = new Login();
        // Test Data: "kyl_1" -> Should return true
        assertTrue(login.checkUserName("kyl_1"));
    }

    @Test
    public void testUsernameIncorrectlyFormatted() {
        Login login = new Login();
        // Test Data: "kyle!!!!!!" -> Should return false
        assertFalse(login.checkUserName("kyle!!!!!!"));
    }

    @Test
    public void testPasswordMeetsComplexityRequirements() {
        Login login = new Login();
        // Test Data: "Ch&&sec@ke99!" -> Should return true
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void testPasswordDoesNotMeetComplexityRequirements() {
        Login login = new Login();
        // Test Data: "password" -> Should return false
        assertFalse(login.checkPasswordComplexity("password"));
    }

    @Test
    public void testCellPhoneNumberCorrectlyFormatted() {
        Login login = new Login();
        // Test Data: "+27838968976" -> Should return true
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }

    @Test
    public void testCellPhoneNumberIncorrectlyFormatted() {
        Login login = new Login();
        // Test Data: "08966553" -> Should return false
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }

    @Test
    public void testLoginSuccessful() {
        Login login = new Login();
        // By default, constructor sets registeredUserName = "userName" and registeredpassword = "password"
        assertTrue(login.loginUser("userName", "password"));
    }

    @Test
    public void testLoginFailed() {
        Login login = new Login();
        assertFalse(login.loginUser("wrongUser", "wrongPass"));
    }

  
    //  ASSERTIONS FOR STRING RESPONSES (assertEquals)
    

    @Test
    public void testRegisterUsernameIncorrectMessage() {
        Login login = new Login();
        String expectedMessage = "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        
        // Testing registration with incorrect username format
        String actualMessage = login.registerUser("kyle!!!!!!", "Ch&&sec@ke99!", "+27838968976", "John", "Doe");
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testRegisterPasswordIncorrectMessage() {
        Login login = new Login();
        String expectedMessage = "Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number and a special character.";
        
        String actualMessage = login.registerUser("kyl_1", "password", "+27838968976", "John", "Doe");
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testRegisterCellPhoneIncorrectMessage() {
        Login login = new Login();
        String expectedMessage = "Cell number is incorrectly formatted or does not contain an international code, please correct the number and try again.";
        
        String actualMessage = login.registerUser("kyl_1", "Ch&&sec@ke99!", "08966553", "John", "Doe");
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testReturnLoginStatusMessage() {
        Login login = new Login();
        // Testing greeting response message status
        String expectedMessage = "WelcomefirstName,lastName it is geat to see you again";
        String actualMessage = login.returnLoginStatus(true);
        
        assertEquals(expectedMessage, actualMessage);
    }
    
}



