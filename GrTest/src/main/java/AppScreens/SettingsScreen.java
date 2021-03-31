package AppScreens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;

public class SettingsScreen {

    public SettingsScreen(AndroidDriver<AndroidElement> driver) throws FileNotFoundException {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id="com.greenroad.mobile.drive:id/settingsVersion")
    public WebElement appVersion;
}
