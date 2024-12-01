package tests;

import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.VacancyPage;

@Owner("Denis Gubert")
public class VacancyPageTests extends BaseTest {

    VacancyPage page = new VacancyPage();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Issue("AUT-1234")
    @DisplayName("Проверка Title на странице Вакансий")
    void shouldHaveVacancyTitle() {
        page.openVacancyPage();

        page.shoudHaveTitle("Вакансии | Озерки");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Issue("AUT-1236")
    @ParameterizedTest(name = "Проверка поиска вакансии по значению {0}")
    @ValueSource(strings = {
            "Приладожский",
            "Пейзажная",
            "Беляево"
    }
    )
    @Disabled
    void shouldHaveVacanciesAfterSearch(String searchString) throws InterruptedException {
        page.openVacancyPage()
                .filterVacanciesByString(searchString);

        page.shoudHaveStringInVacancies(searchString);
    }
}
