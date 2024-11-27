package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class MisceallanousAppiumAction extends BaseTest {

    @Test
    public void Miscellanous() throws MalformedURLException {

        //adb shell dumpsys window | grep -E 'mCurrentFocus' : cette commande affiche les info nécessaire pour l'activité actuelle affiché sur l'app
        //App Package & App Activity
        // ces deux premiers lignes nous permettent d'accéder directement à la page dans l'app mobile qui concerne le test à traiter
        Activity activity = new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");
        ((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent","io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));

        driver.findElement(By.id("android:id/checkbox")).click();
        DeviceRotation landScape = new DeviceRotation(0,0,90);
        driver.rotate(landScape);
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle,"WiFi settings");

        // copy paste
        // copy to clipboard - paste it clipboard
        driver.setClipboardText("test wifi");
        driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();

        // create object event to manage different events from mobile
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));




    }

}