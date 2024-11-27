package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class ScrollDemo extends BaseTest {

    @Test
    public void ScrollDemoTest()  {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        //where to scroll is known prior : methode one
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"WebView\"));"));
        // No prior idea : methode two
        //ScrollToEndAction();

    }

}
