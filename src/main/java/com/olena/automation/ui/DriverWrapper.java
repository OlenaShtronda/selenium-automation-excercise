package com.olena.automation.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v144.network.Network;
import org.openqa.selenium.devtools.v144.network.model.BlockPattern;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class DriverWrapper {

    private WebDriver driver;

    public void init() {
        // TODO: describe me!
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("autofill.profile_enabled", false);
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);

        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        blockAds();
    }

    private void blockAds() {
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();

        devTools.send(Network.enable(
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty()
        ));

        devTools.send(Network.setBlockedURLs(
                Optional.of(List.of(
                        new BlockPattern("*://*.doubleclick.net/*", true),
                        new BlockPattern("*://*.googlesyndication.com/*", true),
                        new BlockPattern("*://*.adservice.google.com/*", true)
                )),
                Optional.empty()
        ));
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}