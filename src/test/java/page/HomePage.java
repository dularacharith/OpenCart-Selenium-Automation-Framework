package page;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.elements.HomePageElements;

public class HomePage extends PageBase {

    //Objects
    @FindBy(xpath = HomePageElements.xpathMyAccDropdown)
    private WebElement dropdownMyAct;

    @FindBy(xpath = HomePageElements.xpathAccRegister)
    private WebElement accRegister;

    @FindBy(xpath = HomePageElements.xpathAccLogin)
    private WebElement accLogin;

    public HomePage(WebDriver driver){
        super(driver);
    }

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
