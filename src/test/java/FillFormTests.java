import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FillFormTests {
        {
        Configuration.pageLoadStrategy = "eager";
        }
@Test
    void successfulFillFormTest() {
            open("https://demoqa.com/automation-practice-form/");
        $("[id=firstName]").setValue("Anastasiya");
        $("[id=lastName]").setValue("Shpakova");
        $("[id=userEmail]").setValue("test1@bk.ru");
        $("#genterWrapper").$(byText("Female")).click();
        $("[id=userNumber]").setValue("9991002030");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").selectOption("1987");
        $(".react-datepicker__day--022").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("nature2.jpg");
        $("[id=currentAddress]").setValue("Testing 12-35");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("[id=state]").click();
        $("[id=stateCity-wrapper]").$(byText("Haryana")).click();
        $("[id=city]").click();
        $("[id=stateCity-wrapper").$(byText("Panipat")).click();
        $("[id=submit]").click();
        $("[id=example-modal-sizes-title-lg]").shouldHave(text("Thanks for submitting the form"));
        }

    {
        Configuration.holdBrowserOpen = true;
        }
        }