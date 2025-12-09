package steps;

import driver.Settings;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.NoArgsConstructor;
import pages.actions.CreateCheckingPageActions;
import pages.actions.HomePageActions;
import pages.actions.LoginPageActions;
import pages.actions.ViewCheckingAccountsPageActions;

import static org.junit.jupiter.api.Assertions.assertTrue;

@NoArgsConstructor
public class CheckingSteps {
    private final LoginPageActions loginPageActions = new LoginPageActions();
    private final HomePageActions homePageActions = new HomePageActions();
    private final CreateCheckingPageActions createCheckingPageActions = new CreateCheckingPageActions();
    private final ViewCheckingAccountsPageActions viewCheckingAccountsPageActions = new ViewCheckingAccountsPageActions();

    @Given("the user is logged in to the Digital Bank System")
    public void userIsLoggedIn(){
        loginPageActions.fullLoginProcess();
        assertTrue(homePageActions.homePageLoaded());
    }

    @And("the user opens the checking creation page")
    public void openCheckingCreationPage(){
        homePageActions.clickChecking();
        homePageActions.clickNewChecking();
    }

    @When("the user selects account type {string}")
    public void selectAccountType(String accountType){
        createCheckingPageActions.selectAccountType(accountType);
    }

    @And("the user selects ownership {string}")
    public void selectOwnership(String ownership){
        createCheckingPageActions.selectOwnership(ownership);
    }

    @And("the user enters account name {string}")
    public void enterAccountName(String accountName){
        createCheckingPageActions.fillAccountName(accountName);
    }

    @And("the user enters initial deposit amount {string}")
    public void enterInitialDepositAmount(String initialDepositAmount){
        createCheckingPageActions.fillInitialDepositAmount(initialDepositAmount);
    }

    @And("the user creates the new checking")
    public void createNewCheckin(){
        createCheckingPageActions.submitNewChecking();
    }

    @Then("the checkings {string} of the user should be displayed")
    public void newCheckingIsVisible(String accountName){
        assertTrue(viewCheckingAccountsPageActions.newCheckingIsVisible(accountName));
    }

    @And("a confirmation message should be displayed")
    public void confirmationOfCheckingIsDisplayed(){
        assertTrue(viewCheckingAccountsPageActions.confirmationOfCheckingIsDisplayed());
    }

    @Then("an initial deposit error message should be displayed")
    public void lowInitialDepositErrorIsDisplayed(){
        createCheckingPageActions.lowInitialDepositErrorIsDisplayed();
    }
}
