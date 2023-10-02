import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHubEnterpriseTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void checkPageEnterpriseInGithub() {
        open("https://github.com");
        $(byText("Solutions")).hover();
        $(byText("Enterprise")).click();
        $("#js-flash-container").sibling(1).shouldHave(text("Build like the best"));

        //{
        //    Configuration.holdBrowserOpen = true;
        //}

    }
}