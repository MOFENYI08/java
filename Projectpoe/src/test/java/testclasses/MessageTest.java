/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package testclasses;
 
import com.mycompany.projectpoe.Message;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author letha
 */
public class MessageTest {


    public MessageTest() {
    
    }
         //  Message length checks (Success & Failure)
    @Test
    public void testMessageLengthValidation() {
        // Success scenario
        Message validMsg = new Message();
        validMsg.setMessageCounter("Hello world, this is a short test message.");
        assertEquals("Message ready to send.", validMsg.validateMessageLength());

        // Failure scenario (Simulating text longer than 250 characters)
        Message longMsg = new Message();
        String overflowText = "A".repeat(255); // 255 characters long
        longMsg.setMessageCounter(overflowText);
       assertEquals("Message exceede 250 characters by5, please reduce size", longMsg.validateMessageLength());
    }

    //  Recipient field constraints
    @Test
    public void testRecipientCellFormatting() {
        // case success starts with '+' and within 10 characters limit
        Message validCell = new Message();
        validCell.setRecipient("+2782123");
        assertEquals("cell phone number successfully captured.", validCell.checkRecipientCell());

        //  missing international code or too long
        Message invalidCell = new Message();
        invalidCell.setRecipient("082123456789");
        assertEquals("cell phone is incorrectly formatted or does not contain and international code, please correct the number and try again.", invalidCell.checkRecipientCell());
    }

    //  Proper hash generation formatting (Matches Test Case 1 specification)
    @Test
    public void testCreateMessageHash() {
        // Supplying specific data to produce "00:0:HITONIGHT"
        // Message ID starts with "00", Message Number is 0, first word "HI", last word "TONIGHT"
        Message hashMsg = new Message("0012345678", 0, "+27123", "HI to everyone TONIGHT");
        String producedHash = hashMsg.createMessageHash();
        
        assertEquals("00:0:HITONIGHT", producedHash);
    }

    //  Message ID limits and creation status output
    @Test
    public void testMessageIDTracking() {
        Message msg = new Message();
        // Check structural limits
        assertTrue(msg.checkMessageID());
        
        // Verify output matches the status message syntax requested in image 6
        String expectedPrefix = "MessageID genrated:";
        assertTrue(msg.getMessageIDCreationStatus().startsWith(expectedPrefix));
    }

    //  Action routing conditions matching Image 6 statements
    @Test
    public void testSentMessageChoices() {
        Message testMsg = new Message();
        
        assertEquals("Message successfully sent.", testMsg.sentMessage(1));
        assertEquals("press 0 to delete the message", testMsg.sentMessage(2));
        assertEquals("Message successfully stored", testMsg.sentMessage(3));
    

    }
    
}
