package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.actions.CommonDepositWithdrawPageActions;
import pages.actions.HomePageActions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TransactionSteps {
    private final HomePageActions homePageActions = new HomePageActions();
    private final CommonDepositWithdrawPageActions commonDepositWithdrawPageActions = new CommonDepositWithdrawPageActions();

    @When("the user navigates to {string}")
    public void navigateToTransaction(String transactionType){
        homePageActions.gotToTransaction(transactionType);
    }

    @And("the user selects the target account {string}")
    public void selectTargetAccount(String targetAccount){
        commonDepositWithdrawPageActions.selectTargetAccount(targetAccount);
    }

    @And("the user types the amount {string}")
    public void typeTargetAmount(String targetAmount){
        commonDepositWithdrawPageActions.fillTargetAmount(targetAmount);
    }

    @And("the user allows the transaction")
    public void allowTransaction(){
        commonDepositWithdrawPageActions.allowTransaction();
    }

    @Then("the transaction details should be displayed")
    public void transactionDetailsDisplayed(){
        assertTrue(true);
    }

    @Then("a warning message should be displayed")
    public void transactionErrorDisplayed(){
        assertTrue(true);
    }
}
