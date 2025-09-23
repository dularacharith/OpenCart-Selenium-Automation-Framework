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

public class Test_TC01_UserRegistration extends TestBase {
    RegisterPage rp;
    HomePage hp;
    LogoutPage loutp;
    MyAccountPage ap;


    @Test(priority = 1, dataProvider = "RegisterTest", dataProviderClass = DataProvider.class)
    public void userRegistration(String fname,String lname,String email, String password){

        test = ExtentReportClass.createTest("Registration Test_"+email);

        hp = new HomePage(driver);
        rp = new RegisterPage(driver);
        loutp = new LogoutPage(driver);
        ap = new MyAccountPage(driver);

        hp.clickDropdownMyAct();
        LoggerClass.logInfo("Getting Account register page...");
        test.info("Navigationg to Register Page.");
        hp.clickAccRegister();

        LoggerClass.logInfo("Entering first name...");
        test.info("Entering first name.");
        rp.setInputFirstName(fname);

        LoggerClass.logInfo("Entering last name...");
        test.info("Entering last name.");
        rp.setInputLastName(lname);

        LoggerClass.logInfo("Entering email...");
        test.info("Entering email.");
        rp.setInputEmail(email);

        LoggerClass.logInfo("Entering password...");
        test.info("Entering password.");
        rp.setInputPassword(password);

        LoggerClass.logInfo("Checking subscribe...");
        test.info("Checking subscribe.");
        rp.clickCheckboxSubscribe();

        LoggerClass.logInfo("Agreeing privacy policy...");
        test.info("Agreeing privacy policy.");
        rp.clickPrivacyPolicyAgree();
        rp.clickContinue();

        String acctualMassage = rp.textOfSuccessMsg();
        String expectedMassage = "Your Account Has Been Created!";

        try {
            Assert.assertEquals(acctualMassage,expectedMassage);
        }
        catch (AssertionError e){
            test.fail("Failed! "+e.getMessage());
            driver.get(property.getProperty("baseURL"));
            throw e;
        }
        LoggerClass.logInfo("Account has been created...");
        test.pass("Account has been created!");
        rp.clickContinueAfterRegister();

        ap.clickMyAccDropDown();
        ap.clickMyAccLogOut();

        LoggerClass.logInfo("Logged Out!");
        test.pass("Logged out");
        loutp.clickAccountLogoutCnt();

}
}
