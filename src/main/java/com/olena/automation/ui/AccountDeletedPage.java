package com.olena.automation.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountDeletedPage extends BasePage {
    private final By accountDeletedHeading = By.xpath("//b[text()='Account Deleted!']");
    private final By continueBtn = By.cssSelector("a[data-qa='continue-button']");

    public AccountDeletedPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyAccountDeletedHeadingIsVisible() {
        return isVisible(accountDeletedHeading);
    }

    public void clickContinue() {
        click(continueBtn);
    }
}
