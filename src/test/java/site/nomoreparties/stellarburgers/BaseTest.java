package site.nomoreparties.stellarburgers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver webDriver;
    @Before
    public void setUp(){
        String browser = "chrome";
        switch (browser){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
//            case "yandex":
//                webDriver = yandexDriver();
                break;
            default: throw new RuntimeException("Необходимо выбрать браузер - Хром или Яндекс");
        }
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }
    private static WebDriver yandexDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
        ChromeOptions options= new ChromeOptions();
        return new ChromeDriver(options);
    }
}
