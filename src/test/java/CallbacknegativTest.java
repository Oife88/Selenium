import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CallbacknegativTest {
    @Test
    void shouldTestSomething() {
        open("http://localhost:9999/");
        $("[data-test-id=name] input").setValue("Ivanov Василий");
        $("[data-test-id=phone] input").setValue("+79009990909");
        $("[data-test-id=agreement]").click();
        $(By.className("button__text")).click();
        $("[data-test-id=name].input_invalid .input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));


    }
    @Test
    void shouldTestSomethingTel() {
        open("http://localhost:9999/");
        $("[data-test-id=name] input").setValue("Иванов Василий");
        $("[data-test-id=phone] input").setValue("8909965606");
        $("[data-test-id=agreement]").click();
        $(By.className("button__text")).click();
        $("[data-test-id=phone].input_invalid .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));


    }

    @Test
    void shouldTestSomethingName() {
        open("http://localhost:9999/");
        $("[data-test-id=phone] input").setValue("+79099656060");
        $("[data-test-id=agreement]").click();
        $(By.className("button__text")).click();
        $("[data-test-id=name].input_invalid .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));


    }

    @Test
    void shouldTestSomethingPhone() {
        open("http://localhost:9999/");
        $("[data-test-id=name] input").setValue("Иванов Василий");
        //$("[data-test-id=phone] input").setValue("");
        $("[data-test-id=agreement]").click();
        $(By.className("button__text")).click();
        $("[data-test-id=phone].input_invalid .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));


    }

}
