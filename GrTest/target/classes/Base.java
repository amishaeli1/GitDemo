package Utils;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class Base {
    public static AppiumDriverLocalService service;
    public static AndroidDriver<AndroidElement> driver;
    public static AndroidDriver<AndroidElement> driver2;

    public AppiumDriverLocalService startServer() throws InterruptedException {
        boolean flag = checkIfServerIsRunning(4723);
        if (!flag) {
            service = AppiumDriverLocalService.buildDefaultService();
            service.start();
            Thread.sleep(6000);
        }
        return service;
    }

    public static boolean checkIfServerIsRunning(int port){
        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try{
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        } catch (IOException e) {
            //If control comes here, then it means that the port is in use
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }

    public static void startEmulator() throws IOException, InterruptedException {
        Runtime.getRuntime().exec((System.getProperty("user.dir")+"/src/main/resources/startEmulator.command"));
        Thread.sleep(6000);
    }

    public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException, InterruptedException {

        FileInputStream fis = new FileInputStream((System.getProperty("user.dir")+"/src/main/java/Utils/global.properties"));
        Properties prop = new Properties();
        prop.load(fis);

        // TODO Auto-generated method stub
        File appDir = new File("src");
        File app = new File(appDir, (String) prop.get(appName));

        DesiredCapabilities cap = new DesiredCapabilities();

        // We no longer need this below line
        String device= (String) prop.get("device");

        // To make the run more Generic, we leave the device field empty inside the global.properties
        // If we go to Termianl and run mvn test-DdeviceName= mvn test -DdeviceName=Android_Emulator
        // All tests will complete successfully
//        String device = System.getProperty("deviceName");
        if (device.contains("Emulator")){
            //Start emulator
            startEmulator();
            Thread.sleep(1000);
        }

        cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);

        String platfornVersion = (String) prop.get("platformVersion");
        cap.setCapability("platformVersion", platfornVersion);

        cap.setCapability("platformName", "Android");
        cap.setCapability("fullReset", "true");

        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "14");
        cap.setCapability(MobileCapabilityType.APP,app.getAbsolutePath());
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public static void getScreenShot(String s) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("/Users/asaf.mishaeli/Desktop/"+s+".png"));
    }
}
