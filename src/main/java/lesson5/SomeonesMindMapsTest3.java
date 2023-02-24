package lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class SomeonesMindMapsTest3 {
    public static void main(String[] args) {

        System.setProperty(
                "webdriver.chrome.driver", "src/main/resources/chromedriver.exe"
        );
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.mindmeister.com/ru");


        WebElement mapCatalog = driver.findElement(By.xpath("//*[@href=\"/ru/mind-map-examples\"]"));
        mapCatalog.click(); //клик на этот элемент (ссылка)
// Из перечня готовых карт других пользователей производится выбор одной любой. Открытие.
        WebElement anyMindCap = driver.findElement(By.xpath("//*[@href=\"/ru/1122589003/the-key-components-of-knowledge-management\"]"));
        anyMindCap.click();
// Клик кнопки "Копировать/изменить".
        WebElement copyButton = driver.findElement(By.xpath("//*[@class=\"pill-button secondary h-flex-row h-hover-shine ml-20\"]"));
        copyButton.click();
        // Регистрирация (через Google-аккаунт).
        WebElement authenticationToGoogle = driver.findElement(By.id("btn_signin_google"));
        authenticationToGoogle.click();
        // В обновлённой вкладке клик кнопки "Копировать/изменить" ("Copy and edit map"). В открывшемся окне "Copy public map" клик "Ok".
        copyButton.click();
        WebElement nextOkButton = driver.findElement(By.xpath("//*[@class=\"button ok_button default\"]"));
        nextOkButton.click();
// Клик "Map listing". Найти в перечне своих карт скопированную карту.
        WebElement mapListing = driver.findElement(By.xpath("//*[@d=\"M10.78 12.375a1 1 0 0 1-1.56 1.25l-4-5a1 1 0 0 1 0-1.25l4-5a1 1 0 0 1 1.56 1.25L7.28 8l3.5 4.375z\"]"));
        mapListing.click();
        driver.close();
    }
}
