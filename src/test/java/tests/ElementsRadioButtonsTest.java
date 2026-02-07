package tests;

import base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ElementsRadioButtonsTest extends BaseTest {
    @Test
    @DisplayName("Test for Radio buttons: select, verify and check that not enabled")
    public void TestRadioButton(){
        mainPage
                .navigate()                         // Navigate to Main page
                .verifyMainPageIsLoaded()           // Verify that page is loaded
                .clickOnElementsCard()              // Click on Card 'Elements'
                .selectRadioButtonMenu()            // Select menu 'Text Box'
                .clickYesRadioButton()              // Click radio button 'Yes'
                .verifyYesIsSelected()              // Verify that the radio button is selected
                .verifyImpressiveIsNotSelected()    // Verify that radio button 'Impressive' is not selected
                .clickImpressiveRadioButton()       // Click radio button 'Impressive'
                .verifyImpressiveIsSelected()       // Verify that the radio button is selected
                .verifyYesIsNotSelected()           // Verify that radio button 'Yes' is not selected
                .verifyNoIsDisabled();              // Verify that radio button 'No' is disabled

        //page.pause();
    }
}
