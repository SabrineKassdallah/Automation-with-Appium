package org.example;
import io.appium.java_client.AppiumBy;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class AppiumBasics extends BaseTest {

    @Test
    public void WifiSettingsName() throws MalformedURLException {

        // Actual automatisation
        // different localisateurs: Xpath, id, accessibilityId, classname, androidUIAutomator
        // comment trouver la déclaration xpath : //tagName[@attribute= 'value']
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle,"WiFi settings");
        driver.findElement(By.id("android:id/edit")).sendKeys("test wifi");
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();



    }


}