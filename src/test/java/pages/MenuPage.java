package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.apache.log4j.Logger;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

// POM class: 'Menu' page
public class MenuPage {
    private final Page page;
    private final Logger logger;

    private final Locator mainItem2;
    private final Locator subSubList;
    private final Locator subSubItem1;


    public MenuPage(Page page){
        this.page = page;
        this.logger = Logger.getLogger(MenuPage.class);

        this.mainItem2 = page.getByText("Main Item 2");
        this.subSubList = page.getByText("SUB SUB LIST »");
        this.subSubItem1 = page.getByText("Sub Sub Item 1");
    }

    public MenuPage hoverMainItem2(){
        logger.info("Hovering over Main Item 2");
        mainItem2.hover();
        return this;
    }

    public MenuPage hoverSubSubList(){
        logger.info("Hovering over SUB SUB LIST »");
        subSubList.hover();
        return this;
    }

    public MenuPage clickSubSubItem1(){
        logger.info("Clicking on Sub Sub Item 1");
        subSubItem1.click();
        return this;
    }

    public MenuPage checkSubSubItem1IsVisible(){
        assertThat(subSubItem1).isVisible();
        return this;
    }
}
