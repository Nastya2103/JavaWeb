package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
public class WebinarPage extends BaseView{
    public WebinarPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//*[@class=\"event__main\"]")
    public List<WebElement> webinars;

    public WebinarPage testEachWebinar(int i) throws InterruptedException {
        if(i>=0 && i<6) {
            webinars.get(i).click();
            Thread.sleep(3000);
        } else {
            System.out.println("Пролёт с индексом в WebinarPage.");
        }  return this;
    }
}
