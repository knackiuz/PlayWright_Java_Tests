package tests;

import base.BaseTest;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class AlertsFrameWindowsBrowserWindowsTest extends BaseTest {
    @Test
    @DisplayName("Test for Modal Dialogs: check new tab")
    public void TestModalDialogs(){

        String expectedText = "This is a sample page";

        mainPage
                .navigate()
                .verifyMainPageIsLoaded()
                .clickOnAlertsFrameWindowsCard()
                .selectBrowserWindowsMenu()
                .clickNewTabAndCheckText(expectedText);

        //page.pause();
    }

    @Test
    @DisplayName("Test for Modal Dialogs: check new window")
    public void TestNewWindow(){

        String expectedText = "This is a sample page";

        Page newWindow = mainPage
                .navigate()
                .verifyMainPageIsLoaded()
                .clickOnAlertsFrameWindowsCard()
                .selectBrowserWindowsMenu()
                .clickNewWindow();

        assertThat(newWindow.locator("#sampleHeading")).hasText(expectedText);

        //page.pause();
    }

    @Test
    @DisplayName("Test for Modal Dialogs: check new window message")
    public void TestNewWindowMessage(){
        String expectedText =
                "Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.";

        mainPage
                .navigate()
                .verifyMainPageIsLoaded()
                .clickOnAlertsFrameWindowsCard()
                .selectBrowserWindowsMenu()
                .clickNewWindowMessageAndCheckText(expectedText);

        //page.pause();
    }
}
