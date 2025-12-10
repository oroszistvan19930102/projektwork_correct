package pages.elements;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateCheckingPageElements {
    @Getter
    public WebDriver driver;
    @Getter
    public WebDriverWait wait;

    @Getter
    @FindBy(xpath = "//*[@id='Standard Checking']")
    public WebElement standardAccountType;

    @Getter
    @FindBy(xpath = "//*[@id='Interest Checking']")
    public WebElement interestAccountType;

    @Getter
    @FindBy(xpath = "//*[@id='Individual']")
    public WebElement individualOwnership;

    @Getter
    @FindBy(xpath = "//*[@id='Joint']")
    public WebElement jointOwnership;

    @Getter
    @FindBy(xpath = "//*[@id='name']")
    public WebElement nameField;

    @Getter
    @FindBy(xpath = "//*[@id='openingBalance']")
    public WebElement initialDepositAmountField;

    @Getter
    @FindBy(xpath = "//button[@type='submit' and normalize-space()='Submit']")
    public WebElement newCheckingSubmitButton;

    @Getter
    @FindBy(xpath = "//*[@id='new-account-error-msg']")
    public WebElement lowInitialDepositError;

    public CreateCheckingPageElements(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }
}
