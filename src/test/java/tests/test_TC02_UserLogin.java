package tests;

import base.testBase;
import utils.loggerClass;

import org.testng.Assert;
import page.homePage;
import page.loginPage;
import page.myAccountPage;

import org.testng.annotations.Test;

public class test_TC02_UserLogin extends testBase {

    @Test(priority = 1)
    void userLogin(){
        loggerClass.logInfo("Test is Starting...");
        homePage hp = new homePage(driver);
        loginPage lp = new loginPage(driver);
        myAccountPage ap = new myAccountPage(driver);

        hp.clickDropdownMyAct();
        loggerClass.logInfo("Getting to logging page...");
        hp.clickAccLogin();
        loggerClass.logInfo("Entering email...");
        lp.setInputEmail(property.getProperty("email1"));
        loggerClass.logInfo("Entering password...");
        lp.setInputPassword(property.getProperty("password1"));
        loggerClass.logInfo("Logging in to the system...");
        lp.clickLogin();
        Assert.assertEquals(ap.msgH1MyAccount(),"My Account");
        loggerClass.logInfo("Logged in to the system!");
    }

}
