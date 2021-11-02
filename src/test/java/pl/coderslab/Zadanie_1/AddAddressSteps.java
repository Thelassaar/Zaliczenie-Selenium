package pl.coderslab.Zadanie_1;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.LoginPage;

import java.util.concurrent.TimeUnit;

public class AddAddressSteps {
    UserAddressesPage userAddressesPage;
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

    @And("user goes to Account")
    public void userGoesToAccount() {
        driver.findElement(By.className("account")).click();
    }


    @And("adds new Address")
    public void userGoesToAddressesPage() {
        boolean isPresent = driver.findElements(By.id("address-link")).size() > 0;
        if (isPresent) {
            driver.findElement(By.id("address-link")).click();
        } else {
            driver.findElement(By.id("addresses-link")).click();
            driver.findElement(By.cssSelector("div.addresses-footer > a > span")).click();
        }
    }

    @And("^user fills (.*), (.*), (.*), (.*), country and (.*) in form$")
    public void userFillsAddressForm(String alias, String address, String city, String postcode, String phone) {
        userAddressesPage = new UserAddressesPage(driver);
        userAddressesPage.aliasInput(alias);
        userAddressesPage.addressInput(address);
        userAddressesPage.postcodeInput(postcode);
        userAddressesPage.cityInput(city);
        userAddressesPage.countrySelect();
        userAddressesPage.phoneInput(phone);
    }

    @And("user clicks Save button")
    public void userClicksSaveButton() {
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/footer/button")).click();
    }

    @Then("^user checks (.*), (.*), (.*), (.*) and (.*) in form$")
    public void checkAddress(String alias, String address, String city, String postcode, String phone) {
        String DEFINED_USER = "Rafał Szczygielski";
        String DEFINED_COUNTRY = "United Kingdom";
        String expectedValue = alias + "\n" + DEFINED_USER + "\n" + address + "\n"  + city + "\n" + postcode + "\n" + DEFINED_COUNTRY + "\n" + phone;
        String comparisonValue = driver.findElement(By.className("address-body")).getText();
        assertEquals(expectedValue, comparisonValue);
    }

//    @Then("closes browser")
//    public void tearDown() {
//        driver.quit();
//    }

}
