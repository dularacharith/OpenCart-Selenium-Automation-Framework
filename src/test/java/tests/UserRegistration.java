package tests;
import base.TestBase;
import org.testng.Assert;

import page.HomePage;
import page.LogoutPage;
import page.MyAccountPage;
import page.RegisterPage;

import utils.LoggerClass;
import utils.DataProvider;
import utils.ExtentReportClass;

import org.testng.annotations.Test;

public class UserRegistration extends TestBase {
    RegisterPage registerPage;
    HomePage homePage;
    LogoutPage logoutPage;
    MyAccountPage myAccountPage;

    //VALIDATE USER REGISTRATION
    @Test(priority = 1, dataProvider = "RegisterTest", dataProviderClass = DataProvider.class)
    public void userRegistration(String fname,String lname,String email, String password){

        test = ExtentReportClass.createTest("USER REGISTRATION TEST "+email);
        LoggerClass.logInfo("TEST STARTED! "+getClass());

        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        logoutPage = new LogoutPage(driver);
        myAccountPage = new MyAccountPage(driver);

        homePage.clickDropdownMyAct();

        test.info("Navigationg to Register Page.");
        homePage.clickAccRegister();

        test.info("Entering first name.");
        registerPage.setInputFirstName(fname);

        test.info("Entering last name.");
        registerPage.setInputLastName(lname);

        test.info("Entering email.");
        registerPage.setInputEmail(email);

        test.info("Entering password.");
        registerPage.setInputPassword(password);
        ;
        test.info("Subscribe NewsLetter.");
        registerPage.clickCheckboxSubscribe();

        test.info("Agreeing privacy policy.");
        registerPage.clickPrivacyPolicyAgree();
        registerPage.clickContinue();

        String acctualMassage = registerPage.textOfSuccessMsg();
        String expectedMassage = ExpectedResults.accountCreatedMassage;

        try {
            Assert.assertEquals(acctualMassage,expectedMassage);
            test.pass("TEST PASSED! account has been created!");
            LoggerClass.logInfo("TEST PASSED!");

            registerPage.clickContinueAfterRegister();
            myAccountPage.clickMyAccDropDown();
            myAccountPage.clickMyAccLogOut();
            logoutPage.clickAccountLogoutCnt();

            TestBase.getToMainURL();
        }
        catch (AssertionError e){
            test.fail("TEST FAILED! account not created"+e.getMessage());
            LoggerClass.logInfo("TEST FAILED!");
            TestBase.getToMainURL();
            Assert.fail();
        }
}

}
