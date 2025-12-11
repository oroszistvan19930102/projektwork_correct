package pages.actions;

import org.openqa.selenium.support.PageFactory;
import pages.elements.CommonDepositWithdrawPageElements;
import pages.elements.CreateCheckingPageElements;

public class CommonDepositWithdrawPageActions extends CommonActions{
    private final CommonDepositWithdrawPageElements commonDepositWithdrawPageElements;

    public CommonDepositWithdrawPageActions(){
        super();
        this.commonDepositWithdrawPageElements = new CommonDepositWithdrawPageElements(this.driver, this.wait);
        PageFactory.initElements(driver, this);
    }

    public void selectTargetAccount(String targetAccount){
        //clickElement(commonDepositWithdrawPageElements.targetAccount);
        targetAccount = "//select[@id='selectedAccount']/option[starts-with(text(),'" + targetAccount + "')]";
        clickElement(findDOMElementByPath(targetAccount));
    }

    public void fillTargetAmount(String targetAmount){
        fillElements(commonDepositWithdrawPageElements.targetAmount, targetAmount);
    }

    public void allowTransaction(){
        clickElement(commonDepositWithdrawPageElements.allowTransaction);
    }
}
