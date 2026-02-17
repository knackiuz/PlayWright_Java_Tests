package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.apache.log4j.Logger;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

// POM class: 'Resizable' page
public class ResizablePage {
    private final Page page;
    private final Logger logger;

    private final Locator resizableBoxWithRestriction;
    private final Locator resizableBoxHandle;

    public ResizablePage(Page page){
        this.page = page;
        this.logger = Logger.getLogger(ResizablePage.class);

        this.resizableBoxWithRestriction = page.locator("#resizableBoxWithRestriction");
        this.resizableBoxHandle = resizableBoxWithRestriction.locator("span.react-resizable-handle");
    }

    public ResizablePage resizeBox(int width, int height){
        logger.info("Resizing box to: " + width + "x" + height);

        // Getting handle's coordinates
        com.microsoft.playwright.options.BoundingBox box = resizableBoxHandle.boundingBox();

        // Move handle
        page.mouse().move(box.x + box.width / 2, box.y + box.height / 2);
        page.mouse().down();
        page.mouse().move(box.x + width, box.y + height);
        page.mouse().up();;

        return this;
    }

    public ResizablePage verifyResizableBoxSize(int expectedWidth, int expectedHeight){
        String style = resizableBoxWithRestriction.getAttribute("style");
        assertThat(resizableBoxWithRestriction)
                .hasAttribute("style", "width: " + expectedWidth + "px; height: " + expectedHeight + "px;");
        logger.info("Size successfully verified: " + expectedWidth + "x" + expectedHeight);

        return this;
    }
}
