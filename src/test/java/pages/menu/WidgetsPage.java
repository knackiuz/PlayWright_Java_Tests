package pages.menu;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pages.AutoCompletePage;
import pages.MenuPage;
import pages.SliderPage;

// POM class for 'Widgets' page in right menu
public class WidgetsPage {
    private final Page page;

    private final Locator autoCompleteMenu;
    private final Locator sliderMenu;
    private final Locator menuMenu;

    public WidgetsPage(Page page){
        this.page = page;
        this.autoCompleteMenu = page.getByText("Auto Complete");
        this.sliderMenu = page.getByText("Slider");
        this.menuMenu = page.getByText("Menu", new Page.GetByTextOptions().setExact(true));
    }

    public AutoCompletePage selectAutoCompleteMenu(){
        autoCompleteMenu.click();
        return new AutoCompletePage(page);
    }

    public SliderPage selectSliderMenu(){
        sliderMenu.click();
        return new SliderPage(page);
    }

    public MenuPage selectMenuMenu(){
        menuMenu.click();
        return new MenuPage(page);
    }
}
