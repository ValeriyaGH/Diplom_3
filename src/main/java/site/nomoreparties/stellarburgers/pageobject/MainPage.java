package site.nomoreparties.stellarburgers.pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final WebDriver webDriver;
    private By authButton = By.className("button_button__33qZ0");
    private By personalInfo = By.xpath("//p[contains(text(),'Личный Кабинет')]");
    private By exitButton = By.xpath("//button[contains(text(),'Выход')]");
    //Кнопка "войти в аккаунт" на главной
    private By loginButton = By.xpath("//button[contains(text(),'Войти в аккаунт')]");
    private By sauses = By.xpath("//span[text()='Соусы']/..");
    private By filling = By.xpath("//span[text()='Начинки']/..");
    private By buns = By.xpath(".//span[text()='Булки']/..");



    public MainPage(WebDriver webdriver){
        this.webDriver = webdriver;
    }
    public void open(){
        webDriver.get("https://stellarburgers.nomoreparties.site/");
    }
    public void clickAuthButton(){
        webDriver.findElement(authButton).click();
    }
    public void clickPersonalInfoButton(){
        webDriver.findElement(personalInfo).click();
    }
    public void clickExitButton(){
        webDriver.findElement(exitButton).click();
    }
    public void clickLoginButton(){
        webDriver.findElement(loginButton).click();
    }
    public void switchToSauses(){
        webDriver.findElement(sauses).click();
    }
    public void switchToFilling(){
        webDriver.findElement(filling).click();
    }
    public void switchToBuns(){
        webDriver.findElement(buns).click();
    }
    public boolean checkConstructorMenuIsVisible(){
        return webDriver.findElement(buns).isDisplayed();
    }
    public boolean checkBunsIsVisible(){
        return new WebDriverWait(webDriver, 7).until(ExpectedConditions.attributeContains(buns, "class", "current"));
    }
    public boolean checkSausesIsVisible(){
        return new WebDriverWait(webDriver, 7).until(ExpectedConditions.attributeContains(sauses, "class", "current"));
    }
    public boolean checkFillingsIsVisible(){
        return new WebDriverWait(webDriver, 7).until(ExpectedConditions.attributeContains(filling, "class", "current"));
    }

    // Вынужденно добавила этот метод,тк авторизация падает с любыми другими ожиданиями
    public void waiting(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
