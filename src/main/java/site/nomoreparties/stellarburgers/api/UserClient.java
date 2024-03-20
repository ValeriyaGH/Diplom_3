package site.nomoreparties.stellarburgers.api;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import site.nomoreparties.stellarburgers.model.CreatedUser;
import site.nomoreparties.stellarburgers.model.NewUser;
import static io.restassured.RestAssured.given;

public class UserClient {
    CreatedUser createdUser;
    NewUser newUser;
    public static final String PATH_AUTH_USER = "/api/auth/login";
    public static final String PATH_GET_USER_INFO = "/api/auth/user";

    public static final String PATH_CREATING_USER = "/api/auth/register";

    @Step("Авторизация созданным пользователем через апи")
    public ValidatableResponse authUser(NewUser newUser) {
        createdUser = new CreatedUser(newUser.getEmail(), newUser.getPassword());
        return given()
                .spec(Confiq.getSpec())
                .body(createdUser)
                .when()
                .post(PATH_AUTH_USER)
                .then();
    }

    @Step("Удаление пользователя через апи")
    public ValidatableResponse deleteUser(String accessToken) {
        return given()
                .spec(Confiq.getSpec())
                .headers("Authorization", accessToken)
                .when()
                .delete(PATH_GET_USER_INFO)
                .then();
    }

    @Step("Создание пользователя через апи")
    public ValidatableResponse creatingUser(NewUser newUser) {
        return given()
                .spec(Confiq.getSpec())
                .body(newUser)
                .when()
                .post(PATH_CREATING_USER)
                .then();
    }
}
