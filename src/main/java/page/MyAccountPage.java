package page;

import base.PageBase;
import utils.ExtentReportClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class MyAccountPage extends PageBase {
    public MyAccountPage(WebDriver driver){
        super(driver);
    }
    //objects
    @FindBy(xpath = "//h1[normalize-space()='My Account']")
    private WebElement titleMyAccount;

    @FindBy(xpath = "//span[normalize-space()='My Account']")
    private WebElement myAccDropdown;

    @FindBy(xpath = "//li//a[normalize-space()='Logout']")
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
