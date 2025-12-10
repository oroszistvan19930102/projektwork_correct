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

    private void clickChecking(){
        clickElement(homePageElements.checkingMenu);
    }

    private void clickNewChecking(){
        clickElement(homePageElements.newCheckingOption);
    }

    private void clickSavings(){
        clickElement(homePageElements.savingsMenu);
    }

    private void clickNewSavings(){
        clickElement(homePageElements.newSavingsOption);
    }

    public void selectFromAccounts(String type){
        if(type.equalsIgnoreCase("Checking")){
            this.clickChecking();
            this.clickNewChecking();
        }else{
            this.clickSavings();
            this.clickNewSavings();
        }
    }

    public void gotToTransaction(String transactionType) {
        transactionType = transactionType.toLowerCase() + "-menu-item";
        clickElement(findDOMElementById(transactionType));
    }
}
