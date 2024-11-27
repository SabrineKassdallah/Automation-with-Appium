package org.example;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class LoginAltagem extends BaseTest {


    @Test
    public void FirstLoginTest() throws InterruptedException {
        login("Alexandre LAINE", "0000");
        verifyHomeScreen(); // Vérifie si l'utilisateur est bien sur la page d'accueil

    }

}