package pl.coderslab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShopPage {

    private static WebDriver driver;

    @FindBy(id = "group_1")
    WebElement sizePick;

    @FindBy(name = "quantity_wanted")
    private static WebElement userPicksQuantity;

    @FindBy(css = "btn.btn-primary.add-to-cart")
    WebElement addToCart;
//
//    @FindBy(name = "id_country")
//    WebElement countrySelect;
//
//    @FindBy(name = "phone")
//    WebElement phoneInput;
//
//    @FindBy(css = "btn.btn-primary.float-xs-right")
//    WebElement submitButton;

//    public ShopPage(WebDriver driver) {
//        ShopPage.driver = driver;
//        PageFactory.initElements(driver, this);
//    }

    public static void sizePick() {
        Select sizeMenu = new Select(driver.findElement(By.name("group_1")));
        sizeMenu.selectByValue("2");
    }

    public static void userPicksQuantity(String qty) {
        userPicksQuantity.click();
        userPicksQuantity.sendKeys(qty);
    }

    public void addToCart() {
        addToCart.click();
    }

}
