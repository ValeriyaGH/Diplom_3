package site.nomoreparties.stellarburgers.pageobject;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.model.NewUser;

public class RegistrPage {
    private By regName = By.xpath("//label[contains(text(),'Имя')]/../input");
    private By regEmail = By.xpath("//label[contains(text(),'Email')]/../input");
    private By regPassword = By.xpath("//label[contains(text(),'Пароль')]/../input");
    private By regButton = By.xpath("//button[contains(text(),'Зарегистрироваться')]");
    private By errorIncorrectPassword = By.xpath(".//p[text() = 'Некорректный пароль']");
    private By loginButton = By.xpath(".//a[text()='Войти']");

    private final WebDriver webDriver;
    private String name;
    private String email;
    private String password;
    private NewUser newUser;


    public RegistrPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Ввод регистрационных данных")
    @Description("Вводим имя, email, пароль, кликаем по кнопке 'регистрация'")
    public void setRegInformation(NewUser newUser) {
        webDriver.findElement(regName).sendKeys(newUser.getName());
        webDriver.findElement(regEmail).sendKeys(newUser.getEmail());
        webDriver.findElement(regPassword).sendKeys(newUser.getPassword());
        webDriver.findElement(regButton).click();
    }

    @Step("Проверка сообщения об ошибке")
    public boolean checkErrorMessage() {
        return webDriver.findElement(errorIncorrectPassword).isDisplayed();
    }

    @Step("Клик по кнопке 'Авторизация' со страницы регистрации")
    public void clickLoginButton() {
        webDriver.findElement(loginButton).click();
    }
}
