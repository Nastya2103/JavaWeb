package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;
;

public class MainPage extends BaseView {
    public MainPage(WebDriver driver) {
        super(driver);
        productBlock = new ProductBlock(driver);
    }

    @FindBy (xpath=".//*[@class=\"menu-item\"]")
    public WebElement signInButton;

    @Step("Регистрация")
    public LoginPage clickSignInButton() {
        signInButton.click();
        return new LoginPage(driver);
    }

    @FindBy (xpath = "//*[@href=\"/ru/mind-map-pricing\"]")
    public WebElement priceInformationMap;

    @Step("Клик на кнопку открытия блока информации о тарифах")
    public PricesPage clickPriceInformationMap() {
        priceInformationMap.click();
        return new PricesPage(driver);
    }

    @FindBy(xpath = ".//*[@id=\"close-notification-banner\"]")
    public WebElement closeNotificationBanner;

    @FindBy(xpath = ".//*[@id=\"cb-btn-ok\"]")
    public WebElement cookieOkButton;

    @Step("Закрытие куки")
    public MainPage clickCookies() {
        cookieOkButton.click();
        return this;
    }

    @FindBy (xpath = "//*[@id=\"btn-product-dropdown\"]//*[@class=\"link\"]")
    public WebElement productButton;

    @Step("Открытие меню продукции")
    public ProductBlock clickProductButton() {

        productButton.click();
        return new ProductBlock(driver);
    }

    public ProductBlock productBlock;

}

