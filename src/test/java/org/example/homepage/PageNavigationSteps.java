package org.example.homepage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Driver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageNavigationSteps {

    ChromeDriver chrome = Driver.getDriver().chrome;

    @When("Я нажимаю на ссылку {string} в верхнем меню")
    public void ClickOnAboutLinkInTopMenu(String arg0) {
    }

    @Then("Я должен попасть на страницу с заголовком {string}")
    public void RedirectedToPageWithTitleAbout(String arg0) {
    }
}
