package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.NoArgsConstructor;
import pages.actions.CreateCheckingPageActions;
import pages.actions.HomePageActions;
import pages.actions.ViewCheckingAccountsPageActions;

import static org.junit.jupiter.api.Assertions.assertTrue;

@NoArgsConstructor
public class CheckingSteps {
    private final HomePageActions homePageActions = new HomePageActions();
    private final CreateCheckingPageActions createCheckingPageActions = new CreateCheckingPageActions();
    private final ViewCheckingAccountsPageActions viewCheckingAccountsPageActions = new ViewCheckingAccountsPageActions();

    @When("the user opens the {string} creation page")
    public void openCreationPage(String type){
        homePageActions.selectFromAccounts(type);
    }

    @And("the user selects account type {string}")
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

    @And("the user creates the new account")
    public void createNewAccount(){
        createCheckingPageActions.submitNewAccount();
    }

    @Then("the account {string} of the user should be displayed")
    public void newAccountIsVisible(String accountName){
        assertTrue(viewCheckingAccountsPageActions.newAccountIsVisible(accountName));
    }

    @And("a confirmation message should be displayed")
    public void confirmationOfSavingsIsDisplayed(){
        assertTrue(viewCheckingAccountsPageActions.confirmationOfNewAccountIsDisplayed());
    }

    @Then("an initial deposit error message should be displayed")
    public void lowInitialDepositErrorIsDisplayed(){
        createCheckingPageActions.lowInitialDepositErrorIsDisplayed();
    }
}
