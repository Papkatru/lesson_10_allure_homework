package quru.qa;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideListenerTest {

    @Test
    @Epic("Issues")
    @Feature("Issues в репозитории")
    @Story("Создание issue")
    @Owner("Papkatru")
    @Severity(SeverityLevel.MINOR)
    @Link(value = "Github", url = "https://github.com/")
    @DisplayName("Проверка issue в репозитории")
    void issueSearch(){
        SelenideLogger.addListener("allureTest", new AllureSelenide());
        open("https://github.com/");
        $(".header-search-input").setValue("Papkatru/lesson_10_allure_homework").submit();
        $(linkText("Papkatru/lesson_10_allure_homework")).click();
        $("#issues-tab").click();
        $(withText("#1")).should(exist);
    }
}
