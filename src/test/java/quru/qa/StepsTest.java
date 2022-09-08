package quru.qa;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StepsTest {

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
    void issueSearchWithAnnotation(){
        SelenideLogger.addListener("allureTest", new AllureSelenide());
        Steps steps = new Steps();
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.takeScreenshot();
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssueTab();
        steps.checkResult(ISSUE);
    }
}
