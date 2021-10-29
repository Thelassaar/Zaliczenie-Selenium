package pl.coderslab.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.pages.LoginPage;
import pl.coderslab.pages.ShopPage;
import pl.coderslab.pages.UserAddressesPage;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;
//import ru.yandex.qatools.ashot.AShot;
//import ru.yandex.qatools.ashot.Screenshot;
//import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class BuySweaterSteps {
    ShopPage shopPage;
    WebDriver driver;

    @And("^user finds (.*)$")
    public void userFindsItem(String item) {
        driver = new ChromeDriver();
        driver.findElement(By.className("ui-autocomplete-input")).sendKeys(item + Keys.RETURN);
    }

    @And("^user clicks on (.*)$")
    public void userClicksOnItem(){
        driver.findElement(By.xpath("//*[@id=\"js-product-list\"]/div[1]/article[1]/div/div[1]/h2/a")).click();
    }

    @And("user chooses M size")
    public void userChoosesSize() {
        ShopPage.sizePick();
    }

    @And("user sets 5 pcs to buy")
    public void userPicksQuantity(String qty) {
        ShopPage.userPicksQuantity(qty);
    }

    @And("user adds item to cart")
    public void userAddsItemsToCart() {
        shopPage.addToCart();
    }

    @And("user proceeds to checkout")
    public void userProceedsToCheckout() {
        driver.findElement(By.partialLinkText("href=\"//mystore-testlab.coderslab.pl/index.php?controller=cart&action=show\"")).click();
        driver.findElement(By.partialLinkText("href=\"https://mystore-testlab.coderslab.pl/index.php?controller=order\""));
    }

    @And("user confirms address")
    public void userConfirmsAddress() {
        driver.findElement(By.id("id-address-delivery-address-16044"));
    }

    @And("user chooses PrestaShop pick up in store")
    public void userChoosesPickUpInStore() {
        driver.findElement(By.id("delivery_option_1")).click();
        driver.findElement(By.name("confirmDeliveryOption")).click();
    }

    @And("user clicks on order with an obligation to pay")
    public void userChoosesPayment() {
        driver.findElement(By.id("payment-option-1")).click();
        driver.findElement(By.id("conditions_to_approve[terms-and-conditions]")).click();
    }

//    @Then("user takes screenshot with order confirmation")
//    public void userTakesScreenshot() {
//        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
//
//    }


}
