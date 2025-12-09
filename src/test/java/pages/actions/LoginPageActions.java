package pages.actions;

import org.openqa.selenium.support.PageFactory;
import pages.elements.LoginPageElements;

public class LoginPageActions extends CommonActions{
    private final LoginPageElements loginPageElements;

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
        clickButton(loginPageElements.acceptCookiesButton);
    }

    public void signIn(){
        clickButton(loginPageElements.loginButton);
    }

    public boolean loginErrorDisplayed(){
        return elementIsVisible(loginPageElements.loginError);
    }
}
