package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*
Класс для вызова драйвера браузера chrome (утилитарный)
 */
public class Driver {

    private static Driver driver;
    public ChromeDriver chrome;

    /*
    Приватный конструктор
    Чтобы инстанс драйвера был один (такой подход необязателен)
     */
    private Driver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        /*
        В ChromeOptions содержатся настройки для драйвера
         */
        options.addArguments("--start-maximized");
        chrome = new ChromeDriver(options);
    }

    public static Driver getDriver() {
        if(driver == null) {
            driver = new Driver();
        }
        return driver;
    }

}
