package tests;

import base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AlertsFrameWindowsFramesTest extends BaseTest {
    @Test
    @DisplayName("Test for Frames: check text in a frame")
    public void TestFrames(){
        String headingText = "This is a sample page";

        mainPage
                .navigate()                             // Navigate to Main page
                .verifyMainPageIsLoaded()               // Verify that page is loaded
                .clickOnAlertsFrameWindowsCard()        // Click on Card 'Alerts, Frame & Windows'
                .selectFramesMenu()                     // Select menu 'Frames'
                .verifyHeadingFrame1(headingText)       // Verify that frame1 has correct heading
                .verifyHeadingFrame2(headingText);      // Verify that frame2 has correct heading

        //page.pause();
    }
}
