package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.ForgotPasswordPage;
import page.HomePage;
import page.LoginPage;
import utils.LoggerClass;
import utils.ExtentReportClass;
import utils.DataProvider;

public class Test_TC03_ForgotPassword extends TestBase {
    private HomePage homepage;
    private LoginPage loginpage;
    private ForgotPasswordPage forgotpwpage;

    @Test(priority = 1,dataProvider = "ForgotPasswordTest",dataProviderClass = DataProvider.class)
    public void forgotPassword(String email){
        test = ExtentReportClass.createTest("Forgot Password Test "+email);
        LoggerClass.logInfo("Test Starting!");

        homepage = new HomePage(driver);
        loginpage = new LoginPage(driver);
        forgotpwpage = new ForgotPasswordPage(driver);

        homepage.clickDropdownMyAct();
        homepage.clickAccLogin();

        loginpage.clickForgetPwd();

        String acctualMassage = forgotpwpage.getFPTitle();
        String expectedMassage = "Forgot Your Password?";

        try {
            Assert.assertEquals(acctualMassage,expectedMassage);
            forgotpwpage.setInputEmail(email);
            forgotpwpage.clickContinueButton();
            Assert.assertTrue(forgotpwpage.isSuccessAlertDisplayed());
            test.pass("Email sent!");
        }
        catch (AssertionError e){
            test.fail("Failed! "+e.getMessage());
            throw e;
        }

    }



}
