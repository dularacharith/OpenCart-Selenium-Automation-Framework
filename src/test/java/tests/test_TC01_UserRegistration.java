package tests;
import base.testBase;
import org.testng.Assert;
import page.homePage;
import page.registerPage;
import utils.loggerClass;
import org.testng.annotations.Test;

public class test_TC01_UserRegistration extends testBase {

    @Test(priority = 1)
    protected void userRegistration(){
        homePage hp = new homePage(driver);
        registerPage rp = new registerPage(driver);

        hp.clickDropdownMyAct();
        loggerClass.logInfo("Getting Account register page...");
        hp.clickAccRegister();
        loggerClass.logInfo("Entering first name...");
        rp.setInputFirstName(property.getProperty("firstName1"));
        loggerClass.logInfo("Entering last name...");
        rp.setInputLastName(property.getProperty("lastName1"));
        loggerClass.logInfo("Entering email...");
        rp.setInputEmail(property.getProperty("email1"));
        loggerClass.logInfo("Entering password...");
        rp.setInputPassword(property.getProperty("password1"));
        loggerClass.logInfo("Checking subscribe...");
        rp.clickCheckboxSubscribe();
        loggerClass.logInfo("Agreeing privacy and policy...");
        rp.clickPrivacyPolicyAgree();
        rp.clickContinue();
        Assert.assertEquals(rp.textOfSuccessMsg(),"Your Account Has Been Created!");
        loggerClass.logInfo("Account has been created...");
        rp.clickContinueAfterRegister();
}
}
