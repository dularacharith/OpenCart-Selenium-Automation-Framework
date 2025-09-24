package page;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.elements.RegisterPageElements;


public class RegisterPage extends PageBase {

    //Objects
    @FindBy(xpath = RegisterPageElements.xpathFirstName)
    private WebElement inputFirstName;

    @FindBy(xpath = RegisterPageElements.xpathLastName)
    private WebElement inputLastName;

    @FindBy(xpath = RegisterPageElements.xpathEmail)
    private WebElement inputEmail;

    @FindBy(xpath = RegisterPageElements.xpathPassword)
    private WebElement inputPassword;

    @FindBy(xpath = RegisterPageElements.xpathNewsLetter)
    private WebElement checkboxSubscribe;

    @FindBy(xpath = RegisterPageElements.xpathPrivacyPolicy)
    private WebElement checkboxPrivacyPolicyAgree;

    @FindBy(xpath = RegisterPageElements.xpathContinue)
    private WebElement btnContinue;

    @FindBy(xpath = RegisterPageElements.xpathAlertError)
    private WebElement alertPrivacyPolicy;

    @FindBy(xpath = RegisterPageElements.xpathMyAccTitle)
    private WebElement massageAccCreateSuccuss;

    @FindBy(xpath = RegisterPageElements.xpathContinueAfter)
    private WebElement btnContinueAfterRegister;

    public RegisterPage(WebDriver driver){
                    super(driver);
                }

    //Methods
    public void setInputFirstName(String firstname){
        PageBase.explicitWait(inputFirstName);
        inputFirstName.clear();
        js.executeScript("arguments[0].scrollIntoView(true);",inputFirstName);
        inputFirstName.sendKeys(firstname);
    }

    public void setInputLastName(String lastname){
        PageBase.explicitWait(inputLastName);
        inputLastName.clear();
        js.executeScript("arguments[0].scrollIntoView(true);",inputLastName);
        inputLastName.sendKeys(lastname);
    }

    public void setInputEmail(String email){
        PageBase.explicitWait(inputEmail);
        inputEmail.clear();
        js.executeScript("arguments[0].scrollIntoView(true);",inputEmail);
        inputEmail.sendKeys(email);
    }

    public void setInputPassword(String password){
        PageBase.explicitWait(inputPassword);
        inputPassword.clear();
        js.executeScript("arguments[0].scrollIntoView(true);",inputPassword);
        inputPassword.sendKeys(password);
    }

    public void clickCheckboxSubscribe(){
        PageBase.explicitWait(checkboxSubscribe);
        js.executeScript("arguments[0].scrollIntoView(true);arguments[1].click();",checkboxSubscribe,checkboxSubscribe);
    }

    public void clickPrivacyPolicyAgree(){
        PageBase.explicitWait(checkboxPrivacyPolicyAgree);
        js.executeScript("arguments[0].scrollIntoView(true);arguments[1].click();",checkboxPrivacyPolicyAgree,checkboxPrivacyPolicyAgree);
    }

    public void clickContinue(){
        PageBase.explicitWait(btnContinue);
        js.executeScript("arguments[0].scrollIntoView(true);arguments[1].click();",btnContinue,btnContinue);
    }

    public String textOfSuccessMsg (){
        try {
            PageBase.explicitWait(massageAccCreateSuccuss);
            return massageAccCreateSuccuss.getText();
        }
        catch (Exception e){
            return "";
        }
    }

    public void clickContinueAfterRegister(){
        PageBase.explicitWait(btnContinueAfterRegister);
        js.executeScript("arguments[0].click();",btnContinueAfterRegister);
    }

    public boolean agreedToPrivacyPolicy(){
        try {
            explicitWait(alertPrivacyPolicy);
            return alertPrivacyPolicy.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
