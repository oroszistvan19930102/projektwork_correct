package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.actions.CreateCheckingPageActions;
import pages.actions.HomePageActions;
import pages.actions.ViewCheckingAccountsPageActions;

import static org.junit.jupiter.api.Assertions.assertTrue;

@NoArgsConstructor
public class CheckingSteps {
    private static final Logger logger = LoggerFactory.getLogger(CheckingSteps.class);
    private final HomePageActions homePageActions = new HomePageActions();
    private final CreateCheckingPageActions createCheckingPageActions = new CreateCheckingPageActions();
    private final ViewCheckingAccountsPageActions viewCheckingAccountsPageActions = new ViewCheckingAccountsPageActions();

    @When("the user opens the {string} creation page")
    public void openCreationPage(String type){
        logger.info("Opening creation page for {}", type);
        homePageActions.selectFromAccounts(type);
    }

    @And("the user selects account type {string}")
    public void selectAccountType(String accountType){
        logger.info("Selecting account type {}", accountType);
        createCheckingPageActions.selectAccountType(accountType);
    }

    @And("the user selects ownership {string}")
    public void selectOwnership(String ownership){
        logger.info("Selecting ownership type {}", ownership);
        createCheckingPageActions.selectOwnership(ownership);
    }

    @And("the user enters account name {string}")
    public void enterAccountName(String accountName){
        logger.info("Entering account name {}", accountName);
        createCheckingPageActions.fillAccountName(accountName);
    }

    @And("the user enters initial deposit amount {string}")
    public void enterInitialDepositAmount(String initialDepositAmount){
        logger.info("Entering initial deposit amount {}", initialDepositAmount);
        createCheckingPageActions.fillInitialDepositAmount(initialDepositAmount);
    }

    @And("the user creates the new account")
    public void createNewAccount(){
        logger.info("Creating new account");
        createCheckingPageActions.submitNewAccount();
    }

    @Then("the account {string} of the user should be displayed")
    public void newAccountIsVisible(String accountName){
        assertTrue(viewCheckingAccountsPageActions.newAccountIsVisible(accountName));
        logger.info("Successful account creation is successful.");
    }

    @And("a confirmation message should be displayed")
    public void confirmationOfSavingsIsDisplayed(){
        assertTrue(viewCheckingAccountsPageActions.confirmationOfNewAccountIsDisplayed());
    }

    @Then("an initial deposit error message should be displayed")
    public void lowInitialDepositErrorIsDisplayed(){
        createCheckingPageActions.lowInitialDepositErrorIsDisplayed();
        logger.info("Unsuccessful account creation is successful.");
    }
}
