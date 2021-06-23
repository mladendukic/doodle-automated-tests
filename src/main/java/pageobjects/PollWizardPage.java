package pageobjects;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PollWizardPage extends BasePage {

    public PollWizardPage(WebDriver driver) {
        super(driver);
    }

    private By pollWizardForm() {
        return By.cssSelector("#d-wizardGeneralInformationView");
    }

    private By pollTitleInput() {
        return By.cssSelector("#d-pollTitle");
    }

    private By pollLocationInput() {
        return By.cssSelector("#d-pollLocation");
    }

    private By pollDescriptionInput() {
        return By.cssSelector("#d-pollDescription");
    }

    private By pollContinueButton() {
        return By.cssSelector(".d-button.d-nextButton.d-send.d-large.d-primaryButton");
    }

    private By wizardStepTitle(String stepNo) {
        return By.xpath("//h1[text()='Step " + stepNo + " of 4']");
    }

    private By nextWeekButton() {
        return By.cssSelector(".d-button.d-nextWeek.d-medium.d-promotedButton");
    }

    private By daysOfWeek() {
        return By.cssSelector(".fc-row.fc-widget-header div div");
    }

    private By initiatorNameInput() {
        return By.cssSelector("#d-initiatorName");
    }

    private By initiatorEmailInput() {
        return By.cssSelector("#d-initiatorEmail");
    }

    private By inviteParticipants() {
        return By.xpath("//h1[text()='Invite participants']");
    }

    private By pollTitle() {
        return By.cssSelector(".d-pollTitle");
    }

    private By pollLocation() {
       return By.cssSelector(".d-locationName");
    }

    private By pollDescription() {
        return By.cssSelector(".d-contentContainer");
    }

    private By pollLinkToCopy() {
        return By.cssSelector(".d-pollLinkToCopy input");
    }

    public boolean isPollWizardDisplayed() {
        waitToBeVisible(pollWizardForm());
        return driver.findElement(pollWizardForm()).isDisplayed();
    }

    public void enterOccasion(String title, String location, String description) {
        driver.findElement(pollTitleInput()).sendKeys(title);
        driver.findElement(pollLocationInput()).sendKeys(location);
        driver.findElement(pollDescriptionInput()).sendKeys(description);
        driver.findElements(pollContinueButton()).get(0).click();
    }

    public boolean isWizardStepDisplayed(String stepNo) {
        waitToBeVisible(wizardStepTitle(stepNo));
        return driver.findElement(wizardStepTitle(stepNo)).isDisplayed();
    }

    public void selectMondayNextWeek() {
        driver.findElement(nextWeekButton()).click();
        driver.findElements(daysOfWeek()).get(1).click();
        driver.findElements(pollContinueButton()).get(1).click();
    }

    public void selectPollSettings() {
        driver.findElements(pollContinueButton()).get(2).click();
    }

    public void enterPollInitiator(String name, String email) {
        driver.findElement(initiatorNameInput()).sendKeys(name);
        driver.findElement(initiatorEmailInput()).sendKeys(email);
        driver.findElements(pollContinueButton()).get(3).click();
    }

    public boolean isInviteParticipantsDisplayed() {
        waitToBeVisible(inviteParticipants());
        return driver.findElement(inviteParticipants()).isDisplayed();
    }

    public String getPollTitle() {
        return driver.findElement(pollTitle()).getText();
    }

    public String getPollLocation() {
        return driver.findElement(pollLocation()).getText();
    }

    public String getPollDescription() {
        return driver.findElement(pollDescription()).getText();
    }

    public String getPollLink() {
        waitToBeVisible(pollLinkToCopy());
        return driver.findElement(pollLinkToCopy()).getAttribute("value");
    }
}

