package site.nomoreparties.stellarburgers.pageobject;

import io.qameta.allure.Step;
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
    private By loginButton = By.xpath("//button[contains(text(),'Войти в аккаунт')]");
    private By sauses = By.xpath("//span[text()='Соусы']/..");
    private By filling = By.xpath("//span[text()='Начинки']/..");
    private By buns = By.xpath(".//span[text()='Булки']/..");


    public MainPage(WebDriver webdriver) {
        this.webDriver = webdriver;
    }

    @Step("Открываем страницу тестируемого сервиса")
    public void open() {
        webDriver.get("https://stellarburgers.nomoreparties.site/");
    }

    @Step("Клик по кнопке 'Авторизация'")
    public void clickAuthButton() {
        webDriver.findElement(authButton).click();
    }

    @Step("Клик по кнопке 'Личный кабинет'")
    public void clickPersonalInfoButton() {
        webDriver.findElement(personalInfo).click();
    }

    @Step("Клик по кнопке 'Выход'")
    public void clickExitButton() {
        webDriver.findElement(exitButton).click();
    }

    @Step("Клик по кнопке 'Войти в аккаунт' на главной")
    public void clickLoginButton() {
        webDriver.findElement(loginButton).click();
    }

    @Step("Открыть соусы")
    public void switchToSauses() {
        webDriver.findElement(sauses).click();
    }

    @Step("Открыть начинки")
    public void switchToFilling() {
        webDriver.findElement(filling).click();
    }

    @Step("Открыть булки")
    public void switchToBuns() {
        webDriver.findElement(buns).click();
    }

    @Step("Проверить видимость меню конструктора")
    public boolean checkConstructorMenuIsVisible() {
        return webDriver.findElement(buns).isDisplayed();
    }

    @Step("Проверить что булки отображаются на странице")
    public boolean checkBunsIsVisible() {
        return new WebDriverWait(webDriver, 7).until(ExpectedConditions.attributeContains(buns, "class", "current"));
    }

    @Step("Проверить что соусы отображаются на странице")
    public boolean checkSausesIsVisible() {
        return new WebDriverWait(webDriver, 7).until(ExpectedConditions.attributeContains(sauses, "class", "current"));
    }

    @Step("Проверить что начинки отображаются на странице")
    public boolean checkFillingsIsVisible() {
        return new WebDriverWait(webDriver, 7).until(ExpectedConditions.attributeContains(filling, "class", "current"));
    }

    // Вынужденно добавила этот метод,тк авторизация падает с любыми другими ожиданиями
    public void waiting() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
