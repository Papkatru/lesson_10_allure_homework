package quru.qa;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class Steps {
    @Step("Открыть главную страницу github")
    void openMainPage(){
        open("https://github.com/");
    }

    @Step("Найти репозиторий {repo}")
    void searchForRepository(String repo){
        $(".header-search-input").setValue(repo).submit();
    }

    @Step("Кликнуть по по ссылке репозитория {repo}")
    void clickOnRepositoryLink(String repo){
        $(linkText(repo)).click();
    }

    @Step("Открыть таб Issues")
    void openIssueTab(){
        $("#issues-tab").click();
    }

    @Step("Проверить наличие issue с номером {issueNumber}")
    void checkResult(String issueNumber){
        $(withText(issueNumber)).should(exist);
    }

    @Attachment(value = "Screenshot name", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot(){
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
