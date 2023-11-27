package site.nomoreparties.stellarburgers.pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class PersonalPage {
    private final WebDriver webDriver;
    private By userMenu = By.className("Account_nav__Lgali");
    private By exitButton = By.xpath("//button[contains(text(),'Выход')]");
    private By constructor = By.xpath(".//p[text()='Конструктор']");
    private By logo = By.xpath("//*[@id=\"root\"]/div/header/nav/div/a/svg");


    public PersonalPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean checkPersonalMenuIsDisplayed(){
        return webDriver.findElement(userMenu).isDisplayed();
    }
    public void clickExitButton(){
        webDriver.findElement(exitButton).click();
    }
    public void open(){
        webDriver.get("https://stellarburgers.nomoreparties.site/login");
    }
    public void clickConstructorButton(){
        webDriver.findElement(constructor).click();
    }
    public void clickToLogo(){
        webDriver.findElement(logo).click();
    }

}
