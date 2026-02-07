package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BrowserWindowsPage {
    private final Page page;

    protected final Locator newTabButton;
    protected final Locator newWindowButton;
    protected final Locator newWindowMessage;

    public BrowserWindowsPage(Page page){
        this.page = page;
        this.newTabButton = page.locator("#tabButton");
        this.newWindowButton = page.locator("#windowButton");
        this.newWindowMessage = page.locator("#messageWindowButton");
    }

    // Click and check new tab in same method
    public BrowserWindowsPage clickNewTabAndCheckText(String expectedText){
        Page newPage = page.context().waitForPage(() -> {
            newTabButton.click();
        });

        newPage.waitForLoadState();

        Locator headingNewTab = newPage.locator("#sampleHeading");
        assertThat(headingNewTab).hasText(expectedText);

        newPage.close();

        return this;
    }

    // another approach - return new page
    public Page clickNewWindow(){
        Page newWindow = page.context().waitForPage(() -> {
            newWindowButton.click();
        });

        newWindow.waitForLoadState();
        return newWindow;
    }

    // Click and check New Window Message
    public BrowserWindowsPage clickNewWindowMessageAndCheckText(String expectedText){
        Page newPage = page.context().waitForPage(() -> {
            newWindowMessage.click();
        });

        newPage.waitForLoadState();

        String newWindowContent = newPage.locator("body").textContent();
        assertTrue(newWindowContent.equals(expectedText));

        return this;
    }
}
