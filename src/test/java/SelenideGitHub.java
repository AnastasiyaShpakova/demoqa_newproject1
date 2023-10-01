import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideGitHub {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void WikiPageSelenideInGithub() {
        open("/search?q=selenide&type=repositories");
        $(byText("More")).click();
        $(byText("Wikis")).click();
        $("[data-testid=results-list]").shouldHave(text("SoftAssertions"));
        $(byText("SoftAssertions")).click();
        $("#wiki-body").$(withText("Using JUnit5 extend test class")).sibling(0).
                shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
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
        //{
        //Configuration.holdBrowserOpen = true;
        //}
    }

}
