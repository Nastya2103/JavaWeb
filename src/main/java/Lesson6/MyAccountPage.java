package Lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BaseView {
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//*[@href=\"https://www.mindmeister.com\"]")
    private WebElement logoButton;

    @Step("Клик на лого")
    public MyAccountPage hoverLogoButton() {
        actions.moveToElement(logoButton).build().perform();
        return this;
    }
}

