import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideGitHub {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void wikiPageSelenideInGithub() {
        //открыть страницу https://github.com/selenide/selenide
        open("/selenide/selenide");
        //перейти во вкладку Wiki
        $("#wiki-tab").click();
        //развернуть меню "Show 2 more pages"
        $("#wiki-pages-box").$(withText("Show 2 more pages")).click();
        //проверить наличие страницы SoftAssertions
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        //перейти на страницу SoftAssertions
        $("#wiki-pages-box").$(withText("SoftAssertions")).click();
        //проверить, что на открывшеся странице есть пример кода для JUnit5
        $("#user-content-3-using-junit5-extend-test-class").sibling(0).shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));

    }
    //{
    //Configuration.holdBrowserOpen = true;
    //}
}
