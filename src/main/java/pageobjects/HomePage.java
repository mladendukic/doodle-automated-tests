package pageobjects;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By registerLink() {
        return By.cssSelector(".ico-register");
    }

    public void clickRegisterLink() {
        driver.findElement(registerLink()).click();
    }
}
