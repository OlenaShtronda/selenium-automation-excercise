package com.olena.automation.ui;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.Assert;
import org.testng.annotations.*;
import com.github.javafaker.Faker;

@Listeners({AllureTestNg.class})
@Epic("Authentication")
@Feature("Registration")
public class RegistrationTests extends BaseTest {

    @Story("Valid registration")
    @Test(description = "User should be able to register with valid credentials")
    void verifyUserCanRegister() {
        Faker faker = new Faker();

        String name = faker.name().firstName();
        String email = faker.internet().emailAddress();

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.verifyHomePageIsVisible(), "Home page is not visible");
        homePage.clickSignupLogin();

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.verifyNewUserSignupHeadingIsVisible(), "'New User Signup!' heading is not visible");
        loginPage.fillSignUpForm(name, email);
        loginPage.clickSignupBtn();

        SignupPage signupPage = new SignupPage(driver);
        Assert.assertTrue(signupPage.verifyEnterAccountInformationHeadingIsVisible(), "'ENTER ACCOUNT INFORMATION' heading is not visible");
        signupPage.selectTitle("Mrs");
        signupPage.enterPassword("TestPassword123");
        signupPage.selectDateOfBirth("10", "5", "1995");

        signupPage.selectNewsletterCheckbox();
        signupPage.selectSpecialOffersCheckbox();

        signupPage.fillAddressDetails(
                name,
                faker.name().lastName(),
                faker.company().name(),
                faker.address().streetAddress(),
                faker.address().secondaryAddress(),
                "United States",
                faker.address().state(),
                faker.address().city(),
                faker.address().zipCode(),
                faker.phoneNumber().cellPhone()
        );

        signupPage.clickCreateAccount();

        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
        Assert.assertTrue(accountCreatedPage.verifyAccountCreatedHeadingIsVisible(), "'ACCOUNT CREATED!' is not visible");
        accountCreatedPage.clickContinue();

        Assert.assertTrue(homePage.verifyUserIsLoggedIn(name), "'Logged in as username' is not visible");
        homePage.clickDeleteAccountBtn();

        AccountDeletedPage accountDeletedPage = new AccountDeletedPage(driver);
        Assert.assertTrue(accountDeletedPage.verifyAccountDeletedHeadingIsVisible(), "'ACCOUNT DELETED!' is not visible");
        accountDeletedPage.clickContinue();
    }
}
