package page;

import base.PageBase;
import page.elements.ForgotPasswordPageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends PageBase {

    @FindBy(xpath = ForgotPasswordPageElements.xpathEmail)
    private WebElement inputEmail;

    @FindBy(xpath = ForgotPasswordPageElements.xpathContinue)
    private WebElement btnContinue;

    @FindBy(xpath = ForgotPasswordPageElements.xpathBack )
    private WebElement btnBack;

    @FindBy(xpath = ForgotPasswordPageElements.xpathForgotPwTitle)
    private WebElement titleForgotPassword;

    @FindBy(xpath = ForgotPasswordPageElements.xpathErrorAlert)
    private WebElement notFoundErrorAlert;

    @FindBy(xpath = ForgotPasswordPageElements.xpathSuccessAlert)
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
