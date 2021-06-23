package pageobjects;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PollConfirmationPage extends BasePage {

    public PollConfirmationPage(WebDriver driver) {
        super(driver);
    }

    private By successMessage() {
        return By.cssSelector(".d-premiumHookNag");
    }

    public String getConfirmationTitle() {
        waitToBeVisible(successMessage());
        return driver.findElement(successMessage()).getText();
    }

}
