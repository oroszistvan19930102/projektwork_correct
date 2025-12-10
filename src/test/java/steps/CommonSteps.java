package steps;

import io.cucumber.java.en.Given;
import pages.actions.HomePageActions;
import pages.actions.LoginPageActions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommonSteps {
    private final LoginPageActions loginPageActions = new LoginPageActions();
    private final HomePageActions homePageActions = new HomePageActions();

    @Given("the user is logged in to the Digital Bank System")
    public void userIsLoggedIn(){
        loginPageActions.fullLoginProcess();
        assertTrue(homePageActions.homePageLoaded());
    }
}
