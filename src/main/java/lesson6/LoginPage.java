package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseView {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//*[@id=\"login_email_login\"]")
    private WebElement emailField;

    @FindBy(xpath = ".//*[@id=\"login_email_password\"]")
    private WebElement passwordField;

    @FindBy(id = "btn_signin")
    private WebElement submitButton;


    public void login(String email, String pass) {
        emailField.sendKeys(email);
        passwordField.sendKeys(pass);
        submitButton.click();
    }
}
