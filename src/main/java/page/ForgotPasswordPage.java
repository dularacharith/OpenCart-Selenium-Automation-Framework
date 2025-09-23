package page;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends PageBase {

    @FindBy(xpath = "//input[@id='input-email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//button[normalize-space()='Continue']")
    private WebElement btnContinue;

    @FindBy(xpath = "//a[normalize-space()='Back']")
    private WebElement btnBack;

    @FindBy(xpath = "//h1[normalize-space()='Forgot Your Password?']")
    private WebElement titleForgotPassword;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement notFoundErrorAlert;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    private WebElement textSuccessAlert;

    public ForgotPasswordPage(WebDriver driver){
        super(driver);
    }

    public void setInputEmail(String email){
        PageBase.explicitWait(inputEmail);
        inputEmail.clear();
        inputEmail.sendKeys(email);
    }
    public void clickBackButton(){
        PageBase.explicitWait(btnBack);
        btnBack.click();
    }
    public void clickContinueButton(){
        PageBase.explicitWait(btnContinue);
        btnContinue.click();
    }
    public String getFPTitle(){
        return titleForgotPassword.getText();
    }
    public boolean isErrorAlertDisplayed(){
        try {
            return notFoundErrorAlert.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isSuccessAlertDisplayed(){
        try {
            return textSuccessAlert.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


}
