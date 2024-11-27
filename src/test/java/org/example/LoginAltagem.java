package org.example;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class LoginAltagem extends BaseTest {

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

    /*
    @Test
    public void altagemTest() {
        driver.findElement(By.id("com.altagem.app.itDebug.debug:id/btn_continue")).click();
        driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_always_button")).click();
        driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys("tehceksd");
        driver.findElement(By.id("com.altagem.app.itDebug.debug:id/btn_connect")).click();
        driver.findElement(By.id("com.altagem.app.itDebug.debug:id/et_username")).click();
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.altagem.app.itDebug.debug:id/search_src_text']")).sendKeys("Alexandre LAINE");
        driver.findElement(By.id("com.altagem.app.itDebug.debug:id/tv_name")).click();
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.altagem.app.itDebug.debug:id/et_password']")).sendKeys("0000");
        driver.findElement(By.id("com.altagem.app.itDebug.debug:id/btn_connect")).click();




    }

     */
}