package com.olena.automation.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By newUserSignupHeading = By.xpath("//h2[text()='New User Signup!']");
    private final By loginToYourAccountHeading = By.xpath("//h2[text()='Login to your account']");
    private final By loginEmailField = By.cssSelector("input[data-qa='login-email']");
    private final By loginPasswordField = By.cssSelector("input[data-qa='login-password']");
    private final By signUpNameField = By.name("name");
    private final By signUpEmailField = By.cssSelector("input[data-qa='signup-email']");
    private final By signupBtn = By.cssSelector("button[data-qa='signup-button']");
    private final By loginBtn = By.cssSelector("button[data-qa='login-button']");
    private final By incorrectEmailOrPasswordErrorMessage = By.xpath("//p[text()='Your email or password is incorrect!']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyNewUserSignupHeadingIsVisible() {
        return isVisible(newUserSignupHeading);
    }

    public boolean verifyLoginToYourAccountHeadingIsVisible() {
        return isVisible(loginToYourAccountHeading);
    }

    public String getLoginPageURL() {
        return driver.getCurrentUrl();
    }

    public void fillSignUpForm(String name, String email) {
        type(signUpNameField, name);
        type(signUpEmailField, email);
    }

    public void fillLoginForm(String email, String password) {
        type(loginEmailField, email);
        type(loginPasswordField, password);
    }

    public void clearLoginForm() {
        waitForVisibility(loginEmailField).clear();
        waitForVisibility(loginPasswordField).clear();
    }

    public void clickSignupBtn() {
        click(signupBtn);
    }

    public void clickLoginBtn() {
        click(loginBtn);
    }

    public boolean verifyIncorrectEmailOrPasswordErrorMessageIsVisible() {
        return isVisible(incorrectEmailOrPasswordErrorMessage);
    }
}
