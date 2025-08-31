package org.example.homepage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Driver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/*
Класс содержащий шаги для взаимодействия и проверок с страницей Shop
 */
public class ShopSteps {

    ChromeDriver chrome = Driver.getDriver().chrome;
    WebDriverWait wait = new WebDriverWait(chrome, Duration.ofSeconds(10));
    private String selectedProductName;
    /*
    Открывает в меню страницу Shop
     */
    @When("open shop tab")
    public void openShopTab() {
        chrome.findElement(By.xpath("//div[text()='Shop']")).click();
    }

    /*
    Проверяет что title (текст в вкладке) содержит строку Shop
     */
    @Then("check shop title")
    public void checkShopTitle() {
        Assertions.assertEquals("Shop", chrome.getTitle());
    }

    @When("Я нажимаю на кнопку {string}")
    @And("Я нажимаю кнопку {string}")
    public void ClickOnButton(String arg0) {
        if(arg0.equals("Add to Bag")){
            chrome.findElement(By.xpath("//div[contains(text(), 'S (4-6)')]/parent::div")).click();
            chrome.findElement(By.xpath("//input[@value='Add to Bag']")).click();
        }
        else{
            chrome.findElement(By.xpath("//div[text()='" + arg0 + "']")).click();
        }
    }

    @And("Я выбираю первый товар из списка")
    public void SelectFirstProductFromList() {
        List<WebElement> products = chrome.findElements(By.xpath("//div[contains(@class,'shop-grid')]//div[contains(@role,'listitem')]"));

        Assertions.assertFalse(products.isEmpty(), "Список товаров пуст");

        WebElement firstProduct = products.getFirst();
        selectedProductName = firstProduct.findElement(By.xpath(".//h3[@class='product-title']")).getText();

        firstProduct.click();
    }

    @Then("Всплывающее окно корзины должно отобразить выбранный товар")
    public void CartDisplaySelectedProduct() {
        try {
            WebElement cartDialog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='dialog']")));
            Assertions.assertTrue(cartDialog.isDisplayed(), "Всплывающее окно не отобразилось");

            List<WebElement> cartProductElements = chrome.findElements(By.xpath("//div[@id='scrollbar'][contains(@class,'cart-list')]/child::div"));

            boolean flag = false;

            for( WebElement cartProductElement : cartProductElements){
                if(cartProductElement.findElement(By.xpath("//div[contains(@class,'cart-title')]")).getText().equals(selectedProductName)){
                    flag = true;
                }
            }

            Assertions.assertTrue(flag, "Выбранный товар не отобразился во всплывающем окне");

        } catch (TimeoutException e) {
            throw new RuntimeException("Ошибка при проверке корзины", e);
        }
    }

}
