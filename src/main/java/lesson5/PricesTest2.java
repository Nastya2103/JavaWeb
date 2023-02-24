package lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class PricesTest2 {
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


        // Назначение переменной и сообщение: "Это веб-элемент ЦЕНЫ, он находится по пути xpath..."
        WebElement prices = driver.findElement(By.xpath("//*[@href=\"/ru/mind-map-pricing\"]"));
        prices.click(); //клик на этот элемент (ссылка), открывается новая страница в той же вкладке
        // Объявление переменной и сообщение: "Это веб-элемент "Часто задаваемые вопросы"", он находится по пути xpath..."
        WebElement oftenQuestions = driver.findElement(By.xpath("//*[@href=\"https://support.mindmeister.com/hc/sections/200303186-Frequently-Asked-Questions\"]"));
        oftenQuestions.click();
        driver.close(); // Закрытие браузера
    }
}
