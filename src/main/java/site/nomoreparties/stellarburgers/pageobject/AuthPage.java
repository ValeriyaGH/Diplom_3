package site.nomoreparties.stellarburgers.pageobject;

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

    public AuthPage(WebDriver webDriver){
        this.driver = webDriver;
    }
    public void clickRegistrationButton(){
        driver.findElement(registrationButton).click();
    }
    public void authUser(String email, String password){
        driver.findElement(authEmail).sendKeys(email);
        driver.findElement(authPassword).sendKeys(password);
        driver.findElement(authButton).click();
    }
    public void clickPasswordRecoveryButton(){
        driver.findElement(passwordRecoveryButton).click();
    }
    public void clickAuthButtonFromRecoveryPassword(){
        driver.findElement(authFromRecoveryPassword).click();
    }

    public boolean checkLoginButtonIsVisible(){
        return driver.findElement(authButton).isDisplayed();
    }

}
