package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

// POM class: Main page
public class MainPage {
    private final Page page;
    private final Locator homeBanner;
    private final Locator elementsCard;
    private final Locator alertsFrameWindowsMCard;
    private final Locator widgetsCard;

    public MainPage(Page page){
        this.page = page;
        this.homeBanner = page.locator(".banner-image");
        this.elementsCard = page.locator(".card").filter(new Locator.FilterOptions().setHasText("Elements"));
        this.alertsFrameWindowsMCard = page.getByText("Alerts, Frame & Windows");
        this.widgetsCard = page.getByText("Widgets");
    }

    // Navigate
    public MainPage navigate(){
        page.navigate("");
        return this;
    }

    public MainPage verifyMainPageIsLoaded(){
        assertThat(homeBanner).isVisible(); // Assert that Main page is loaded
        return this;
    }

    // Go to Elements
    public ElementsPage clickOnElementsCard(){
        elementsCard.click();
        return new ElementsPage(page);
    }

    // Go to 'Alerts, Frame & Windows'
    public AlertsFrameWindowsPage clickOnAlertsFrameWindowsCard(){
        alertsFrameWindowsMCard.click();
        return new AlertsFrameWindowsPage(page);
    }

    // Go to 'Widgets'
    public WidgetsPage clickWidgetsCard(){
        widgetsCard.click();
        return new WidgetsPage(page);
    }
}
