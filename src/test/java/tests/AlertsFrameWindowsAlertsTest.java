package tests;

import base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AlertsFrameWindowsAlertsTest extends BaseTest {
    @Test
    @DisplayName("Test for Alerts: check simple alert")
    public void clickButtonToSeeAlert(){
        String expectedMessage = "You clicked a button";

        mainPage
                .navigate()
                .verifyMainPageIsLoaded()
                .clickOnAlertsFrameWindowsCard()
                .selectAlertsMenu()
                .clickAlertButtonAndCheckMessage(expectedMessage);

        //page.pause();
    }

    @Test
    @DisplayName("Test for Alerts: check timer alert")
    public void clickTimerAlertButton(){
        String expectedMessage = "This alert appeared after 5 seconds";

        mainPage
                .navigate()
                .verifyMainPageIsLoaded()
                .clickOnAlertsFrameWindowsCard()
                .selectAlertsMenu()
                .clickTimerAlertButtonAndCheckMessage(expectedMessage);

        //page.pause();
    }

    @Test
    @DisplayName("Test for Alerts: check prompt alert, enter text and check result")
    public void clickPromptAlertButton(){
        String textToEnter = "Test User";

        mainPage
                .navigate()
                .verifyMainPageIsLoaded()
                .clickOnAlertsFrameWindowsCard()
                .selectAlertsMenu()
                .clickPromptButtonAndCheckResult(textToEnter)
                .checkPromptResult(textToEnter);

        //page.pause();
    }
}
