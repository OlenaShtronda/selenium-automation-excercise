package com.olena.automation.ui;

import io.qameta.allure.testng.AllureTestNg;
import org.testng.Assert;
import org.testng.annotations.*;
import io.qameta.allure.*;

@Listeners({AllureTestNg.class})
@Epic("Authentication")
@Feature("Login")
public class LoginTests extends BaseTest {

    @Story("Valid login")
    @Test(description = "User should login with valid credentials")
    void shouldLoginWithValidCredentials() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.verifyHomePageIsVisible(), "Home page is not visible");
        homePage.clickSignupLogin();

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.verifyLoginToYourAccountHeadingIsVisible(), "'Login to your account' heading is not visible");

        String loginEmail = "emailtotest@mail.com";
        String loginPassword = "SRu-}^s7jr!M=u:";
        String loginName = "Jane";

        loginPage.fillLoginForm(loginEmail, loginPassword);
        loginPage.clickLoginBtn();

        Assert.assertTrue(homePage.verifyUserIsLoggedIn(loginName), "'Logged in as username' is not visible");
    }

    @Story("Invalid email")
    @Test(description = "User should not login with incorrect email")
    void shouldRejectLoginWithIncorrectEmail() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.verifyHomePageIsVisible(), "Home page is not visible");
        homePage.clickSignupLogin();

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.verifyLoginToYourAccountHeadingIsVisible(), "'Login to your account' heading is not visible");

        String incorrectLoginEmail = "gmailtotest@mail.com";
        String loginPassword = "SRu-}^s7jr!M=u:";

        loginPage.fillLoginForm(incorrectLoginEmail, loginPassword);
        loginPage.clickLoginBtn();

        Assert.assertTrue(loginPage.verifyIncorrectEmailOrPasswordErrorMessageIsVisible(), "'Your email or password is incorrect!' is not visible");
    }

    @Story("Invalid password")
    @Test(description = "User should not login with incorrect password")
    void shouldRejectLoginWithIncorrectPassword() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.verifyHomePageIsVisible(), "Home page is not visible");
        homePage.clickSignupLogin();

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.verifyLoginToYourAccountHeadingIsVisible(), "'Login to your account' heading is not visible");

        String loginEmail = "emailtotest@mail.com";
        String inCorrectLoginPassword = "SRu-}^s7jr!M=u";

        loginPage.fillLoginForm(loginEmail, inCorrectLoginPassword);
        loginPage.clickLoginBtn();

        Assert.assertTrue(loginPage.verifyIncorrectEmailOrPasswordErrorMessageIsVisible(), "'Your email or password is incorrect!' is not visible");
    }

    @Story("Empty fields")
    @Test(description = "User should not login with empty fields")
    void shouldRejectLoginWithEmptyFields() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.verifyHomePageIsVisible(), "Home page is not visible");
        homePage.clickSignupLogin();

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.verifyLoginToYourAccountHeadingIsVisible(), "'Login to your account' heading is not visible");
        loginPage.clearLoginForm();
        loginPage.clickLoginBtn();

        Assert.assertEquals(loginPage.getLoginPageURL(), "https://automationexercise.com/login");
    }
}

