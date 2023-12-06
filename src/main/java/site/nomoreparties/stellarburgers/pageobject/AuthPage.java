package site.nomoreparties.stellarburgers.pageobject;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.model.CreatedUser;

public class AuthPage {
    private final WebDriver driver;
    private String email;
    private String password;
    CreatedUser createdUser;
    private By registrationButton = By.xpath(".//a[(@class = 'Auth_link__1fOlj' and text()= 'Зарегистрироваться')]");
    private By authEmail = By.xpath(".//label[contains(text(),'Email')]/../input");
    private By authPassword = By.xpath(".//label[contains(text(),'Пароль')]/../input");
    private By authButton = By.xpath(".//button[text()='Войти']");
    private By passwordRecoveryButton = By.xpath(".//a[text()='Восстановить пароль']");
    private By authFromRecoveryPassword = By.xpath(".//a[text()='Войти']");

    public AuthPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    @Step("Клик по кнопке 'Регистрация'")
    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    @Step("Авторзация пользователя")
    @Description("Вводим логин и пароль, нажимаем на кнопку 'Авторизация'")
    public void authUser(String email, String password) {
        driver.findElement(authEmail).sendKeys(email);
        driver.findElement(authPassword).sendKeys(password);
        driver.findElement(authButton).click();
    }

    @Step("Клик по кнопке восстановления пароля")
    public void clickPasswordRecoveryButton() {
        driver.findElement(passwordRecoveryButton).click();
    }

    @Step("Клик по кнопке 'Авторизация' на странице восстановления пароля")
    public void clickAuthButtonFromRecoveryPassword() {
        driver.findElement(authFromRecoveryPassword).click();
    }

    @Step("Проверка видимости кнопки авторизации")
    public boolean checkLoginButtonIsVisible() {
        return driver.findElement(authButton).isDisplayed();
    }

}
