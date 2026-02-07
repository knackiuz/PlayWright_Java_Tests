package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

// POM class: Check Box page
public class CheckBoxPage {
    private final Page page;

    protected final Locator expandAllButton;
    protected final Locator collapseAllButton;
    protected final Locator homeCheckBox;
    protected  final Locator desktopCheckbox;

    public CheckBoxPage(Page page){
        this.page = page;
        this.expandAllButton = page.getByLabel("Expand all");
        this.collapseAllButton = page.getByLabel("Collapse all");
        this.homeCheckBox = page.locator(".rct-text").getByText("Home");
        this.desktopCheckbox = page.locator(".rct-text").getByText("Desktop");
    }

    public CheckBoxPage clickExpandAllButton(){
        expandAllButton.click();
        return this;
    }

    public CheckBoxPage clickCollapseAllButton(){
        collapseAllButton.click();
        return this;
    }

    public CheckBoxPage clickHomeCheckBox(){
        homeCheckBox.click();
        return this;
    }

    public CheckBoxPage verifyHomeIsSelected(){
        assertThat(homeCheckBox).isChecked();
        return this;
    }

    public CheckBoxPage verifyDesktopCheckBoxIsVisible(){
        assertThat(desktopCheckbox).isVisible();
        return this;
    }

    public CheckBoxPage verifyDesktopCheckBoxIsHidden(){
        assertThat(desktopCheckbox).isHidden();
        return this;
    }
}
