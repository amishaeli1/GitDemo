package tests;

import Utils.Base;
import Utils.TestData;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.PreferencesPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ApiDemoTest extends Base {

    @BeforeTest
    public void killAllNodes() throws IOException, InterruptedException {
        //killall node in mac = taskkill /F /IM node.exe in windows
        Runtime.getRuntime().exec("killall node");
        Thread.sleep(3000);
    }

    @Test(dataProvider = "InputData", dataProviderClass = TestData.class)
    public void apiDemo(String input) throws IOException, InterruptedException {
        service = startServer();

        AndroidDriver<AndroidElement> driver = capabilities("apiDemo");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        HomePage h = new HomePage(driver);
//		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        h.preferences.click();

        PreferencesPage p = new PreferencesPage(driver);
//		driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
        p.dependencies.click();


//		driver.findElementById("android:id/checkbox").click();
        h.checkBox.click();

//		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
        h.RelativeLayout.click();

//		driver.findElementByClassName("android.widget.EditText").sendKeys("hello");
        //Will take the input 2 times from TestData class
        h.EditText.sendKeys(input);

//		driver.findElementsByClassName("android.widget.Button").get(1).click();
        p.buttons.get(1).click();

        System.out.println("Arrived Here Basics");
        service.stop();
    }



}
