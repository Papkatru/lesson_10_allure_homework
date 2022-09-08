package quru.qa;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class LambdaTest {

    private static final String REPOSITORY = "Papkatru/lesson_10_allure_homework";
    private static final String ISSUE = "#1";


    @Test
    @Epic("Issues")
    @Feature("Issues в репозитории")
    @Story("Создание issue")
    @Owner("Papkatru")
    @Severity(SeverityLevel.MINOR)
    @Link(value = "Github", url = "https://github.com/")
    @DisplayName("Проверка issue в репозитории")
    void issueSearchWithLambda(){
        SelenideLogger.addListener("allureTest", new AllureSelenide());
        step("Открыть главную страницу github", () -> {
            open("https://github.com/");
        });
        step("Найти репозиторий " + REPOSITORY, context -> {
            $(".header-search-input").setValue(REPOSITORY).submit();
        });
        attachment("Source", webdriver().driver().source());
        step("Кликнуть по ссылке репозитория", () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Открыть таб Issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверить наличие issue с номером " + ISSUE, () -> {
            $(withText(ISSUE)).should(exist);
        });
    }
}
