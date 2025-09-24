package page;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.elements.MyAccountPageElements;


public class MyAccountPage extends PageBase {
    public MyAccountPage(WebDriver driver){
        super(driver);
    }
    //objects
    @FindBy(xpath = MyAccountPageElements.xpathMyAcctitle)
    private WebElement titleMyAccount;

    @FindBy(xpath = MyAccountPageElements.xpathMyAccDropdown)
    private WebElement myAccDropdown;

    @FindBy(xpath = MyAccountPageElements.xpathMyAccLogout)
    private WebElement myAccLogout;

    //methods
    public boolean myAccountHeaderMassage(){
        try {
            PageBase.explicitWait(titleMyAccount);
            return titleMyAccount.isDisplayed();
        }
        catch(Exception e){
            return false;
        }

    }
    public void clickMyAccDropDown(){
        PageBase.explicitWait(myAccDropdown);
        myAccDropdown.click();
//        js.executeScript("arguments[0].click();",myAccDropdown);
    }
    public void clickMyAccLogOut(){
        PageBase.explicitWait(myAccLogout);
        myAccLogout.click();
//        js.executeScript("arguments[0].click();",myAccLogout);
    }

}
