package pages.actions;

import driver.Settings;
import org.openqa.selenium.support.PageFactory;
import pages.elements.LoginPageElements;

public class LoginPageActions extends CommonActions{
    private final LoginPageElements loginPageElements;
    private static final String USER_NAME = "oroszistvan1993";
    private static final String PASSWORD = "Password1!";

    public LoginPageActions(){
        super();
        this.loginPageElements = new LoginPageElements(this.driver, this.wait);
        PageFactory.initElements(driver, this);
    }

    public void fillUsername(String usernameText){
        fillElements(loginPageElements.usernameField, usernameText);
    }

    public void fillPassword(String passwordText){
        fillElements(loginPageElements.passwordField, passwordText);
    }

    public void acceptCookies(){
        clickElement(loginPageElements.acceptCookiesButton);
    }

    public void signIn(){
        clickElement(loginPageElements.loginButton);
    }

    public boolean loginErrorDisplayed(){
        return elementIsVisible(loginPageElements.loginError);
    }

    public void fullLoginProcess(){
        this.driver.get(Settings.getLoginUrl());
        acceptCookies();
        fillUsername(USER_NAME);
        fillPassword(PASSWORD);
        signIn();
    }
}
