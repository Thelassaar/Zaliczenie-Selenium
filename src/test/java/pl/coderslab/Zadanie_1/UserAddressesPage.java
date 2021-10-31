package pl.coderslab.Zadanie_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UserAddressesPage {

    private static WebDriver driver;

    @FindBy(name = "alias")
    WebElement aliasInput;

    @FindBy(name = "address1")
    WebElement addressInput;

    @FindBy(name = "postcode")
    WebElement postcodeInput;

    @FindBy(name = "city")
    WebElement cityInput;

    @FindBy(name = "id_country")
    WebElement countrySelect;

    @FindBy(name = "phone")
    WebElement phoneInput;

    @FindBy(css = "btn.btn-primary.float-xs-right")
    WebElement submitButton;

    public UserAddressesPage(WebDriver driver) {
        UserAddressesPage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void aliasInput(String alias) {
        aliasInput.click();
        aliasInput.sendKeys(alias);
    }

    public void addressInput(String address) {
        addressInput.click();
        addressInput.sendKeys(address);
    }

    public void postcodeInput(String postcode) {
        postcodeInput.click();
        postcodeInput.sendKeys(postcode);
    }

    public void cityInput(String city) {
        cityInput.click();
        cityInput.sendKeys(city);
    }

    public void countrySelect() {
        Select country = new Select(driver.findElement(By.name("id_country")));
        country.selectByValue("17");
    }

    public void phoneInput(String phone) {
        phoneInput.click();
        phoneInput.sendKeys(phone);
    }

}
