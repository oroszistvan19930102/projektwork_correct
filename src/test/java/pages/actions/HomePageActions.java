package pages.actions;

import org.openqa.selenium.support.PageFactory;
import pages.elements.HomePageElements;

public class HomePageActions extends CommonActions{
    private final HomePageElements homePageElements;

    public HomePageActions(){
        super();
        this.homePageElements = new HomePageElements(this.driver, this.wait);
        PageFactory.initElements(driver, this);
    }

    public boolean homePageLoaded(){
        return elementIsVisible(homePageElements.homePageTitle);
    }

    public void clickChecking(){
        clickElement(homePageElements.checkingMenu);
    }

    public void clickNewChecking(){
        clickElement(homePageElements.newCheckingOption);
    }
}
