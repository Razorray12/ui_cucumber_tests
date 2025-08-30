package org.example.homepage;

import io.cucumber.java.en.Given;
import org.example.Driver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonSteps {

    ChromeDriver chrome = Driver.getDriver().chrome;

    @Given("Я нахожусь на главной странице сайта")
    public void OnTheHomepage() {
        chrome.get("https://stealthy-whiskers.webflow.io");
    }

}
