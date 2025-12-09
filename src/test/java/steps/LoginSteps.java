package steps;

import driver.Settings;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import lombok.NoArgsConstructor;
import pages.actions.HomePageActions;
import pages.actions.LoginPageActions;

import static org.junit.jupiter.api.Assertions.assertTrue;

@NoArgsConstructor
public class LoginSteps {
    private final LoginPageActions loginPageActions = new LoginPageActions();
    private final HomePageActions homePageActions = new HomePageActions();

    @Given("the user opens the Digital Bank login page")
    public void openDigitalBankLoginPage(){
        loginPageActions.driver.get(Settings.getLoginUrl());
    }

    @And("the user accepts the cookies")
    public void acceptCookies(){
        loginPageActions.acceptCookies();
    }

    @When("the user enters valid username {string} and password {string}")
    public void enterValidCredentials(String username, String password){
        loginPageActions.fillUsername(username);
        loginPageActions.fillPassword(password);
    }

    @And("the user logs in")
    public void clicksOnSignInButton(){
        loginPageActions.signIn();
    }

    @Then("the main dashboard page should be displayed")
    public void dashBoardPageDisplayed(){
        assertTrue(homePageActions.homePageLoaded());
    }

    @When("the user enters invalid username {string} and password {string}")
    public void enterInvalidCredentials(String username, String password){
        loginPageActions.fillUsername(username);
        loginPageActions.fillPassword(password);
    }

    @Then("a login error message should be displayed")
    public void loginErrorMessageDisplayed(){
        assertTrue(loginPageActions.loginErrorDisplayed());
    }
}
