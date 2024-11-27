package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LogOutAltagem extends BaseTest {


    @Test
    public void LogOutTest() {


        Activity activity = new Activity("com.altagem.app.itDebug.debug","com.altagem.app.ui.home.HomeActivity");
        ((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent","com.altagem.app.itDebug.debug/com.altagem.app.ui.home.HomeActivity"));


        // Navigation vers la déconnexion
        driver.findElement(AppiumBy.accessibilityId("Open navigation drawer")).click();
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Logout\"));"));
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='com.altagem.app.itDebug.debug:id/design_menu_item_text' and @text='Logout']")).click();

        // Vérification après déconnexion
        boolean isConnectButtonDisplayed = driver.findElement(By.id("com.altagem.app.itDebug.debug:id/btn_connect")).isDisplayed();
        Assert.assertTrue(isConnectButtonDisplayed, "Le bouton de connexion devrait être visible après la déconnexion.");
    }
}

