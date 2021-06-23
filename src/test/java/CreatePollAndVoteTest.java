import framework.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.PollConfirmationPage;
import pageobjects.PollVotingPage;
import pageobjects.PollWizardPage;
import pageobjects.LandingPage;

public class CreatePollAndVoteTest extends BaseTest {

    private final String pollTitle = "Test poll";
    private final String pollLocation = "Skype";
    private final String pollDescription = "Doodle";
    private String pollLink;

    @Test(priority = 0, description = "Should open Doodle poll wizard")
    public void openPollWizard() {
        LandingPage landingPage = new LandingPage(getDriver());
        landingPage.acceptAllCookies();
        PollWizardPage pollWizardPage = new PollWizardPage(getDriver());
        Assert.assertTrue(pollWizardPage.isPollWizardDisplayed());
    }

    @Test(priority = 1, description = "Should complete poll step 1")
    public void completePollStepOne() {
        PollWizardPage pollWizardPage = new PollWizardPage(getDriver());
        pollWizardPage.enterOccasion(pollTitle, pollLocation, pollDescription);
        Assert.assertTrue(pollWizardPage.isWizardStepDisplayed("2"));
    }

    @Test(priority = 2, description = "Should complete poll step 2")
    public void completePollStepTwo() {
        PollWizardPage pollWizardPage = new PollWizardPage(getDriver());
        pollWizardPage.selectMondayNextWeek();
        Assert.assertTrue(pollWizardPage.isWizardStepDisplayed("3"));
    }

    @Test(priority = 3, description = "Should complete poll step 3")
    public void completePollStepThree() {
        PollWizardPage pollWizardPage = new PollWizardPage(getDriver());
        pollWizardPage.selectPollSettings();
        Assert.assertTrue(pollWizardPage.isWizardStepDisplayed("4"));
    }

    @Test(priority = 4, description = "Should successfully create a poll")
    public void finishPollCreation() {
        PollWizardPage pollWizardPage = new PollWizardPage(getDriver());
        pollWizardPage.enterPollInitiator("Guest", "guest@doodle.com");
        pollLink = pollWizardPage.getPollLink();
        Assert.assertTrue(pollWizardPage.isInviteParticipantsDisplayed());
        Assert.assertNotNull(pollLink);
        Assert.assertEquals(pollWizardPage.getPollTitle(), pollTitle);
        Assert.assertEquals(pollWizardPage.getPollLocation(), pollLocation);
        Assert.assertEquals(pollWizardPage.getPollDescription(), pollDescription);
    }

    @Test(priority = 5, description = "Should successfully vote on a poll")
    public void voteOnAPoll() {
        PollVotingPage pollVotingPage = new PollVotingPage(getDriver());
        getDriver().get(pollLink);
        pollVotingPage.performVotingAndSend("Test participant");
        PollConfirmationPage pollConfirmationPage = new PollConfirmationPage(getDriver());
        Assert.assertEquals(pollConfirmationPage.getConfirmationTitle(), "You have successfully voted");
    }
}
