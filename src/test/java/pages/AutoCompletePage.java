package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.apache.log4j.Logger;

import java.util.List;


public class AutoCompletePage {
    private final Page page;
    private final Logger logger;

    private final Locator autoCompleteMultipleInput;
    private final Locator autoCompleteDropDown;
    private final Locator multiValueContainer;


    public AutoCompletePage(Page page){
        this.page = page;
        this.logger = Logger.getLogger(AutoCompletePage.class);
        this.autoCompleteMultipleInput = page.locator("#autoCompleteMultipleInput");
        this.autoCompleteDropDown = page.locator("[id*='react-select-2-option-']");
        this.multiValueContainer = page.locator(".auto-complete__multi-value__label");
    }

    public AutoCompletePage typeAndSelectColor (String colorName) {
        String partOfColor = colorName.substring(0, 2);
        logger.info("Typing: " + partOfColor);
        autoCompleteMultipleInput.pressSequentially(partOfColor);
        autoCompleteDropDown.filter(new Locator.FilterOptions().setHasText(colorName)).click();
        logger.info("Selected color: " + colorName);

        return this;
    }

    public List<String> getSelectedColors(){
        return multiValueContainer.allTextContents();
    }
}
