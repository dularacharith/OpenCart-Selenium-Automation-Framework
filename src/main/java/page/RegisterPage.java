package page;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends PageBase {
    public RegisterPage(WebDriver driver){
        super(driver);
    }

    //Objects
    @FindBy(xpath = "//input[@id='input-firstname']")
    private WebElement inputFirstName;

    @FindBy(xpath = "//input[@id='input-lastname']")
    private WebElement inputLastName;

    @FindBy(xpath = "//input[@id='input-email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//input[@id='input-password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//input[@id='input-newsletter']")
    private WebElement checkboxSubscribe;

    @FindBy(xpath = "//input[@name='agree']")
    private WebElement checkboxPrivacyPolicyAgree;

    @FindBy(xpath = "//button[normalize-space()='Continue']")
    private WebElement btnContinue;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement alertPrivacyPolicy;

    @FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
    private WebElement massageAccCreateSuccuss;

    @FindBy(xpath = "//a[normalize-space()='Continue']")
    private WebElement btnContinueAfterRegister;

    //Methods
    public void setInputFirstName(String firstname){
        PageBase.explicitWait(inputFirstName);
        //js.executeScript("arguments[0].scrollIntoView(true);",inputFirstName);
        inputFirstName.sendKeys(firstname);
    }

    public void setInputLastName(String lastname){
        PageBase.explicitWait(inputLastName);
        js.executeScript("arguments[0].scrollIntoView(true);",inputLastName);
        inputFirstName.sendKeys(lastname);
    }

    public void setInputEmail(String email){
        PageBase.explicitWait(inputEmail);
        js.executeScript("arguments[0].scrollIntoView(true);",inputEmail);
        inputEmail.sendKeys(email);
    }

    public void setInputPassword(String password){
        PageBase.explicitWait(inputPassword);
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
}
