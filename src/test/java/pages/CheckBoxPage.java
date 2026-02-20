package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.apache.log4j.Logger;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

// POM class: 'Check Box' page
public class CheckBoxPage {
    private final Page page;
    private final Logger logger;

    protected final Locator expandCollapseHomeButton;
    protected final Locator collapseAllButton;
    protected final Locator homeCheckBox;
    protected  final Locator desktopCheckbox;

    public CheckBoxPage(Page page){
        this.page = page;
        this.logger = Logger.getLogger(CheckBoxPage.class);
        this.expandCollapseHomeButton = page.locator("div:has(span[title='Home']) > span.rc-tree-switcher");
        this.collapseAllButton = page.getByLabel("Collapse all");
        this.homeCheckBox = page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("Select Home"));
        this.desktopCheckbox = page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("Select Desktop"));
    }

    public CheckBoxPage clickExpandCollapseHomeButton(){
        logger.info("Click 'Expand/Collapse Home'");
        expandCollapseHomeButton.click();
        return this;
    }

    public CheckBoxPage clickHomeCheckBox(){
        logger.info("Click 'Home' checkbox");
        homeCheckBox.click();
        return this;
    }

    public CheckBoxPage verifyHomeIsSelected(){
        logger.info("Verify: 'Home' is checked");
        assertThat(homeCheckBox).isChecked();
        return this;
    }

    public CheckBoxPage verifyDesktopCheckBoxIsVisible(){
        logger.info("Verify: 'Desktop' is visible");
        assertThat(desktopCheckbox).isVisible();
        return this;
    }

    public CheckBoxPage verifyDesktopCheckBoxIsHidden(){
        logger.info("Verify: 'Desktop' is hidden");
        assertThat(desktopCheckbox).isHidden();
        return this;
    }
}
