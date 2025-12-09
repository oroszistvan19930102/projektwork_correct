package pages.actions;

import org.openqa.selenium.support.PageFactory;
import pages.elements.CreateCheckingPageElements;

public class CreateCheckingPageActions extends CommonActions{
    private final CreateCheckingPageElements createCheckingPageElements;

    public CreateCheckingPageActions(){
        super();
        this.createCheckingPageElements = new CreateCheckingPageElements(this.driver, this.wait);
        PageFactory.initElements(driver, this);
    }

    public void selectAccountType(String accountType){
        if(accountType.equalsIgnoreCase("Standard Checking")){
            clickElement(createCheckingPageElements.standardAccountType);
        }else{
            clickElement(createCheckingPageElements.interestAccountType);
        }
    }

    public void selectOwnership(String ownership){
        if(ownership.equalsIgnoreCase("Individual")){
            clickElement(createCheckingPageElements.individualOwnership);
        }else{
            clickElement(createCheckingPageElements.jointOwnership);
        }
    }

    public void fillAccountName(String accountName){
        fillElements(createCheckingPageElements.nameField, accountName);
    }

    public void fillInitialDepositAmount(String initialDepositAmount){
        fillElements(createCheckingPageElements.initialDepositAmountField, initialDepositAmount);
    }

    public void submitNewChecking(){
        clickElement(createCheckingPageElements.newCheckingSubmitButton);
    }

    public boolean lowInitialDepositErrorIsDisplayed(){
        return elementIsVisible(createCheckingPageElements.lowInitialDepositError);
    }
}
