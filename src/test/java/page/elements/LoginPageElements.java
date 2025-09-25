package page.elements;

public class LoginPageElements {

    public static final String xpathEmail = "//input[@id='input-email']";
    public static final String xpathPassword = "//input[@id='input-password']";
    public static final String xpathForgotPw = "//div[@class='mb-3']//a[normalize-space()='Forgotten Password']";
    public static final String xpathLoginBtn = "//button[text()='Login']";
    public static final String xpathErrorAlert = "//div[@class='alert alert-danger alert-dismissible']";
    public static final String xpathLogoutAttemptsExceed = "//div[@class='alert alert-danger alert-dismissible'][contains(text(),'Your account has')]";
    public static final String xpathSessionToken = "//div[@class='alert alert-danger alert-dismissible'][contains(text(),'Invalid token')]";
    public static final String xpathTitleReturningCustomer = "//h2[normalize-space()='Returning Customer']";
}
