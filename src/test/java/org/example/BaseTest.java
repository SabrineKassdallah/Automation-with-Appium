package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    public AndroidDriver driver ;
    public AppiumDriverLocalService service;

    @BeforeClass
    public void ConfigureAppium() throws MalformedURLException {



        //AndroidDriver
        //Appium code --> Appium Server --> mobile Application
        //Appium server intérprète le code coté client au premier lieu puis il décide les actions qu'il doit effectuer
        //et déclenche ces actions dans le mobile
        // il faut indiquer où se trouve votre serveur, car le code doit etre envoyé au serveur
        // la classe AndroidDriver attend deux arguments , le premier l'address du serveur
        // il existe en java une class URL qui accepte un url en string mais java comprend qu'il s'agit d'une address ip

        // la deuxième paramètre c'est le capacité : signifie dans quel système d'exploitation vous voulez exécuter , aussi il faut
        // donner des informations sur l'application à automatiser
        //l'automatisation commence après l'ouverture de l'application , la sélection de l'appareil et le choix du numéro de version
        // tous ces informations doivent etre transmis au deuxième argument

        // * code to start server
        /*
        service = new AppiumServiceBuilder().withAppiumJS( new File("//home//sabrine//.nvm//versions//node//v18.20.4//lib//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();

         */

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("AppTest");
        //options.setApp("//home//sabrine//Bureau//Appium//src//test//java//resources//ApiDemos-debug.apk");
        options.setApp("//home//sabrine//Bureau//Altagem-2.29.1-beta-itDebugDebug.apk");


         driver = new AndroidDriver(new URL("http://127.0.0.1:4723") ,options);
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // attendre 10secondes pour que l'element soit visible : c'est la durée maximale


    }

    public void LongPressAction(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(),"duration",2000));

    }

    public void ScrollToEndAction() {
        boolean canScrollMore;
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 3.0
            ));
        }while (canScrollMore);
    }

    public void SwipAction(WebElement ele, String direction) {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",((RemoteWebElement) ele).getId(),
                "direction", direction,
                "percent", 0.75));
    }


    public void login(String username, String password) {
        driver.findElement(By.id("com.altagem.app.itDebug.debug:id/btn_continue")).click();
        driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_always_button")).click();
        driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys("tehceksd");
        driver.findElement(By.id("com.altagem.app.itDebug.debug:id/btn_connect")).click();
        driver.findElement(By.id("com.altagem.app.itDebug.debug:id/et_username")).click();
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.altagem.app.itDebug.debug:id/search_src_text']")).sendKeys(username);
        driver.findElement(By.id("com.altagem.app.itDebug.debug:id/tv_name")).click();
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.altagem.app.itDebug.debug:id/et_password']")).sendKeys(password);
        driver.findElement(By.id("com.altagem.app.itDebug.debug:id/btn_connect")).click();
    }

    public void verifyHomeScreen() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80)); // Attente jusqu'à 80 secondes
        WebElement homeTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//android.widget.TextView[@text='Home']")
        ));
        String homeText = homeTextElement.getText();
        Assert.assertEquals(homeText, "Home", "La page d'accueil n'est pas visible.");

    }

    @AfterClass
    public void tearDown() {
        // close the driver and service
        driver.quit();
        //service.stop();
    }
}
