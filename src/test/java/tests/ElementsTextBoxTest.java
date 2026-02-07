package tests;

import base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class ElementsTextBoxTest extends BaseTest {
    @Test
    @DisplayName("Test for Edit fields: enter data, confirm and check result")
    public void testTextBox() {
        // Data for Edit fields
        String fullName = "Test User";
        String email = "test@mail.com";
        String currentAddress = "Riga, Brivibas iela 1";
        String permanentAddress = "Riga, Terbatas iela 1";

        HashMap <String, String> result = mainPage
                .navigate()                         // Navigate to Main page
                .verifyMainPageIsLoaded()           // Verify that page is loaded
                .clickOnElementsCard()              // Click on Card 'Elements'
                .selectTextBoxMenu()                // Select menu 'Text Box'
                .fillForm(                          //Enter values into the fields
                        fullName,
                        email,
                        currentAddress,
                        permanentAddress)
                .clickSubmitButton()                // Click button 'Submit'
                .getTextFromOutputTextBox();        // Get data from result's field

        // Check the result
        assertEquals("Name:" + fullName, result.get("name"));
        assertEquals("Email:" + email, result.get("email"));
        assertEquals("Current Address :" + currentAddress + " ", result.get("currentAddress"));
        assertEquals("Permananet Address :" + permanentAddress, result.get("permanentAddress"));

        //page.pause();
    }
}
