package page;

import base.pageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class homePage extends pageBase {

    public homePage(WebDriver driver){
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
        wait.until(ExpectedConditions.visibilityOf(dropdownMyAct));
        js.executeScript("arguments[0].click();",dropdownMyAct);
    }
    public void clickAccRegister(){
        wait.until(ExpectedConditions.visibilityOf(accRegister));
        js.executeScript("arguments[0].click();",accRegister);
    }
    public void clickAccLogin(){
        wait.until(ExpectedConditions.visibilityOf(accLogin));
        js.executeScript("arguments[0].click();",accLogin);
    }

}
