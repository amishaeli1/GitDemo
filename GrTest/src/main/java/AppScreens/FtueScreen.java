package AppScreens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;

public class FtueScreen {

    public FtueScreen(AndroidDriver<AndroidElement> driver) throws FileNotFoundException {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id="com.greenroad.mobile.drive:id/fscv_id")
    public WebElement dashboardFtue;

    @AndroidFindBy(id="com.greenroad.mobile.drive:id/fscv_id")
    public WebElement tripHistoryFtue;

    @AndroidFindBy(id="com.greenroad.mobile.drive:id/fscv_id")
    public WebElement scoreboardLivemapFtue;

    @AndroidFindBy(id="com.greenroad.mobile.drive:id/fscv_id")
    public WebElement notificationMyaccountFtue;

    @AndroidFindBy(id="com.greenroad.mobile.drive:id/fscv_id")
    public WebElement viewbyManualtripstartFtue;

    @AndroidFindBy(id="com.greenroad.mobile.drive:id/settingsBtn")
    public WebElement settingsBtn;

    @AndroidFindBy(id="com.greenroad.mobile.drive:id/fscv_id")
    public WebElement settingsFtue;

    @AndroidFindBy(xpath= "//*[@text='Drive']")
    public WebElement driveApp;

    @AndroidFindBy(id="com.google.android.apps.nexuslauncher:id/all_apps_handle")
    public WebElement appsList;


}
