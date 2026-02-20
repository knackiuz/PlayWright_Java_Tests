package tests;

import base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("elements")
public class ElementsCheckBoxTest extends BaseTest {
    @Test
    @DisplayName("Test for check box: select, expand and collapse all")
    public void TestCheckBox(){
        mainPage
                .navigate()                             // Navigate to Main page
                .verifyMainPageIsLoaded()               // Verify that page is loaded
                .clickOnElementsCard()                  // Click on Card 'Elements'
                .selectCheckBoxMenu()                   // Select menu 'Check Box'
                .verifyDesktopCheckBoxIsHidden()        // Verify that check box 'Desktop' is hidden
                .clickExpandCollapseHomeButton()        // Click 'Expand Home'
                .clickHomeCheckBox()                    // Click check box 'Home'
                .verifyHomeIsSelected()                 // Verify that check box 'Home' is selected
                .verifyDesktopCheckBoxIsVisible()       // Verify that check box 'Desktop' is visible
                .clickExpandCollapseHomeButton()        // Click 'Collapse Home'
                .verifyDesktopCheckBoxIsHidden();       // Verify that check box 'Desktop' is hidden

        //page.pause();
    }
}
