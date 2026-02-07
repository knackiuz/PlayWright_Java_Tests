package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.apache.log4j.Logger;

import java.util.concurrent.atomic.AtomicBoolean;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class AlertsPage {
    private final Page page;

    protected final Locator alertButton;
    protected final Locator timerAlertButton;
    protected final Locator promtButton;
    protected final Locator promptResult;

    private final Logger logger;

    public AlertsPage(Page page){
        this.page = page;
        this.alertButton = page.locator("#alertButton");
        this.timerAlertButton = page.locator("#timerAlertButton");
        this.promtButton = page.locator("#promtButton");
        this.promptResult = page.locator("#promptResult");

        this.logger = Logger.getLogger(AlertsPage.class);
    }

    public AlertsPage clickAlertButtonAndCheckMessage(String expectedMessage){
        page.onceDialog(dialog -> {
            logger.info("Message in simple alert's dialog: " + dialog.message());
            assertEquals(expectedMessage, dialog.message());
            dialog.accept();
        });

        alertButton.click();

        return this;
    }

    // Waiting for timer alert using boolean variable and attempts
    public AlertsPage clickTimerAlertButtonAndCheckMessage(String expectedMessage){
        AtomicBoolean isProcessed = new AtomicBoolean(false);
        int attempts = 0;

        page.onceDialog(dialog -> {
            logger.info("Message in timer alert's dialog: " + dialog.message());
            assertEquals(expectedMessage, dialog.message());
            dialog.accept();
            isProcessed.set(true);
        });

        timerAlertButton.click();

        while (!isProcessed.get() && attempts < 100){
            page.waitForTimeout(100);
            attempts++;
        }

        if (!isProcessed.get()){
            throw new AssertionError("Alert did not appear within 10 seconds!");
        }

        return this;
    }

    public AlertsPage clickPromptButtonAndCheckResult(String textToEnter){
        AtomicBoolean isProcessed = new AtomicBoolean(false);
        int attempts = 0;

        page.onceDialog(dialog -> {
            logger.info("Message in the dialog: " + dialog.message());
            dialog.accept(textToEnter);
            isProcessed.set(true);
        });

        promtButton.click();

        if (!isProcessed.get() && attempts < 100) {
            page.waitForTimeout(100);
            attempts++;
        }

        if (!isProcessed.get()){
            logger.error("Prompt dialog did not appear within 10 seconds!");
            throw new AssertionError("Prompt dialog did not appear within 10 seconds!");
        }

        return this;
    }

    public AlertsPage checkPromptResult(String expectedPromptResult){
        logger.info("Prompt result: " + promptResult.textContent());
        assertThat(promptResult).hasText("You entered " + expectedPromptResult);
        return this;
    }
}
