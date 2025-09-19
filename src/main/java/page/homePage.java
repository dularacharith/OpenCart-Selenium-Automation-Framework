package page;

import base.pageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePage extends pageBase {

    public homePage(WebDriver driver){
        super(driver);
    }
    //Objects
    @FindBy(xpath = "//a[@data-bs-toggle='dropdown']//i[@class='fa-solid fa-user']")
    private WebElement dropdownMyAct;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    private WebElement accRegister;

    @FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Login']")
    private WebElement accLogin;

    //Methods
    public void clickDropdownMyAct(){
        dropdownMyAct.click();
    }
    public void clickAccRegister(){
        accRegister.click();
    }
    public void clickAccLogin(){
        accLogin.click();
    }

}
