package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

// POM class for 'Widgets' page
public class WidgetsPage {
    private final Page page;

    private final Locator autoCompleteMenu;
    private final Locator sliderMenu;

    public WidgetsPage(Page page){
        this.page = page;
        this.autoCompleteMenu = page.getByText("Auto Complete");
        this.sliderMenu = page.getByText("Slider");
    }

    public AutoCompletePage selectAutoCompleteMenu(){
        autoCompleteMenu.click();
        return new AutoCompletePage(page);
    }

    public SliderPage selectSliderMenu(){
        sliderMenu.click();
        return new SliderPage(page);
    }
}
