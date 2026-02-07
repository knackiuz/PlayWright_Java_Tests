package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

// POM class: Radio Button page
public class RadioButtonPage {
    private final Page page;

    protected final Locator yesRadioButton;
    protected final Locator impressiveRadioButton;
    protected final Locator noRadioButton;

    public RadioButtonPage(Page page){
        this.page = page;
        this.yesRadioButton = page.locator("label[for='yesRadio']");
        this.impressiveRadioButton = page.locator("label[for='impressiveRadio']");
        this.noRadioButton = page.locator("label[for='noRadio']");
    }

    public RadioButtonPage clickYesRadioButton(){
        yesRadioButton.click();
        return this;
    }

    public RadioButtonPage verifyYesIsSelected(){
        assertThat(yesRadioButton).isChecked();
        return this;
    }

    public RadioButtonPage verifyYesIsNotSelected(){
        assertThat(yesRadioButton).not().isChecked();
        return this;
    }

    public RadioButtonPage clickImpressiveRadioButton(){
        impressiveRadioButton.click();
        return this;
    }

    public RadioButtonPage verifyImpressiveIsSelected(){
        assertThat(impressiveRadioButton).isChecked();
        return this;
    }

    public RadioButtonPage verifyImpressiveIsNotSelected(){
        assertThat(impressiveRadioButton).not().isChecked();
        return this;
    }

    public RadioButtonPage verifyNoIsDisabled(){
        assertThat(noRadioButton).isDisabled();
        return this;
    }
}
