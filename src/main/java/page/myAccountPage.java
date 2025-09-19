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

    //methods
    public String msgH1MyAccount(){
        return wait.until(ExpectedConditions.visibilityOf(h1MyAccount)).getText();
    }

}
