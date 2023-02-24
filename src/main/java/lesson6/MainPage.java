package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BaseView {
    public MainPage(WebDriver driver) {
        super(driver);
        productBlock = new ProductBlock(driver);
    }

    @FindBy (xpath=".//*[@class=\"menu-item\"]")
    public WebElement signInButton;

    public LoginPage clickSignInButton() {
        signInButton.click();
        return new LoginPage(driver);
    }

    @FindBy (xpath = "//*[@href=\"/ru/mind-map-pricing\"]")
    public WebElement priceInformationMap;

    public PricesPage clickPriceInformationMap() {
        priceInformationMap.click();
        return new PricesPage(driver);
    }

    @FindBy (xpath = "id=\"btn-product-dropdown\"")
    public WebElement productButton;

    public ProductBlock clickProductButton() {
        productButton.click();
        return new ProductBlock(driver);
    }

    public ProductBlock productBlock;
}

