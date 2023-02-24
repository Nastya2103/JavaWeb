package lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class UsefulLinksTest1 {
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

        // Назначение переменной и сообщение "Это веб-элемент, он находится по пути xpath..."
        WebElement mapCatalog = driver.findElement(By.xpath("//*[@href=\"/ru/mind-map-examples\"]"));
        mapCatalog.click(); //кликаем на этот элемент (ссылка)
        driver.get("https://www.mindmeister.com/ru/mind-map-examples"); // в том же окне открывается ссылка
        //Объявление другой переменной и сообщение: "Это другой веб-элемент, он находится по пути xpath..."
        WebElement education = driver.findElement(By.xpath("//*[@href=\"/ru/mind-maps/education\"]"));
        education.click(); //клик на этот элемент (ссылка), он автоматически открывается в новом окне
        // объявление переменной blog и др.
        WebElement blog = driver.findElement(By.xpath("//*[@href=\"/blog\"]"));
        blog.click(); //клик на этот элемент (ссылка), он открывается в новом окне
        // driver.close(); - закрытие окна вызванного блога, оно уже проверено
        // driver.switchTo(); - автоматически открывается единственная имеющаяся страница, с которой мы шагаем на остальные
        WebElement article = driver.findElement(By.xpath("//*[@href=\"/blog/the-best-mind-map-templates-for-teachers-and-students\"]"));
        article.click();
        WebElement video = driver.findElement(By.xpath("//*[@href=\"http://www.youtube.com/user/MindMeister\"]"));
        video.click();
        WebElement meisterTask = driver.findElement(By.xpath("//*[@href=\"https://www.meistertask.com?r_campaign=mm_integration&utm_campaign=mm_integration&utm_medium=website&utm_source=mindmeister\"]"));
        meisterTask.click();
        WebElement meisterNote = driver.findElement(By.xpath("//*[@href=\"https://www.meisternote.com?utm_medium=website&utm_source=mindmeister\"]"));
        meisterNote.click();
        WebElement mindMapsSite = driver.findElement(By.xpath("//*[@href=\"https://www.mindmaps.com/\"]"));
        mindMapsSite.click();
        driver.close();
    }
}
