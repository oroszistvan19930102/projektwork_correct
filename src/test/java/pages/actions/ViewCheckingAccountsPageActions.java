package pages.actions;

import org.openqa.selenium.support.PageFactory;
import pages.elements.ViewCheckingAccountsPageElements;

public class ViewCheckingAccountsPageActions extends CommonActions{
    private final ViewCheckingAccountsPageElements viewCheckingAccountsPageElements;

    public ViewCheckingAccountsPageActions(){
        super();
        this.viewCheckingAccountsPageElements = new ViewCheckingAccountsPageElements(this.driver, this.wait);
        PageFactory.initElements(driver, this);
    }

    public boolean newAccountIsVisible(String accountName){
        String xpath = "//div[@class='h4 m-0' and text()='" + accountName +"']";
        return elementIsVisible(xpath);
    }

    public boolean confirmationOfNewAccountIsDisplayed(){
        return elementIsVisible(viewCheckingAccountsPageElements.confirmationOfCreation);
    }
}
