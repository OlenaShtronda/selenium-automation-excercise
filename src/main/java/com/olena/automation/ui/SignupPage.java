package com.olena.automation.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SignupPage extends BasePage {
    private final By enterAccountInformationHeading = By.xpath("//h2/b[normalize-space()='Enter Account Information']");
    private final By titleMrsRadio = By.id("id_gender2");
    private final By titleMrRadio = By.id("id_gender1");
    private final By passwordField = By.id("password");
    private final By dayDropdown = By.id("days");
    private final By monthDropdown = By.id("months");
    private final By yearDropdown = By.id("years");
    private final By newsletterCheckbox = By.id("newsletter");
    private final By specialOffersCheckbox = By.id("optin");
    private final By firstNameField = By.id("first_name");
    private final By lastNameField = By.id("last_name");
    private final By companyField = By.id("company");
    private final By address1Field = By.id("address1");
    private final By address2Field = By.id("address2");
    private final By countryDropdown = By.id("country");
    private final By stateField = By.id("state");
    private final By cityField = By.id("city");
    private final By zipcodeField = By.id("zipcode");
    private final By mobileNumberField = By.id("mobile_number");
    private final By createAccountButton = By.cssSelector("button[data-qa='create-account']");

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyEnterAccountInformationHeadingIsVisible() {
        return isVisible(enterAccountInformationHeading);
    }

    public void selectTitle(String title) {
        if (title.equalsIgnoreCase("Mr")) {
            click(titleMrRadio);
        } else {
            click(titleMrsRadio);
        }
    }

    public void enterPassword(String password) {
        type(passwordField, password);
    }

    public void selectDateOfBirth(String day, String month, String year) {
        new Select(waitForVisibility(dayDropdown)).selectByValue(day);
        new Select(waitForVisibility(monthDropdown)).selectByValue(month);
        new Select(waitForVisibility(yearDropdown)).selectByValue(year);
    }

    public void selectNewsletterCheckbox() {
        click(newsletterCheckbox);
    }

    public void selectSpecialOffersCheckbox() {
        click(specialOffersCheckbox);
    }

    public void fillAddressDetails(String firstName,
                                   String lastName,
                                   String company,
                                   String address1,
                                   String address2,
                                   String country,
                                   String state,
                                   String city,
                                   String zipcode,
                                   String mobileNumber) {

        type(firstNameField, firstName);
        type(lastNameField, lastName);
        type(companyField, company);
        type(address1Field, address1);
        type(address2Field, address2);

        new Select(waitForVisibility(countryDropdown)).selectByVisibleText(country);

        type(stateField, state);
        type(cityField, city);
        type(zipcodeField, zipcode);
        type(mobileNumberField, mobileNumber);
    }

    public void clickCreateAccount() {
        click(createAccountButton);
    }
}
