package steps;

import driver.Settings;
import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {
    @Given("the user opens the Digital Bank login page")
    public void openDigitalBankLoginPage(){
        Hooks.driver.get(Settings.getLoginUrl());
        WebElement cookieAcception = Hooks.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"freeprivacypolicy-com---nb\"]/div/div[3]/button[1]")));
        assert cookieAcception != null;
        cookieAcception.click();
    }

    @When("the user enters valid username {string} and password {string}")
    public void enterValidCredentials(String username, String password){
        WebElement usernameField = Hooks.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='username']")));
        WebElement passwordField = Hooks.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='password']")));

        assert usernameField != null;
        usernameField.sendKeys(username);
        assert passwordField != null;
        passwordField.sendKeys(password);
    }

    @And("the user clicks on the Sign In button")
    public void clicksOnSignInButton(){
        WebElement signIn_button = Hooks.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='submit']")));
        assert signIn_button != null;
        signIn_button.click();
    }

    @Then("the main dashboard page should be displayed")
    public void dashBoardPageDisplayed(){
        WebElement pageTitle = Hooks.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='page-title']")));
        assert pageTitle != null;
        assertTrue(pageTitle.isDisplayed());
    }
}
