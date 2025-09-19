package tests;
import base.testBase;
import org.testng.Assert;
import page.homePage;
import page.registerPage;
import org.testng.annotations.Test;

public class test_TC01_UserRegistration extends testBase {

    @Test(priority = 1)
    protected void userRegistration(){
        homePage hp = new homePage(driver);
        registerPage rp = new registerPage(driver);

        hp.clickDropdownMyAct();
        hp.clickAccRegister();

        rp.setInputFirstName(property.getProperty("firstName1"));
        rp.setInputLastName(property.getProperty("lastName1"));
        rp.setInputEmail(property.getProperty("email1"));
        rp.setInputPassword(property.getProperty("password1"));
        rp.clickCheckboxSubscribe();
        rp.clickPrivacyPolicyAgree();
        rp.clickContinue();
        Assert.assertEquals(rp.textOfSuccessMsg(),"Your Account Has Been Created!");
        rp.clickContinueAfterRegister();
}







}
