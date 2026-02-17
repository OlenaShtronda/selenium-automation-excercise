package com.olena.automation.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreatedPage extends BasePage {
    private final By accountCreatedHeading = By.xpath("//b[text()='Account Created!']");
    private final By continueBtn = By.cssSelector("a[data-qa='continue-button']");

    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyAccountCreatedHeadingIsVisible() {
        return isVisible(accountCreatedHeading);
    }

    public void clickContinue() {
        click(continueBtn);
    }
}