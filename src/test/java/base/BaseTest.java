package base;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.MainPage;

// Base class
public class BaseTest {
    public final String url = "https://demoqa.com/";

    protected static Playwright playwright;
    protected static Browser browser;

    protected BrowserContext browserContext;
    protected Page page;

    protected MainPage mainPage;

    @BeforeAll
    static void launchBrowser(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
    }

    @AfterAll
    static void closeBrowser(){
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }

    @BeforeEach
    void setup(){
        browserContext = browser.newContext(new Browser.NewContextOptions()
                .setBaseURL(url)
                .setViewportSize(1920, 1080));
        page = browserContext.newPage();
        mainPage = new MainPage(page);
    }

    @AfterEach
    void tearDown(){
        if (browserContext != null) browserContext.close();
    }
}
