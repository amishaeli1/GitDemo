package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

// All the objects belonging to one page will be defined in java class
public class HomePage {

    //Constructor
    public HomePage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Preference']")
    public WebElement preferences;

    @AndroidFindBy(id = "android:id/checkbox")
    public WebElement checkBox;

    @AndroidFindBy(xpath = "(//android.widget.RelativeLayout)[2]")
    public WebElement RelativeLayout;


    @AndroidFindBy(className = "android.widget.EditText")
    public WebElement EditText;



}
