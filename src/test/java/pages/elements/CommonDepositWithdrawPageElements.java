package pages.elements;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonDepositWithdrawPageElements {
    @Getter
    public WebDriver driver;
    @Getter
    public WebDriverWait wait;

    @Getter
    @FindBy(xpath = "//*[@id='selectedAccount']")
    public WebElement targetAccount;

    @Getter
    @FindBy(xpath = "//*[@id='amount']")
    public WebElement targetAmount;

    @Getter
    @FindBy(xpath = "//button[@type='submit' and normalize-space()='Submit']")
    public WebElement allowTransaction;

    public CommonDepositWithdrawPageElements(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }
}
