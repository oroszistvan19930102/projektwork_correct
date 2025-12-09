package pages.actions;

import hooks.Hooks;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonActions {
    @Getter
    public WebDriver driver;
    @Getter
    public WebDriverWait wait;

    public CommonActions(){
        this.driver = Hooks.driver;
        this.wait = Hooks.wait;
        PageFactory.initElements(driver, this);
    }

    public void fillElements(WebElement fieldElement, String text){
        WebElement visibleElement = wait.until(ExpectedConditions.visibilityOf(fieldElement));
        visibleElement.clear();
        visibleElement.sendKeys(text);
    }

    public void clickButton(WebElement button){
        this.wait.until(ExpectedConditions.elementToBeClickable(button)).click();
    }

    public boolean elementIsVisible(WebElement element){
        return this.wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }
}
