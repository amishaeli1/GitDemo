package Utils;

import AppScreens.FtueScreen;
import AppScreens.LoginScreen;
import AppScreens.OnBoarding;
import AppScreens.SettingsScreen;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.tools.ant.taskdefs.WaitFor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.FileNotFoundException;
import java.io.IOException;


public class Utilities {
    AndroidDriver<AndroidElement> driver;

    public Utilities(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
    }

    public Utilities() {
    }

    public void scrollToText(String text) {
        driver.findElementsByAndroidUIAutomator(
                "new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));");

    }

    public void scrollTo(String selector) {
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + selector + "\").instance(0))"));

    }

    public void loginDemoDriverManagerUser(String userName, String password) throws InterruptedException, IOException {
        LoginScreen loginScreen = new LoginScreen(driver);
        loginScreen.getUserName().sendKeys(userName);
        loginScreen.nextButton.click();
        Thread.sleep(10000);

        loginScreen.getPassword().sendKeys(password);
        loginScreen.loginButton.click();
        Thread.sleep(10000);
    }

    public void approveOnBoardingDriverManagerUser() throws InterruptedException {
        OnBoarding onBoarding = new OnBoarding(driver);
        onBoarding.demoUserScreen1LetsGo.click();
        Thread.sleep(1500);
        onBoarding.bgPopupButtons.get(1).click();
        Thread.sleep(1500);
        onBoarding.demoUserScreen1LetsGo.click();
        onBoarding.demoUserScreen2Next.click();
        Thread.sleep(1500);
        onBoarding.locationPopupButtons.get(1).click();
        Thread.sleep(1500);
        onBoarding.demoUserScreen2Next.click();
        onBoarding.demoUserScreen3Next.click();
        onBoarding.demoUserScreen4Done.click();
    }

    public void approveFtueScreensDriverManagerUser() throws FileNotFoundException {
        FtueScreen ftueScreen = new FtueScreen(driver);
        ftueScreen.dashboardFtue.click();
        ftueScreen.tripHistoryFtue.click();
        ftueScreen.scoreboardLivemapFtue.click();
        ftueScreen.notificationMyaccountFtue.click();
        ftueScreen.viewbyManualtripstartFtue.click();
        ftueScreen.settingsBtn.click();
        ftueScreen.settingsFtue.click();
    }

    public void getAppVersion(String appVersion) throws FileNotFoundException {
        SettingsScreen settingsScreen = new SettingsScreen(driver);
        String appVersion1 = settingsScreen.appVersion.getText();
        assert(appVersion1.contains(appVersion));
    }

    public void launchSettingsScreen() throws FileNotFoundException {
        FtueScreen ftueScreen = new FtueScreen(driver);
        ftueScreen.settingsBtn.click();
    }

    public void launchDriveApp() throws FileNotFoundException {
        FtueScreen ftueScreen = new FtueScreen(driver);
        ftueScreen.driveApp.click();
    }

    public void launchDriveApp2() throws FileNotFoundException {
        FtueScreen ftueScreen = new FtueScreen(driver);
        ftueScreen.appsList.click();
        ftueScreen.driveApp.click();
    }


}
