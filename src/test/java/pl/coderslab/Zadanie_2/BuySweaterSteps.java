package pl.coderslab.Zadanie_2;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en_scouse.An;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import pl.coderslab.LoginPage;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
//import ru.yandex.qatools.ashot.AShot;
//import ru.yandex.qatools.ashot.Screenshot;
//import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class BuySweaterSteps {
    ShopPage shopPage;
    WebDriver driver;

    @Given("user is logged in to My Store")
    public void userIsLoggedInToMyStore() {
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("ghqptcyersesbsrmxz@mrvpm.net", "CodersLab10!");
    }

    @And("^user finds (.*)$")
    public void userFindsItem(String item) {
        driver.findElement(By.className("ui-autocomplete-input")).sendKeys(item + Keys.RETURN);
    }

    @And("^user clicks on (.*)$")
    public void userClicksOnItem(String item) {
//        driver.findElement(By.xpath("//h2/a[text()[contains(" + item + ")]]")).click();
        driver.get("https://mystore-testlab.coderslab.pl/index.php?id_product=2&id_product_attribute=9&rewrite=brown-bear-printed-sweater&controller=product#/1-size-s");
    }

    @And("user chooses M size")
    public void userChoosesSize() {
        Select size = new Select(driver.findElement(By.name("group[1]")));
        size.selectByValue("2");
    }

    @And("^user sets (.*) pcs to buy$")
    public void userChoosesQuantity(String qty) {
        driver.findElement(By.id("quantity_wanted")).clear();
        driver.findElement(By.id("quantity_wanted")).sendKeys(qty);
    }

    @And("user adds item to cart")
    public void userAddsItemToCart() {
        driver.findElement(By.cssSelector("#add-to-cart-or-refresh > div.product-add-to-cart > div > div.add > button")).click();
    }

    @And("user proceeds to checkout")
    public void userProceedsToCheckout() {
        driver.findElement(By.cssSelector("#blockcart-modal > div > div > div.modal-body > div > div.col-md-7 > div > div > a")).click();
        driver.findElement(By.cssSelector("#main > div > div.cart-grid-right.col-xs-12.col-lg-4 > div.card.cart-summary > div.checkout.cart-detailed-actions.card-block > div > a")).click();
    }

    @And("user confirms address")
    public void userConfirmsAddress() {
//        driver.findElement(By.name("id_address_delivery")).click();
        driver.findElement(By.name("confirm-addresses")).click();
    }

    @And("user chooses PrestaShop pick up in store")
    public void userChoosesDelivery() {
//        driver.findElement(By.id("delivery_option_1")).click();
        driver.findElement(By.name("confirmDeliveryOption")).click();
    }

    @And("user chooses payment and confirms")
    public void userChoosesPayment() {
        driver.findElement(By.id("payment-option-1")).click();
        driver.findElement(By.id("conditions_to_approve[terms-and-conditions]")).click();
        driver.findElement(By.cssSelector("#payment-confirmation > div.ps-shown-by-js > button")).click();
    }

    @Then("user takes screenshot with order confirmation")
    public void whenGoogleIsLoaded_thenCaptureScreenshot() throws IOException {
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(src, new File("C:\\CodersLab\\screenshot.png"));
    }

}
