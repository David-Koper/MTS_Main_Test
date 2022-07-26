package cloud.autotests.tests;

import cloud.autotests.helpers.DriverUtils;
import io.qameta.allure.Description;
import org.aspectj.apache.bcel.classfile.Module;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class GeneratedTests extends TestBase {
    @Test
    @DisplayName("MTS_Test")
    void generatedTest() {
        step("Open https://nnov.mts.ru/personal", () -> {
            open("https://nnov.mts.ru/personal");
        });

        step("Click on pay button", () -> {
            $("#payment-widget-btn").click();
        });

        step("Pay modal should be visible", () -> {
            $(".highslide-body").shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Open url 'https://nnov.mts.ru/personal'", () ->
            open("https://nnov.mts.ru/personal"));

        step("Page title should have text 'МТС - связь и экосистема цифровых сервисов - Частным клиентам | Официальный сайт МТС - Нижний Новгород и Нижегородская область'", () -> {
            String expectedTitle = "МТС - связь и экосистема цифровых сервисов - Частным клиентам | Официальный сайт МТС - Нижний Новгород и Нижегородская область";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://nnov.mts.ru/personal'", () ->
            open("https://nnov.mts.ru/personal"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}