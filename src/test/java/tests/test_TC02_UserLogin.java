package tests;

import base.testBase;
import utils.extentReportClass;
import utils.loggerClass;
import utils.dataProvider;

import org.testng.Assert;
import page.homePage;
import page.loginPage;
import page.myAccountPage;
import page.logoutPage;

import org.testng.annotations.Test;

public class test_TC02_UserLogin extends testBase {

    homePage hp;
    loginPage lp;
    myAccountPage ap;
    logoutPage loutp;

    @Test(priority = 1, dataProvider = "LoginTest" , dataProviderClass = dataProvider.class)
    public void userLogin(String email, String password){

        test = extentReportClass.createTest("Login test - "+ email);
        test.info("Test is Starting..");
        loggerClass.logInfo("Test is Starting...");

        hp = new homePage(driver);
        lp = new loginPage(driver);
        ap = new myAccountPage(driver);
        loutp = new logoutPage(driver);

        hp.clickDropdownMyAct();
        test.info("Getting to logging page...");
        loggerClass.logInfo("Getting to logging page...");
        hp.clickAccLogin();

        test.info("Entering email...");
        loggerClass.logInfo("Entering email...");
        lp.setInputEmail(email);

        test.info("Entering password...");
        loggerClass.logInfo("Entering password...");
        lp.setInputPassword(password);

        lp.clickLogin();
        loggerClass.logInfo("Login in....");

        if(lp.isLoginFailedMassageDisplayed()){
            Assert.assertTrue(true);
            loggerClass.logInfo("Login Credentials invalid");
            test.fail("Login Failed");
        }
        else{
            Assert.assertTrue(ap.ismsgH1MyAccountDisplayed());
            test.pass("Logged in to the system!");
            loggerClass.logInfo("Logged in to the system!");
            ap.clickMyAccDropDown();
            ap.clickMyAccLogOut();
        }
    }


}
