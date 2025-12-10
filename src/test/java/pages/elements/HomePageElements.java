package pages.elements;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageElements {
    @Getter
    public WebDriver driver;
    @Getter
    public WebDriverWait wait;

    @Getter
    @FindBy(xpath = "//*[@id='page-title']")
    public WebElement homePageTitle;

    @Getter
    @FindBy(xpath="//*[@id='checking-menu']")
    public WebElement checkingMenu;

    @Getter
    @FindBy(xpath="//*[@id='new-checking-menu-item']")
    public WebElement newCheckingOption;

    @Getter
    @FindBy(xpath="//*[@id='savings-menu']")
    public WebElement savingsMenu;

    @Getter
    @FindBy(xpath="//*[@id='new-savings-menu-item']")
    public WebElement newSavingsOption;

    @Getter
    @FindBy(xpath="//*[@id='deposit-menu-item']")
    public WebElement depositOption;

    @Getter
    @FindBy(xpath="//*[@id='withdraw-menu-item']")
    public WebElement withdrawOption;

    public HomePageElements(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }
}
