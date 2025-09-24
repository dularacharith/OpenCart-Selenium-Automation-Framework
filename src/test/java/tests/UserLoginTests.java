package tests;

import base.TestBase;
import utils.ExtentReportClass;
import utils.LoggerClass;
import utils.DataProvider;

import org.testng.Assert;
import page.HomePage;
import page.LoginPage;
import page.MyAccountPage;
import page.LogoutPage;

import org.testng.annotations.Test;

public class UserLoginTests extends TestBase {

    HomePage homePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    LogoutPage logoutPage;

    @Test(priority = 1, dataProvider = "LoginTest" , dataProviderClass = DataProvider.class)
    public void userLogin(String email, String password){

        test = ExtentReportClass.createTest("Login test - "+ email);
        test.info("Test is Starting..");
        LoggerClass.logInfo("Test Started!");

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        myAccountPage = new MyAccountPage(driver);
        logoutPage = new LogoutPage(driver);

        homePage.clickDropdownMyAct();
        test.info("Getting to logging page...");
        homePage.clickAccLogin();

        test.info("Entering email...");
        loginPage.setInputEmail(email);

        test.info("Entering password...");
        loginPage.setInputPassword(password);

        loginPage.clickLogin();

        try {
            Assert.assertTrue(myAccountPage.myAccountHeaderMassage());
            test.pass("Logged in to the system!");
            myAccountPage.clickMyAccDropDown();
            myAccountPage.clickMyAccLogOut();
            TestBase.getToMainURL();

        } catch (AssertionError e) {
            test.fail("Failed! "+e.getMessage());
            TestBase.getToMainURL();
            throw e;
        }

        LoggerClass.logInfo("Test Finished!");
    }


}
