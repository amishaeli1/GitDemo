package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FormPage {

    //Constructor
    public FormPage(AndroidDriver<AndroidElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
    public WebElement nameField;

//driver.findElement(By.xpath("//*[@text='Female']")).click();
    @AndroidFindBy(xpath= "//*[@text='Female']")
    public WebElement femaleOption;

    @AndroidFindBy(id= "android:id/text1")
    public WebElement countrySelection;

    public WebElement getNameField(){
        return nameField;
    }

    public WebElement getCountrySelection(){
        return countrySelection;
    }


}
