package tests;

import base.testBase;
import utils.extentReportClass;
import utils.loggerClass;

import org.testng.Assert;
import page.homePage;
import page.loginPage;
import page.myAccountPage;

import org.testng.annotations.Test;

public class test_TC02_UserLogin extends testBase {

    @Test(priority = 1)
    void userLogin(){
        test = extentReportClass.createTest("Login test.");
        test.info("Test is Starting..");
        loggerClass.logInfo("Test is Starting...");
        homePage hp = new homePage(driver);
        loginPage lp = new loginPage(driver);
        myAccountPage ap = new myAccountPage(driver);

        hp.clickDropdownMyAct();
        test.info("Getting to logging page...");
        loggerClass.logInfo("Getting to logging page...");
        hp.clickAccLogin();
        test.info("Entering email...");
        loggerClass.logInfo("Entering email...");
        lp.setInputEmail(property.getProperty("email1"));
        test.info("Entering password...");
        loggerClass.logInfo("Entering password...");
        lp.setInputPassword(property.getProperty("password1"));
        test.info("Logging in to the system...");
        loggerClass.logInfo("Logging in to the system...");
        lp.clickLogin();
        Assert.assertEquals(ap.msgH1MyAccount(),"My Account");
        test.pass("Logged in to the system!");
        loggerClass.logInfo("Logged in to the system!");
    }

}
