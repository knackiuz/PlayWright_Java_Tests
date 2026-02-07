package tests;

import base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ElementsCheckBoxTest extends BaseTest {
    @Test
    @DisplayName("Test for check box: select, expand and collapse all")
    public void TestCheckBox(){
        mainPage
                .navigate()                             // Navigate to Main page
                .verifyMainPageIsLoaded()               // Verify that page is loaded
                .clickOnElementsCard()                  // Click on Card 'Elements'
                .selectCheckBoxMenu()                   // Select menu 'Check Box'
                .clickExpandAllButton()                 // Click 'Expand All'
                .verifyDesktopCheckBoxIsVisible()       // Verify that check box 'Desktop' is visible
                .clickHomeCheckBox()                    // Click check box 'Home'
                .verifyHomeIsSelected()                 // Verify that check box 'Home' is selected
                .clickCollapseAllButton()               // Click 'Collapse All'
                .verifyDesktopCheckBoxIsHidden();       // Verify that check box 'Desktop' is hidden

        //page.pause();
    }
}
