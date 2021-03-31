package AppScreens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.io.FileNotFoundException;

public class LoginScreen {

    public LoginScreen(AndroidDriver<AndroidElement> driver) throws FileNotFoundException {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id="com.greenroad.mobile.drive:id/username")
    public WebElement userName;

    @AndroidFindBy(className = "android.widget.Button")
    public WebElement nextButton;

    @AndroidFindBy(id="com.greenroad.mobile.drive:id/password")
    public WebElement password;


    @AndroidFindBy(className = "android.widget.Button")
    public WebElement loginButton;

    public WebElement getUserName(){
        return userName;
    }

    public WebElement getPassword(){
        return  password;
    }


}
