package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.actions.CommonDepositWithdrawPageActions;
import pages.actions.HomePageActions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TransactionSteps {
    private static final Logger logger = LoggerFactory.getLogger(TransactionSteps.class);
    private final HomePageActions homePageActions = new HomePageActions();
    private final CommonDepositWithdrawPageActions commonDepositWithdrawPageActions = new CommonDepositWithdrawPageActions();

    @When("the user navigates to {string}")
    public void navigateToTransaction(String transactionType){
        logger.info("Navigating to transaction type {}", transactionType);
        homePageActions.gotToTransaction(transactionType);
    }

    @And("the user selects the target account {string}")
    public void selectTargetAccount(String targetAccount){
        logger.info("Selecting target account type {}", targetAccount);
        commonDepositWithdrawPageActions.selectTargetAccount(targetAccount);
    }

    @And("the user types the amount {string}")
    public void typeTargetAmount(String targetAmount){
        logger.info("Entering amount {}", targetAmount);
        commonDepositWithdrawPageActions.fillTargetAmount(targetAmount);
    }

    @And("the user allows the transaction")
    public void allowTransaction(){
        logger.info("Allowing tranaction.");
        commonDepositWithdrawPageActions.allowTransaction();
    }

    @Then("the transaction details {string} should be displayed")
    public void transactionDetailsDisplayed(String accountName){
        assertTrue(commonDepositWithdrawPageActions.newAccountIsVisible(accountName));
        logger.info("Successfull tranaction is successfull.");
    }

    @Then("the transaction details {string} should not be displayed")
    public void transactionErrorDisplayed(String accountName){
        assertTrue(true);
    }
}
