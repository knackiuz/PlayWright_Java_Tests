package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

// POM class: 'Alerts, Frame & Windows' page
public class AlertsFrameWindowsPage {
    private final Page page;

    private final Locator framesMenu;
    private final Locator browserWindowsMenu;
    private final Locator alertsMenu;

    public AlertsFrameWindowsPage(Page page){
        this.page = page;
        this.framesMenu = page.getByText("Frames", new Page.GetByTextOptions().setExact(true)); // get exact 'Frame', not 'Nested Frames'
        this.browserWindowsMenu = page.getByText("Browser Windows");
        this.alertsMenu = page.getByText("Alerts", new Page.GetByTextOptions().setExact(true));
    }

    public FramesPage selectFramesMenu(){
        framesMenu.click();
        return new FramesPage(page);
    }

    public BrowserWindowsPage selectBrowserWindowsMenu(){
        browserWindowsMenu.click();
        return new BrowserWindowsPage(page);
    }

    public AlertsPage selectAlertsMenu(){
        alertsMenu.click();
        return new AlertsPage(page);
    }
}
