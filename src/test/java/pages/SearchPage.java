package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import com.codeborne.selenide.Selenide;
import static com.codeborne.selenide.Condition.text;
import org.junit.jupiter.params.provider.*;
import java.util.stream.Stream;

    public class SearchPage {
        SelenideElement searchButton = $(".header-search__btn"),
                headerSearchInput = $(".header-search__input"),
                searchPageResult = $(".mts-search__best-results-list"),
                searchPageFilter = $(".mts-search__filter-container");

       public SearchPage openPage() {
           Selenide.open("https://nnov.mts.ru/personal");
           return this;
     }

        public SearchPage searchButtonClick() {
            searchButton.click();
            return this;
        }

        public SearchPage topMenuSearch(String value) {
            headerSearchInput.setValue(value);
            headerSearchInput.pressEnter();
            return this;
        }

        public SearchPage searchResult(String value) {
            searchPageResult.shouldHave(text(value)).shouldBe(visible);
            return this;
        }


        public SearchPage filterListResult(String value) {

            searchPageFilter.shouldHave(text(value)).shouldBe(visible);
            return this;
        }
    }
