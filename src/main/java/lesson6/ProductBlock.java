package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductBlock extends BaseView{
    public ProductBlock(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = ".//*[@href=\"https://www.mindmeister.com/pages/ru/webinars\"]")
    private WebElement webinars;

    public WebinarPage clickWebinars() {
        webinars.click();
        return new WebinarPage(driver);
    }
}

