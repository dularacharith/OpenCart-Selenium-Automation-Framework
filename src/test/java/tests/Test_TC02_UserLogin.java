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

public class Test_TC02_UserLogin extends TestBase {

    HomePage hp;
    LoginPage lp;
    MyAccountPage ap;
    LogoutPage loutp;

    @Test(priority = 1, dataProvider = "LoginTest" , dataProviderClass = DataProvider.class)
    public void userLogin(String email, String password){

        test = ExtentReportClass.createTest("Login test - "+ email);
        test.info("Test is Starting..");
        LoggerClass.logInfo("Test is Starting...");

        hp = new HomePage(driver);
        lp = new LoginPage(driver);
        ap = new MyAccountPage(driver);
        loutp = new LogoutPage(driver);

        hp.clickDropdownMyAct();
        test.info("Getting to logging page...");
        LoggerClass.logInfo("Getting to logging page...");
        hp.clickAccLogin();

        test.info("Entering email...");
        LoggerClass.logInfo("Entering email...");
        lp.setInputEmail(email);

        test.info("Entering password...");
        LoggerClass.logInfo("Entering password...");
        lp.setInputPassword(password);

        lp.clickLogin();
        LoggerClass.logInfo("Login in....");

        try {
            Assert.assertTrue(ap.myAccountHeaderMassage());
        } catch (AssertionError e) {
            test.fail("Failed! "+e.getMessage());
            throw e;
        }

        test.pass("Logged in to the system!");
        LoggerClass.logInfo("Logged in to the system!");
        ap.clickMyAccDropDown();
        ap.clickMyAccLogOut();
    }


}
