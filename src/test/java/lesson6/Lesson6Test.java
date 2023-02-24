package lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Lesson6Test {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
    }

    @Test
        //Тест 1.2: Авторизация на сайте
    void authentication() throws InterruptedException {
        driver.get("https://www.mindmeister.com/ru");
//
        new MainPage(driver)
                .clickSignInButton()
                .login("korobeynikova2103@mail.ru", "75395155Xx");
        Thread.sleep(12000);
    }

    @Test
            void logoToStartWithAuthentication() throws InterruptedException {
        authentication();
        new MyAccountPage(driver).hoverLogoButton();
        Thread.sleep(7000);
    }

    @Test
            void pricesAndQuestions() throws InterruptedException {
        driver.get("https://www.mindmeister.com/ru");
        new MainPage(driver)
                .clickPriceInformationMap()
                .clickOftenQuestionsLink();
        Thread.sleep(12000);
    }

    @Test
          void realWebinars() throws InterruptedException {
        driver.get("https://www.mindmeister.com/ru");
        new MainPage(driver)
                .clickProductButton()
                .clickWebinars()
                .testEachWebinar(5);
        Thread.sleep(10000);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
