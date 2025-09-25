package tests;

import base.TestBase;
import org.testng.annotations.AfterMethod;
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

        test = ExtentReportClass.createTest("USER LOGIN TEST "+email);
        LoggerClass.logInfo("TEST STARTED!");

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
            LoggerClass.logInfo("TEST PASSED!");
            TestBase.getToMainURL();

        } catch (AssertionError e) {
            test.fail("TEST FAILED! "+e.getMessage());
            LoggerClass.logInfo("TEST FAILED!");
            TestBase.getToMainURL();
            Assert.fail();
        }
    }

    //VALIDATE LOGGING ERROR MASSAGE DISPLAYED WHEN CREDENTIALS WRONG
    @Test(priority = 2)
    public void validateLoginErrorTest(){
        LoggerClass.logInfo("TEST STARTED! "+getClass());
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        test = ExtentReportClass.createTest("ERROR MASSAGE WHEN CREDENTIALS WRONG TEST");

        homePage.clickDropdownMyAct();
        homePage.clickAccLogin();

        loginPage.setInputEmail("abcd@demo.site");
        loginPage.setInputPassword("abc12345");
        loginPage.clickLogin();

        try {
            Assert.assertTrue(loginPage.isLoginFailedMassageDisplayed());
            test.pass("TEST PASSED! error massage is displayed.");
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

    //VALIDATE LOGIN ATTEMPTS
    @Test(priority = 3)
    public void userLoginAttemptsTest() throws InterruptedException{
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        test = ExtentReportClass.createTest("LOGIN ATTEMPTS TEST");

        LoggerClass.logInfo("TEST STARTED! "+getClass());

        homePage.clickDropdownMyAct();
        homePage.clickAccLogin();
        loginPage.setInputEmail("abcd@demo.site");

        try {
            for(int i=0;i<6;i++){
                loginPage.clickLogin();
            }
            Thread.sleep(500);
            Assert.assertTrue(loginPage.loginAttemptMassage());
            test.pass("TEST PASSED! Massage displayed");
            LoggerClass.logInfo("TEST PASSED!");
            TestBase.getToMainURL();
        }
        catch (AssertionError e){
            test.fail("TEST FAILED! Massage no displayed! "+e.getMessage());
            LoggerClass.logInfo("TEST FAILED!");
            TestBase.getToMainURL();
            Assert.fail();
        }
    }

    //VALIDATE CLICK BACK BUTTON AFTER LOGIN SHOULDN'T LOGOUT
    @Test(priority = 4)
    public void loginAndBackButtonTest() throws InterruptedException{
        LoggerClass.logInfo("TEST STARTED! "+getClass());
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
            test.fail("TEST FAILED! "+e.getMessage());
            LoggerClass.logInfo("TEST FAILED!");
            Assert.fail();
        }

        try {
            driver.navigate().back();
            Assert.assertFalse(loginPage.sessionTokenExpireMsg());
            test.pass("TEST PASSED! user Stayed logged in");
            LoggerClass.logInfo("TEST PASSED!");
        }
        catch (AssertionError e){
            test.fail("TEST FAILED! User logged out! "+e.getMessage());
            LoggerClass.logInfo("TEST FAILED!");
            Assert.fail();
        }
    }

    //VALIDATE PLACEHOLDERS
    @Test(priority = 5)
    public void placeholderVisibilityTest(){
        LoggerClass.logInfo("TEST STARTED! "+getClass());
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        test = ExtentReportClass.createTest("PLACEHOLDERS VISIBILITY TEST");

        homePage.clickDropdownMyAct();
        homePage.clickAccLogin();

        String acctualEmailPlaceholder = loginPage.placeholderTextInEmail();
        String expectedEmailPlaceholder = ExpectedResults.emailPlaceholder;

        String acctualPasswordPlaceholder = loginPage.placeholderTextInPassword();
        String expectedPasswordPlaceholder = ExpectedResults.passwordPlaceholder;

        try {
            Assert.assertEquals(acctualEmailPlaceholder,expectedEmailPlaceholder);
            test.pass("TEST PASSED! '"+expectedEmailPlaceholder+"' Placeholder is Displayed in email field");
            LoggerClass.logInfo("TEST PASSED!");
        }
        catch (AssertionError e){
            test.fail("TEST FAILED! placeholder not displayed in Email");
            LoggerClass.logInfo("TEST FAILED!");
        }
        try {
            Assert.assertEquals(acctualPasswordPlaceholder,expectedPasswordPlaceholder);
            test.pass("TEST PASSED! '"+expectedPasswordPlaceholder+"' Placeholder is Displayed in password field");
            LoggerClass.logInfo("TEST PASSED!");
        }
        catch (AssertionError e){
            test.fail("TEST FAILED! Placeholder not displayed in Password!");
            LoggerClass.logInfo("TEST FAILED!");
            Assert.fail();
        }
    }

    @AfterMethod
    public void getURL(){
        TestBase.getToMainURL();
    }


}
