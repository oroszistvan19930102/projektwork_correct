package pages.actions;

import hooks.Hooks;
import lombok.Getter;
import org.openqa.selenium.By;
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

    public void clickElement(WebElement element){
        this.wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void clickElement(String text){
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Standard Checking']"))).click();
    }

    public boolean elementIsVisible(WebElement element){
        return this.wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }

    public boolean elementIsVisible(String text){
        return this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(text))).isDisplayed();
    }

    public WebElement findDOMElementById(String text){
        return this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='" + text + "']")));
    }

    public WebElement findDOMElementByPath(String path){
        return this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
    }
}
