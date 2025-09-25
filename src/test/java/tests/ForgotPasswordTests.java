package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import page.ForgotPasswordPage;
import page.HomePage;
import page.LoginPage;
import utils.LoggerClass;
import utils.ExtentReportClass;
import utils.DataProvider;

public class ForgotPasswordTests extends TestBase {
    private HomePage homepage;
    private LoginPage loginpage;
    private ForgotPasswordPage forgotpwpage;

    //VALIDATE FORGOT PASSWORD
    @Test(priority = 1,dataProvider = "ForgotPasswordTest",dataProviderClass = DataProvider.class)
    public void forgotPassword(String email){
        test = ExtentReportClass.createTest("FORGOT PASSWORD TEST "+email);
        LoggerClass.logInfo("TEST STARTED! "+getClass());

        homepage = new HomePage(driver);
        loginpage = new LoginPage(driver);
        forgotpwpage = new ForgotPasswordPage(driver);

        homepage.clickDropdownMyAct();
        homepage.clickAccLogin();

        loginpage.clickForgetPwd();

        String acctualMassage = forgotpwpage.getFPTitle();
        String expectedMassage = ExpectedResults.forgotpasswordLinkText;

        try {
            Assert.assertEquals(acctualMassage,expectedMassage);
            forgotpwpage.setInputEmail(email);
            forgotpwpage.clickContinueButton();
            Assert.assertTrue(forgotpwpage.isSuccessAlertDisplayed());
            test.pass("TEST PASSED! email sent.");
            LoggerClass.logInfo("TEST PASSED!");
            TestBase.getToMainURL();
        }
        catch (AssertionError e){
            test.fail("TEST FAILED! "+e.getMessage());
            LoggerClass.logInfo("TEST FAILED!");
            TestBase.getToMainURL();
            Assert.fail();
        }
    }

    //VALIDATE BACK BUTTON GO TO LOGIN PAGE
    @Test(priority = 2)
    public void backButtonTest(){
        LoggerClass.logInfo("TEST STARTED! "+getClass());
        test=ExtentReportClass.createTest("FORGOT PASSSWORD BACK BUTTON TEST");
        homepage = new HomePage(driver);
        loginpage = new LoginPage(driver);
        forgotpwpage = new ForgotPasswordPage(driver);

        homepage.clickDropdownMyAct();
        homepage.clickAccLogin();
        loginpage.clickForgetPwd();
        forgotpwpage.clickBackButton();

        try {
            Assert.assertTrue(loginpage.isTitleReuturningCustomerDisplayed());
            test.pass("TEST PASSED! user get back to the loginpage");
            LoggerClass.logInfo("TEST PASSED!");
        }
        catch (AssertionError e){
            test.fail("TEST FAILED! user did not get to login page.");
            LoggerClass.logInfo("TEST FAILED!");
            Assert.fail();
        }

    }

    @AfterMethod
    public void getURL(){
        TestBase.getToMainURL();
    }



}
