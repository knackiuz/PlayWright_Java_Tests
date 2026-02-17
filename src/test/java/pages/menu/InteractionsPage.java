package pages.menu;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pages.InteractionsDroppablePage;
import pages.ResizablePage;

// POM class for 'Interactions' page in right menu
public class InteractionsPage {
    private final Page page;

    private final Locator droppableMenu;
    private final Locator resizableMenu;

    public InteractionsPage(Page page){
        this.page = page;
        this.droppableMenu = page.getByText("Droppable");
        this.resizableMenu = page.getByText("Resizable");
    }

    public InteractionsDroppablePage selectDroppableMenu(){
        droppableMenu.click();
        return new InteractionsDroppablePage(page);
    }

    public ResizablePage selectResizableMenu(){
        resizableMenu.click();
        return new ResizablePage(page);
    }
}
