package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import org.apache.log4j.Logger;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

// POM class: 'Interaction Droppable' page
public class InteractionsDroppablePage {
    private final Page page;
    private final Logger logger;

    private final Locator draggable;
    private final Locator droppable;

    public InteractionsDroppablePage(Page page){
        this.page = page;
        this.logger = Logger.getLogger(InteractionsDroppablePage.class);

        this.draggable = page.locator("#simpleDropContainer").locator("#draggable");
        this.droppable = page.locator("#simpleDropContainer").locator("#droppable");
    }

    public InteractionsDroppablePage dragAndDropElement(){
        logger.info("Performing drag and drop action");
        page.waitForTimeout(3000);
        draggable.dragTo(droppable, new Locator.DragToOptions().setForce(true).setSteps(10));

        return this;
    }

    public InteractionsDroppablePage dragAndDropElementMouse(){
        logger.info("Wait for ads");
        page.waitForTimeout(3000);

        logger.info("Performing drag and drop action using mouse");
        draggable.hover();
        page.mouse().down();
        droppable.hover();
        page.mouse().up();

        return this;
    }

    public InteractionsDroppablePage verifyDropSuccess(){
        assertThat(droppable).hasText("Dropped!");
        assertThat(droppable).hasClass("drop-box ui-droppable ui-state-highlight");

        return this;
    }
}
