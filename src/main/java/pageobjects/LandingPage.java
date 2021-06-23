package pageobjects;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage {

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    private By acceptAllCookiesButton() {
        return By.id("onetrust-accept-btn-handler");
    }

    public void acceptAllCookies() {
        waitToBeVisible(acceptAllCookiesButton());
        driver.findElement(acceptAllCookiesButton()).click();
    }
}
