package pageobjects;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PollVotingPage extends BasePage {

    public PollVotingPage(WebDriver driver) {
        super(driver);
    }

    private By participantInput() {
        return By.cssSelector("#d-newParticipantInput");
    }

    private By sendCannotAttendButton() {
        return By.cssSelector(".d-button.d-participateButton.d-large.d-secondaryButton");
    }

    public void performVotingAndSend(String name) {
        waitToBeVisible(participantInput());
        driver.findElement(participantInput()).clear();
        driver.findElement(participantInput()).sendKeys(name);
        driver.findElement(sendCannotAttendButton()).click();
    }

}
