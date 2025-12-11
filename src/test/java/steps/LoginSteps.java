package steps;

import driver.Settings;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.actions.HomePageActions;
import pages.actions.LoginPageActions;

import static org.junit.jupiter.api.Assertions.assertTrue;

@NoArgsConstructor
public class LoginSteps {
    private final LoginPageActions loginPageActions = new LoginPageActions();
    private final HomePageActions homePageActions = new HomePageActions();
    private static final Logger logger = LoggerFactory.getLogger(LoginSteps.class);

    @Given("the user opens the Digital Bank login page")
    public void openDigitalBankLoginPage(){
        logger.info("Opening login page.");
        loginPageActions.driver.get(Settings.getLoginUrl());
    }

    @And("the user accepts the cookies")
    public void acceptCookies(){
        logger.info("Accepting cookies.");
        loginPageActions.acceptCookies();
    }

    @When("the user enters valid username {string} and password {string}")
    public void enterValidCredentials(String username, String password){
        logger.info("Filling in valid username and password.");
        loginPageActions.fillUsername(username);
        loginPageActions.fillPassword(password);
    }

    @And("the user logs in")
    public void clicksOnSignInButton(){
        logger.info("Logging in.");
        loginPageActions.signIn();
    }

    @Then("the main dashboard page should be displayed")
    public void dashBoardPageDisplayed(){
        assertTrue(homePageActions.homePageLoaded());
        logger.info("Successful logintest is successful.");
    }

    @When("the user enters invalid username {string} and password {string}")
    public void enterInvalidCredentials(String username, String password){
        logger.info("Filling in invalid username and password.");
        loginPageActions.fillUsername(username);
        loginPageActions.fillPassword(password);
    }

    @Then("a login error message should be displayed")
    public void loginErrorMessageDisplayed(){
        assertTrue(loginPageActions.loginErrorDisplayed());
        logger.info("Unsuccessful logintest is successfull.");
    }
}
