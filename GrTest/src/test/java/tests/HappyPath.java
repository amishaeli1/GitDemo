package tests;

import Utils.Base;
import Utils.Utilities;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HappyPath extends Base {


    @BeforeTest
    public void killAllNodes() throws IOException, InterruptedException {
        //killall node in mac = taskkill /F /IM node.exe in windows
        Runtime.getRuntime().exec("killall node");
        Thread.sleep(3000);
    }

    @Test
    public void happyPath() throws InterruptedException, IOException {
        service = startServer();

        AndroidDriver<AndroidElement> driver = capabilities("App5.7");
//        AndroidDriver<AndroidElement> driver = capabilities("App5.7");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Utilities utilities = new Utilities(driver);
        utilities.loginDemoDriverManagerUser("asaf.demo6", "qqqqqqq4");
        utilities.approveOnBoardingDriverManagerUser();
        utilities.approveFtueScreensDriverManagerUser();
        utilities.scrollTo("Log out");
        utilities.getAppVersion("Version: 5.7.0 (300000835)");


        AndroidDriver<AndroidElement> driver2 = capabilities("App5.8");
        driver2.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver2.launchApp();
        Thread.sleep(3000);
        utilities.launchSettingsScreen();
        utilities.scrollTo("Log out");
        utilities.getAppVersion("Version: 5.8.0 (300000847)");
        System.out.println("Happy Happy Joy joy");

        service.stop();
    }
}
