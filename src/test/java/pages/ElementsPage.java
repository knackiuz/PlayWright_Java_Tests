package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

// POM class: Elements page
public class ElementsPage {
    private final Page page;
    private final Locator textBoxMenu;
    private final Locator checkBoxMenu;
    private final Locator radioButtonMenu;

    public ElementsPage(Page page){
        this.page = page;
        this.textBoxMenu = page.getByText("Text Box");
        this.checkBoxMenu = page.getByText("Check Box");
        this.radioButtonMenu = page.getByText("Radio Button");
    }

    public TextBoxPage selectTextBoxMenu(){
        textBoxMenu.click();
        return new TextBoxPage(page);
    }

    public CheckBoxPage selectCheckBoxMenu(){
        checkBoxMenu.click();;
        return new CheckBoxPage(page);
    }

    public RadioButtonPage selectRadioButtonMenu(){
        radioButtonMenu.click();
        return new RadioButtonPage(page);
    }
}
