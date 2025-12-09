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

    public HomePageElements(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }
}
