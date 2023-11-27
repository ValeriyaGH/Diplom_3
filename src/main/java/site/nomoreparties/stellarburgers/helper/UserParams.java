package site.nomoreparties.stellarburgers.helper;

import org.apache.commons.lang3.RandomStringUtils;
import site.nomoreparties.stellarburgers.model.NewUser;

public class UserParams {
    public static NewUser randomUser(){
        String email = RandomStringUtils.randomAlphabetic(5, 10) + RandomStringUtils.randomNumeric(10) + "@yandex.ru";
        String password = RandomStringUtils.randomAlphabetic(5) + RandomStringUtils.randomNumeric(1);
        String name = RandomStringUtils.randomAlphabetic(10);
        return new NewUser(email, password, name);
    }
    public static NewUser userWithPasswordFiveSymbols(){
        String email = RandomStringUtils.randomAlphabetic(5,10) + RandomStringUtils.randomNumeric(5) + "@ya.ru";
        String password = RandomStringUtils.randomAlphabetic(3)+ RandomStringUtils.randomNumeric(2);
        String name = RandomStringUtils.randomAlphabetic(10);
        return new NewUser(email, password, name);
    }
}
