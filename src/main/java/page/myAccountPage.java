package page;

import base.pageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class myAccountPage extends pageBase {
    public myAccountPage(WebDriver driver){
        super(driver);
    }
    //objects
    @FindBy(xpath = "//h1[normalize-space()='My Account']")
    private WebElement h1MyAccount;

    @FindBy(xpath = "//span[normalize-space()='My Account']")
    private WebElement myAccDropdown;

    @FindBy(xpath = "//li//a[normalize-space()='Logout']")
    private WebElement myAccLogout;

    //methods
    public boolean ismsgH1MyAccountDisplayed(){
        return wait.until(ExpectedConditions.visibilityOf(h1MyAccount)).isDisplayed();
    }
    public void clickMyAccDropDown(){
        wait.until(ExpectedConditions.visibilityOf(myAccDropdown));
        js.executeScript("arguments[0].click();",myAccDropdown);
    }
    public void clickMyAccLogOut(){
        wait.until(ExpectedConditions.visibilityOf(myAccLogout));
        js.executeScript("arguments[0].click();",myAccLogout);
    }


}
