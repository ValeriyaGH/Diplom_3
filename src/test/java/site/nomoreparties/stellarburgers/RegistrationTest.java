package site.nomoreparties.stellarburgers;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.api.UserClient;
import site.nomoreparties.stellarburgers.helper.UserParams;
import site.nomoreparties.stellarburgers.model.NewUser;
import site.nomoreparties.stellarburgers.pageobject.AuthPage;
import site.nomoreparties.stellarburgers.pageobject.MainPage;
import site.nomoreparties.stellarburgers.pageobject.PersonalPage;
import site.nomoreparties.stellarburgers.pageobject.RegistrPage;

public class RegistrationTest extends BaseTest{

    MainPage mainPage;
    AuthPage authPage;
    RegistrPage registrPage;
    PersonalPage personalPage;
    UserClient userClient = new UserClient();
    private String userToken;
    private boolean isAccountCreated = false;
    private NewUser randomNewUser = UserParams.randomUser();
    private NewUser randomUserPasswordFiveSymbols = UserParams.userWithPasswordFiveSymbols();

    @Before
    public void init(){
        mainPage = new MainPage(webDriver);
        authPage = new AuthPage(webDriver);
        registrPage = new RegistrPage(webDriver);
        personalPage = new PersonalPage(webDriver);
    }

    @Test
    @DisplayName("Проверка регистрации с рандомными данными")
    @Description("Регистрируем юзера и проверяем что можно войти в аккаунт")
    public void registrationRandomUser() {
        mainPage.open();
        mainPage.clickAuthButton();
        authPage.clickRegistrationButton();
        registrPage.setRegInformation(randomNewUser);
        mainPage.waiting();
        authPage.authUser(randomNewUser.getEmail(), randomNewUser.getPassword());
        mainPage.clickPersonalInfoButton();
        Assert.assertEquals(true, personalPage.checkPersonalMenuIsDisplayed());
        isAccountCreated = true;
        personalPage.clickExitButton();
    }
    @Test
    @DisplayName("Попытка регистрации с паролем из 5 символов")
    public void tryToRegWithShortPassword(){
        mainPage.open();
        mainPage.clickAuthButton();
        authPage.clickRegistrationButton();
        registrPage.setRegInformation(randomUserPasswordFiveSymbols);
        Assert.assertEquals(true, registrPage.checkErrorMessage());
    }

    @After
    public void clean(){
        if(isAccountCreated){
        ValidatableResponse validatableResponse = userClient.authUser(randomNewUser);
        userToken = validatableResponse.extract().path("accessToken");
        userClient.deleteUser(userToken);}
        webDriver.quit();
    }
}
