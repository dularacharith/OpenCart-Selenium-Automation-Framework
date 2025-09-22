package tests;
import base.testBase;
import org.testng.Assert;

import page.homePage;
import page.logoutPage;
import page.myAccountPage;
import page.registerPage;
import page.logoutPage;
import page.myAccountPage;

import utils.loggerClass;
import utils.dataProvider;
import utils.extentReportClass;

import org.testng.annotations.Test;

public class test_TC01_UserRegistration extends testBase {
    registerPage rp;
    homePage hp;
    logoutPage loutp;
    myAccountPage ap;


    @Test(priority = 1, dataProvider = "RegisterTest", dataProviderClass = dataProvider.class)
    public void userRegistration(String fname,String lname,String email, String password){

        test = extentReportClass.createTest("Registration Test_"+email);

        hp = new homePage(driver);
        rp = new registerPage(driver);
        loutp = new logoutPage(driver);
        ap = new myAccountPage(driver);

        hp.clickDropdownMyAct();
        loggerClass.logInfo("Getting Account register page...");
        test.info("Navigationg to Register Page.");
        hp.clickAccRegister();

        loggerClass.logInfo("Entering first name...");
        test.info("Entering first name.");
        rp.setInputFirstName(fname);

        loggerClass.logInfo("Entering last name...");
        test.info("Entering last name.");
        rp.setInputLastName(lname);

        loggerClass.logInfo("Entering email...");
        test.info("Entering email.");
        rp.setInputEmail(email);

        loggerClass.logInfo("Entering password...");
        test.info("Entering password.");
        rp.setInputPassword(password);

        loggerClass.logInfo("Checking subscribe...");
        test.info("Checking subscribe.");
        rp.clickCheckboxSubscribe();

        loggerClass.logInfo("Agreeing privacy policy...");
        test.info("Agreeing privacy policy.");
        rp.clickPrivacyPolicyAgree();
        rp.clickContinue();

        if (rp.textOfSuccessMsg().equals("Your Account Has Been Created!")){
            loggerClass.logInfo("Account has been created...");
            test.pass("Account has been created!");
            rp.clickContinueAfterRegister();

            test.info("Directing to Logout");
            loggerClass.logInfo("Directing to logout..");
            ap.clickMyAccDropDown();
            ap.clickMyAccLogOut();
            loggerClass.logInfo("Logged Out!");
            test.pass("Logged out");
            loutp.clickAccountLogoutCnt();
        }

        else {
            loggerClass.logInfo("Account did not create..");
            test.fail("Account did not create!");
            Assert.fail();
        }

}
}
