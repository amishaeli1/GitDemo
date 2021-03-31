package tests;

import Utils.Base;
import Utils.Utilities;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;

public class AndroidUpdate  extends Base {
    private String APP_PKG = "com.greenroad.mobile.drive";
    private String APP_ACT = "com.greenroad.mobile.asimov.activities.GatewayActivity";

    private String APP_V1_0_0 = "/Users/asaf.mishaeli/Development/GrTest/src/greenroad-asimov-prod-release-5.7.0.300000835.apk";
    private String APP_V1_0_1 = "/Users/asaf.mishaeli/Development/GrTest/src/greenroad-asimov-prod-release-5.8.0.300000847.apk";

    private String TEST_MESSAGE = "Version: 5.8.0 (300000847)";
//
//    private By msgInput = MobileBy.AccessibilityId("messageInput");
//    private By savedMsg = MobileBy.AccessibilityId(TEST_MESSAGE);
//    private By saveMsgBtn = MobileBy.AccessibilityId("messageSaveBtn");
//    private By echoBox = MobileBy.AccessibilityId("Echo Box");
    private By settingsBtn = MobileBy.id("com.greenroad.mobile.drive:id/settingsBtn");

    @Test
    public void testUpgradeDemoDMUser() throws IOException, InterruptedException {
        service = startServer();
//        DesiredCapabilities capabilities = new DesiredCapabilities();

        AndroidDriver<AndroidElement> driver = capabilities("App5.7");

//        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("deviceName", "Android_Emulator2");
//        capabilities.setCapability("automationName", "UiAutomator2");
//        capabilities.setCapability("app", APP_V1_0_0);

        // change this to APP_V1_0_1 to experience a failing scenario
        String appUpgradeVersion = APP_V1_0_1;

        Utilities utilities = new Utilities(driver);
        utilities.loginDemoDriverManagerUser("asaf.demo6", "qqqqqqq4");
        utilities.approveOnBoardingDriverManagerUser();
        utilities.approveFtueScreensDriverManagerUser();
        utilities.scrollTo("Log out");
        utilities.getAppVersion("Version: 5.7.0 (300000835)");

        // Open the app.
//        AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);

        WebDriverWait wait = new WebDriverWait(driver, 10);

        try {
//            wait.until(ExpectedConditions.presenceOfElementLocated(echoBox)).click();
//            wait.until(ExpectedConditions.presenceOfElementLocated(settingsBtn)).click();
//            wait.until(ExpectedConditions.presenceOfElementLocated(msgInput)).sendKeys(TEST_MESSAGE);
//            wait.until(ExpectedConditions.presenceOfElementLocated(saveMsgBtn)).click();
//            String savedText = wait.until(ExpectedConditions.presenceOfElementLocated(savedMsg)).getText();
//            Assert.assertEquals(savedText, TEST_MESSAGE);

            driver.installApp(appUpgradeVersion);
//            Activity activity = new Activity(APP_PKG, APP_ACT);
//            driver.startActivity(activity);

//            utilities.launchDriveApp();
            utilities.launchDriveApp2();
            wait.until(ExpectedConditions.presenceOfElementLocated(settingsBtn)).click();
            utilities.scrollTo("Log out");
            utilities.getAppVersion(TEST_MESSAGE);
            driver.pressKey(new KeyEvent(AndroidKey.HOME));
//            savedText = wait.until(ExpectedConditions.presenceOfElementLocated(savedMsg)).getText();
//            Assert.assertEquals(savedText, TEST_MESSAGE);
        } finally {
            driver.quit();
        }
        service.stop();
    }

    @Test
    public void testUpgradeDemoDMUser2 () throws IOException, InterruptedException {
        service = startServer();
        AndroidDriver<AndroidElement> driver = capabilities("App5.7");

        String appUpgradeVersion = APP_V1_0_1;

        Utilities utilities = new Utilities(driver);
        utilities.loginDemoDriverManagerUser("amishaeli.prod", "qqqqqqq2");
        utilities.approveOnBoardingDriverManagerUser();
        utilities.approveFtueScreensDriverManagerUser();
        utilities.scrollTo("Log out");
        utilities.getAppVersion("Version: 5.7.0 (300000835)");

        WebDriverWait wait = new WebDriverWait(driver, 10);

        try {
            driver.installApp(appUpgradeVersion);

            utilities.launchDriveApp2();
            wait.until(ExpectedConditions.presenceOfElementLocated(settingsBtn)).click();
            utilities.scrollTo("Log out");
            utilities.getAppVersion(TEST_MESSAGE);
            driver.pressKey(new KeyEvent(AndroidKey.HOME));

        } finally {
            driver.quit();
        }
        service.stop();
    }
}
