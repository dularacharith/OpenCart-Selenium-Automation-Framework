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

    //VALIDATE USER LOGIN
    @Test(priority = 1, dataProvider = "LoginTest" , dataProviderClass = DataProvider.class)
    public void userLoginTest(String email, String password){

        test = ExtentReportClass.createTest("USER LOGIN test "+email);
        test.info("Test Started! "+getClass());
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
            LoggerClass.logInfo("Test Passed!");
            TestBase.getToMainURL();

        } catch (AssertionError e) {
            test.fail("Failed! "+e.getMessage());
            LoggerClass.logInfo("Test Failed!");
            TestBase.getToMainURL();
            Assert.fail();
        }
    }

    //VALIDATE LOGGING ERROR MASSAGE DISPLAYED WHEN CREDENTIALS WRONG
    @Test(priority = 2)
    public void validateLoginErrorTest(){
        LoggerClass.logInfo("Test Started! "+getClass());
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        test = ExtentReportClass.createTest("LOGGING ERROR MASSAGE DISPLAYED WHEN CREDENTIALS WRONG test");

        homePage.clickDropdownMyAct();
        homePage.clickAccLogin();

        loginPage.setInputEmail("abcd@demo.site");
        loginPage.setInputPassword("abc12345");
        loginPage.clickLogin();

        try {
            Assert.assertTrue(loginPage.isLoginFailedMassageDisplayed());
            test.pass("Error massage is displayed!");
            LoggerClass.logInfo("Test Passed!");
            TestBase.getToMainURL();
        }
        catch (AssertionError e){
            test.fail("Failed! "+e.getMessage());
            LoggerClass.logInfo("Test Failed!");
            TestBase.getToMainURL();
            Assert.fail();
        }
    }

    //VALIDATE LOGIN ATTEMPTS
    @Test(priority = 3)
    public void userLoginAttemptsTest(){
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        test = ExtentReportClass.createTest("LOGIN ATTEMPTS test!");

        LoggerClass.logInfo("Test Started! "+getClass());

        homePage.clickDropdownMyAct();
        homePage.clickAccLogin();
        loginPage.setInputEmail("abcdg@demo.site");

        for(int i=0;i<6;i++){
        loginPage.clickLogin();
    }
        try {
            Assert.assertTrue(loginPage.loginAttemptMassage());
            test.pass("Test Passed");
            LoggerClass.logInfo("Test Passed!");
            TestBase.getToMainURL();
        }
        catch (AssertionError e){
            test.fail("Test Failed "+e.getMessage());
            LoggerClass.logInfo("Test Failed!");
            TestBase.getToMainURL();
            Assert.fail();
        }
    }

    //VALIDATE CLICK BACK BUTTON AFTER LOGIN SHOULDN'T LOGOUT
    @Test(priority = 4)
    public void loginAndBackButtonTest() throws InterruptedException{
        LoggerClass.logInfo("Test Started! "+getClass());
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        myAccountPage = new MyAccountPage(driver);
        test = ExtentReportClass.createTest("CLICK BACK BUTTON AFTER LOGIN test");

        homePage.clickDropdownMyAct();
        homePage.clickAccLogin();

        loginPage.setInputEmail("dulara@demo.com");
        loginPage.setInputPassword("dul1234");
        loginPage.clickLogin();

        try {
            Assert.assertTrue(myAccountPage.myAccountHeaderMassage());
            test.info("User Logged in!");
        }
        catch (AssertionError e){
            test.fail("Test Failed! "+e.getMessage());
            LoggerClass.logInfo("Test Failed!");
            Assert.fail();
        }

        try {
            driver.navigate().back();
            Assert.assertFalse(loginPage.sessionTokenExpireMsg());
            test.pass("User Stayed logged in!");
            LoggerClass.logInfo("Test Passed!");
        }
        catch (AssertionError e){
            test.fail("Test Failed! User logged out! "+e.getMessage());
            LoggerClass.logInfo("Test Failed!");
            Assert.fail();
        }
    }



}
