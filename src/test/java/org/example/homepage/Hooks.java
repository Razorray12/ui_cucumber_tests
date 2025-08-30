package org.example.homepage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.example.Driver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
Класс содержащий шаги выполняемые перед и после тестов
 */
public class Hooks {

    ChromeDriver chrome = Driver.getDriver().chrome;

    /*
    Шаг выполняемый перед тестом
    Создаёт переходит на домашнюю страницу приложения
     */
    @Before()
    public void openPage() {
        chrome.navigate().to("https://stealthy-whiskers.webflow.io/");
        System.out.println("OPEN");
    }

    /*
    Шаг выполняемый после теста
    Закрывает браузер
     */
    @After
    public void shotDown() {
        chrome.quit();
        System.out.println("CLOSED");
    }
}
