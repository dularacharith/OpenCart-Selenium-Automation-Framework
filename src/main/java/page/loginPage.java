package page;

import base.pageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class loginPage extends pageBase{
    public loginPage(WebDriver driver){
        super(driver);
    }
    //Objects
    @FindBy(xpath = "//input[@id='input-email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//input[@id='input-password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//div[@class='mb-3']//a[normalize-space()='Forgotten Password']")
    private WebElement linkForgotPassword;

    @FindBy(xpath = "//button[text()='Login']")
    private WebElement btnLogin;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement msgLogginFailed;

    //
    public void setInputEmail(String email){
        js.executeScript("arguments[0].value=arguments[1];",inputEmail,email);
    }
    public void setInputPassword(String password){
        js.executeScript("arguments[0].value=arguments[1];",inputPassword,password);
    }
    public void clickForgetPwd(){
        js.executeScript("arguments[0].click();",linkForgotPassword);
    }
    public void clickLogin(){
        js.executeScript("arguments[0].click();",btnLogin);
    }
    public boolean isLoginFailedMassageDisplayed(){
        try {
            return msgLogginFailed.isDisplayed();
        }
        catch (Exception e){
            return false;
        }
       // return wait.until(ExpectedConditions.visibilityOf(msgLogginFailed)).isDisplayed();
    }
}
