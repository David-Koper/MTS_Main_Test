package cloud.autotests.tests;

import cloud.autotests.helpers.DriverUtils;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.SearchPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class MTS_MainPage_Tests extends TestBase {
    @Test
    @Disabled
    @DisplayName("MTS_Pay_Test")
    void payTest() {
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
    @Disabled
    @DisplayName("MTS_allProducts_Test")
    void subMenuTest() {
        step("Open https://nnov.mts.ru/personal", () -> {
            open("https://nnov.mts.ru/personal");
        });

        step("Click on all products button", () -> {
            $(".prp-products-widget-container").click();
        });

        step("All products modal should be visible", () -> {
            $(".prp-sidebar").shouldBe(visible);
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

    @ValueSource(strings = {"нетариф", "НЕТАРИФ", "НеТаРиФ", "НЕТА", "Junior", "JuNioR"})
    @ParameterizedTest(name = "МТС, при вводе {0} в результатах есть поле НЕТАРИФ Junior, а так же фильтр Тарифы")
    void valueTest(String testData) {
        searchPage.openPage()
                .searchButtonClick()
                .topMenuSearch(testData)
                .searchResult("НЕТАРИФ Junior")
                .filterListResult("Тарифы");
    }
}