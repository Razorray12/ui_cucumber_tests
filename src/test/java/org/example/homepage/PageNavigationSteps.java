package org.example.homepage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Driver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageNavigationSteps {

    ChromeDriver chrome = Driver.getDriver().chrome;
    WebDriverWait wait = new WebDriverWait(chrome, Duration.ofSeconds(10));

    @When("Я нажимаю на ссылку {string} в верхнем меню")
    public void ClickOnAboutLinkInTopMenu(String arg0) {
        chrome.findElement(By.xpath("//div[@class='nav-link-text']/descendant::div[text()='" + arg0 + "']")).click();
    }

    @Then("Я должен попасть на страницу с заголовком {string}")
    public void RedirectedToPageWithTitleAbout(String arg0) {
        Boolean isCorrectTitle = wait.until(ExpectedConditions.titleIs(arg0));

        Assertions.assertTrue(isCorrectTitle,"Переход на нужную страницу с заголовком не произошел");
    }
}
