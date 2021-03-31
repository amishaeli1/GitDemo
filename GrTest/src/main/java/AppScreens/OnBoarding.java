package AppScreens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OnBoarding {

    public OnBoarding(AndroidDriver<AndroidElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(className = "android.widget.Button")
    public WebElement demoUserScreen1LetsGo;

    @AndroidFindBy(className = "android.widget.Button")
    public List<WebElement> bgPopupButtons;


    @AndroidFindBy(className = "android.widget.Button")
    public WebElement demoUserScreen2Next;

    @AndroidFindBy(className = "android.widget.Button")
    public List<WebElement> locationPopupButtons;

    @AndroidFindBy(className = "android.widget.Button")
    public WebElement demoUserScreen3Next;

    @AndroidFindBy(className = "android.widget.Button")
    public WebElement demoUserScreen4Done;


}
