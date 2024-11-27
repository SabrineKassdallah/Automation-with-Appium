package org.example;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class LogOutAltagem extends BaseTest {


    @Test
    public void FirstLogin() {
        driver.findElement(By.id("com.altagem.app.itDebug.debug:id/btn_continue")).click();
        driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_always_button")).click();
        //driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();

        driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys("tehceksd");
        driver.findElement(By.id("com.altagem.app.itDebug.debug:id/btn_connect")).click();
        driver.findElement(By.id("com.altagem.app.itDebug.debug:id/et_username")).click();
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.altagem.app.itDebug.debug:id/search_src_text']")).sendKeys("Alexandre LAINE");
        driver.findElement(By.id("com.altagem.app.itDebug.debug:id/tv_name")).click();
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.altagem.app.itDebug.debug:id/et_password']")).sendKeys("0000");
        driver.findElement(By.id("com.altagem.app.itDebug.debug:id/btn_connect")).click();

    }

}