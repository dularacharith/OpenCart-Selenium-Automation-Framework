package page;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.elements.LoginPageElements;

public class LoginPage extends PageBase {
    public LoginPage(WebDriver driver){
        super(driver);
    }
    //Objects
    @FindBy(xpath = LoginPageElements.xpathEmail)
    private WebElement inputEmail;

    @FindBy(xpath = LoginPageElements.xpathPassword)
    private WebElement inputPassword;

    @FindBy(xpath = LoginPageElements.xpathForgotPw)
    private WebElement linkForgotPassword;

    @FindBy(xpath = LoginPageElements.xpathLoginBtn)
    private WebElement btnLogin;

    @FindBy(xpath = LoginPageElements.xpathErrorAlert)
    private WebElement msgLogginFailed;

    @FindBy(xpath = LoginPageElements.xpathLogoutAttemptsExceed)
    private WebElement msgLoginAttempt;

    @FindBy(xpath = LoginPageElements.xpathSessionToken)
    private WebElement sessionTokenExpireMsg;

    @FindBy(xpath = LoginPageElements.xpathTitleReturningCustomer)
    private WebElement titleReturningCustomer;

    //
    public void setInputEmail(String email){
        PageBase.explicitWait(inputEmail);
        inputEmail.clear();
        js.executeScript("arguments[0].value=arguments[1];",inputEmail,email);
    }
    public void setInputPassword(String password){
        PageBase.explicitWait(inputPassword);
        inputPassword.clear();
        js.executeScript("arguments[0].value=arguments[1];",inputPassword,password);
    }
    public void clickForgetPwd(){
        PageBase.explicitWait(linkForgotPassword);
        js.executeScript("arguments[0].click();",linkForgotPassword);
    }
    public void clickLogin(){
        PageBase.explicitWait(btnLogin);
        js.executeScript("arguments[0].click();",btnLogin);
    }
    public boolean isLoginFailedMassageDisplayed(){
        try {
            PageBase.explicitWait(msgLogginFailed);
            return msgLogginFailed.isDisplayed();
        }
        catch (Exception e){
            return false;
        }
    }
    public boolean loginAttemptMassage(){
        try {
            explicitWait(msgLoginAttempt);
            return msgLoginAttempt.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean sessionTokenExpireMsg(){
        try{
            explicitWait(sessionTokenExpireMsg);
            return sessionTokenExpireMsg.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public String placeholderTextInEmail(){
        try{
            explicitWait(inputEmail);
            return inputEmail.getAttribute("placeholder");
        } catch (Exception e) {
            return "";
        }
    }
    public String placeholderTextInPassword(){
        try{
            explicitWait(inputPassword);
            return inputPassword.getAttribute("placeholder");
        } catch (Exception e) {
            return "";
        }
    }
    public boolean isTitleReuturningCustomerDisplayed(){
        try {
            explicitWait(titleReturningCustomer);
            return titleReturningCustomer.isDisplayed();
        }
        catch (Exception e){
            return false;
        }
    }
}
