package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

// POM class for 'Widgets' page
public class WidgetsPage {
    private final Page page;

    private final Locator autoCompleteMenu;

    public WidgetsPage(Page page){
        this.page = page;
        this.autoCompleteMenu = page.getByText("Auto Complete");
    }

    public AutoCompletePage selectAutoCompleteMenu(){
        autoCompleteMenu.click();
        return new AutoCompletePage(page);
    }
}
