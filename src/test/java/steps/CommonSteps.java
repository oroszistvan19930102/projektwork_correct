package steps;

import io.cucumber.java.en.Given;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.actions.HomePageActions;
import pages.actions.LoginPageActions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommonSteps {
    private static final Logger logger = LoggerFactory.getLogger(CommonSteps.class);
    private final LoginPageActions loginPageActions = new LoginPageActions();
    private final HomePageActions homePageActions = new HomePageActions();

    @Given("the user is logged in to the Digital Bank System")
    public void userIsLoggedIn(){
        logger.info("Full login process started.");
        loginPageActions.fullLoginProcess();
        assertTrue(homePageActions.homePageLoaded());
        logger.info("Full login process is finished.");
    }
}
