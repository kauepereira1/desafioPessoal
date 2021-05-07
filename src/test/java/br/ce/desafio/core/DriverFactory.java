package br.ce.desafio.core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "c:\\Temp\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().setSize(new Dimension(1200, 1080));
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static void KillDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
