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

    public boolean confirmationOfNewAccountIsDisplayed(){
        return elementIsVisible(viewCheckingAccountsPageElements.confirmationOfCreation);
    }
}
