package page;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends PageBase {

    public HomePage(WebDriver driver){
        super(driver);
    }
    //Objects
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    private WebElement dropdownMyAct;

    @FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Register']")
    private WebElement accRegister;

    @FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Login']")
    private WebElement accLogin;

    //Methods
    public void clickDropdownMyAct(){
        PageBase.explicitWait(dropdownMyAct);
        js.executeScript("arguments[0].scrollIntoView(true);",dropdownMyAct);
        dropdownMyAct.click();
//        js.executeScript("arguments[0].click();",dropdownMyAct);
    }
    public void clickAccRegister(){
        PageBase.explicitWait(accRegister);
        js.executeScript("arguments[0].scrollIntoView(true);",accRegister);
        accRegister.click();
//        js.executeScript("arguments[0].click();",accRegister);
    }
    public void clickAccLogin(){
        PageBase.explicitWait(accLogin);
        js.executeScript("arguments[0].scrollIntoView(true);",accLogin);
        accLogin.click();
//        js.executeScript("arguments[0].click();",accLogin);
    }

}
