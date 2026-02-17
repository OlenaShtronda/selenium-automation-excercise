package com.olena.automation.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private final By homeLogo = By.cssSelector(".logo");
    private final By signupLoginBtn = By.cssSelector("a[href='/login']");
    private final By loggedInUsername = By.xpath("//a[contains(text(),'Logged in as')]/b");
    private final By deleteAccountBtn = By.cssSelector("a[href='/delete_account']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyHomePageIsVisible() {
        return isVisible(homeLogo);
    }

    public void clickSignupLogin() {
        click(signupLoginBtn);
    }

    public void clickDeleteAccountBtn() {
        click(deleteAccountBtn);
    }

    public boolean verifyUserIsLoggedIn(String username) {
        return getText(loggedInUsername).equalsIgnoreCase(username);
    }
}