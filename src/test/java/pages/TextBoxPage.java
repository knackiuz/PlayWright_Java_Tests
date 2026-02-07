package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.HashMap;

// POM class: Text Box page
public class TextBoxPage {
    private final Page page;

    protected final Locator fullNameTextBox;
    protected final Locator emailTextBox;
    protected final Locator currentAddressTextBox;
    protected final Locator permanentAddressTextBox;

    protected final Locator submitButton;

    protected final Locator outputTextBox;

    public TextBoxPage(Page page){
        this.page = page;
        this.fullNameTextBox = page.locator("#userName");
        this.emailTextBox = page.locator("#userEmail");
        this.currentAddressTextBox = page.locator("#currentAddress");
        this.permanentAddressTextBox = page.locator("#permanentAddress");
        this.submitButton = page.locator("#submit");
        this.outputTextBox = page.locator("#output");
    }

    public TextBoxPage fillForm(String fullName, String email, String currentAddress, String permanentAddress){
        fullNameTextBox.fill(fullName);
        emailTextBox.fill(email);
        currentAddressTextBox.fill(currentAddress);
        permanentAddressTextBox.fill(permanentAddress);
        return this;
    }

    public TextBoxPage clickSubmitButton(){
        submitButton.click();
        return this;
    }

    public HashMap<String, String> getTextFromOutputTextBox(){
        HashMap<String, String> result = new HashMap<>();
        result.put("name" , outputTextBox.locator("#name").textContent());
        result.put("email" , outputTextBox.locator("#email").textContent());
        result.put("currentAddress" , outputTextBox.locator("#currentAddress").textContent());
        result.put("permanentAddress" , outputTextBox.locator("#permanentAddress").textContent());
        return result;
    }
}
