package page;

import base.pageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class registerPage extends pageBase{
    public registerPage(WebDriver driver){
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
        wait.until(ExpectedConditions.visibilityOf(inputFirstName)).sendKeys(firstname);
    }
    public void setInputLastName(String lastname){
        wait.until(ExpectedConditions.visibilityOf(inputLastName)).sendKeys(lastname);
    }
    public void setInputEmail(String email){
        wait.until(ExpectedConditions.visibilityOf(inputEmail)).sendKeys(email);
    }
    public void setInputPassword(String password){
        wait.until(ExpectedConditions.visibilityOf(inputPassword)).sendKeys(password);;
    }
    public void clickCheckboxSubscribe(){
        wait.until(ExpectedConditions.visibilityOf(checkboxSubscribe));
        js.executeScript("arguments[0].scrollIntoView(true);arguments[1].click();",checkboxSubscribe,checkboxSubscribe);
    }
    public void clickPrivacyPolicyAgree(){
        wait.until(ExpectedConditions.visibilityOf(checkboxPrivacyPolicyAgree));
        js.executeScript("arguments[0].scrollIntoView(true);arguments[1].click();",checkboxPrivacyPolicyAgree,checkboxPrivacyPolicyAgree);
    }
    public void clickContinue(){
        wait.until(ExpectedConditions.visibilityOf(btnContinue));
        js.executeScript("arguments[0].scrollIntoView(true);arguments[1].click();",btnContinue,btnContinue);
    }
    public String textOfSuccessMsg (){
        return wait.until(ExpectedConditions.visibilityOf(massageAccCreateSuccuss)).getText();
    }
    public void clickContinueAfterRegister(){
        wait.until(ExpectedConditions.visibilityOf(btnContinueAfterRegister));
        js.executeScript("arguments[0].click();",btnContinueAfterRegister);
    }

}
