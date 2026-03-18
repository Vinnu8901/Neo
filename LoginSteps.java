package stepdefinitions;

import base.BrowserFactory;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

public class LoginSteps {

    Page page;

    @Given("user launches browser")
    public void launch() {
        page = BrowserFactory.initBrowser("chromium");
        page.navigate("https://example.com");
    }

    @When("user enters credentials")
    public void login() {
        page.fill("#username", "admin");
        page.fill("#password", "password");
        page.click("#login");
    }

    @Then("user verifies login")
    public void verify() {
        System.out.println("Login successful");
    }
}
