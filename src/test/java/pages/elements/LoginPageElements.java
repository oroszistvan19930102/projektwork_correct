package pages.elements;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageElements {
    @Getter
    public WebDriver driver;
    @Getter
    public WebDriverWait wait;

    @Getter
    @FindBy(xpath = "//*[@id='username']")
    public WebElement usernameField;

    @Getter
    @FindBy(xpath = "//*[@id='password']")
    public WebElement passwordField;

    @Getter
    @FindBy(xpath = "//*[@id=\"freeprivacypolicy-com---nb\"]/div/div[3]/button[1]")
    public WebElement acceptCookiesButton;

    @Getter
    @FindBy(xpath = "//*[@id='submit']")
    public WebElement loginButton;

    @Getter
    @FindBy(xpath = "//span[text()='Error']")
    public WebElement loginError;

    public LoginPageElements(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }
}
