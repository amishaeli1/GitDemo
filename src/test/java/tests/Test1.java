package tests;

import Utils.Base;
import Utils.Utilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.CheckOutPage;
import pageObjects.FormPage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;



public class Test1 extends Base {

    @BeforeTest
    public void killAllNodes() throws IOException, InterruptedException {
        //killall node in mac = taskkill /F /IM node.exe in windows
        Runtime.getRuntime().exec("killall node");
        Thread.sleep(3000);
    }

    @Test
    public void totalValidation() throws InterruptedException, IOException {
        service = startServer();

        AndroidDriver<AndroidElement> driver = capabilities("GeneralStoreApp");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        FormPage formPage = new FormPage(driver);

//        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
//        One option
//        formPage.nameField.sendKeys("Hello");
//        Second option.. this option is more recommended
        formPage.getNameField().sendKeys("Hello");

        driver.hideKeyboard();
//        driver.findElement(By.xpath("//*[@text='Female']")).click();
        formPage.femaleOption.click();
//        driver.findElement(By.id("android:id/text1")).click();
        formPage.getCountrySelection().click();
//        driver.findElementsByAndroidUIAutomator(
//                "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
        Utilities u = new Utilities(driver);
        u.scrollToText("Argentina");


//		in case that for some reason line 24 is not working, we can use line 26 instead
//		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + "Argentina" + "\").instance(0))"));
        driver.findElement(By.xpath("//*[@text='Argentina']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
        //because we already added the first item to cart, the first item is no longer in the list for us,so we need again select 0
        driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        Thread.sleep(4000);

        int count = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
        double sum = 0;

        CheckOutPage checkOutPage = new CheckOutPage(driver);

        for (int i = 0; i < count; i++) {
//            String amount1 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
            String amount1 = checkOutPage.productList.get(i).getText();
            double amount = getAmount(amount1);
            sum = sum + amount;
        }

        System.out.println(sum);

//        String total = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        String total = checkOutPage.totalAmount.getText();
        total = total.substring(1);
        double totalValue = Double.parseDouble(total);
//        double totalValue = getAmount(total);
        System.out.println(totalValue);
        Assert.assertEquals(sum, totalValue, 0);

        service.stop();
    }

    public static double getAmount(String value) {
        value = value.substring(1);
        double amount2Value = Double.parseDouble(value);
        return amount2Value;
    }
}


