package org.example;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class AppiumBasics {

    @Test
    public void AppiumTest() throws MalformedURLException {


        //AndroidDriver
        //Appium code --> Appium Server --> mobile Application
        //Appium server intérprète le code coté client au premier lieu puis il décide les actions qu'il doit effectuer
        //et déclenche ces actions dans le mobile
        // il faut indiquer où se trouve votre serveur, car le code doit etre envoyé au serveur
        // la classe AndroidDriver attend deux arguments , le premier l'address du serveur
        // il existe en java une class URL qui accepte un url en string mais java comprend qu'il s'agit d'une address ip

        // le deuxième paramètre c'est le capacité : signifie dans quel système d'exploitation vous voulez exécuter , aussi il faut
        // donner des informations sur l'application à automatiser
        //l'automatisation commence après l'ouverture de l'application , la sélection de l'appareil et le choix du numéro de version
        // tous ces informations doivent etre transmis au deuxième argument

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("test");


        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),null);

    }
}