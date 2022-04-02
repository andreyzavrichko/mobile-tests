package ru.zavrichko.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("selenide")
public class AndroidSelenideTests extends TestBase {
    @Test
    @Feature("Authorization")
    @Story("Onboarding")
    @DisplayName("Check onboarding")
    @Severity(SeverityLevel.BLOCKER)
    void onboardingTest() {
        step("Allow access", () ->
                $(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")).click());

        step("First onboarding page", () -> {
            $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/textTitle"))
                    .shouldHave(Condition.text("Welcome to ColorNote"));
            $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/btn_start")).click();
        });

        step("Second onboarding page", () -> {
            $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/textTitle"))
                    .shouldHave(Condition.text("Create a note"));
            $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/btn_next")).click();
        });

        step("Third onboarding page", () -> {
            $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/textTitle"))
                    .shouldHave(Condition.text("Choose a note type"));
            $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/btn_next")).click();
        });
    }

    @Test
    @Feature("Note")
    @Story("Note")
    @DisplayName("Check create note")
    @Severity(SeverityLevel.BLOCKER)
    void createNoteTest() {
        step("Allow access", () ->
                $(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")).click());

        step("Skip onboarding page", () ->
                $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/btn_start_skip")).click());

        step("Create new note button", () ->
                $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/bottom_fab")).click());

        step("Create new note", () ->
                $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/text")).click());

        step("Type note", () -> {
            $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/edit_note"))
                    .setValue("123456");
        });
        step("Exit", Selenide::back);
        step("Exit", Selenide::back);
        step("Check create note", () -> {
            $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/content_container")).shouldBe(Condition.visible);
        });
    }

    @Test
    @Feature("Checklist")
    @Story("Checklist")
    @DisplayName("Check create check list")
    @Severity(SeverityLevel.BLOCKER)
    void createChecklistTest() {
        step("Allow access", () ->
                $(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")).click());

        step("Skip onboarding page", () ->
                $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/btn_start_skip")).click());

        step("Create new note button", () ->
                $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/bottom_fab")).click());

        step("Create new checkbox", () ->
                $(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.TextView")).click());

        step("Add new item", () ->
                $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/text")).click());

        step("Add title", () -> {
            $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/edit"))
                    .setValue("New item");
        });
        step("Tap button OK", () ->
                $(AppiumBy.id("android:id/button1")).click());

        step("Check create checklist", () -> {
            $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/text")).shouldBe(Condition.visible);
        });
    }


    @Test
    @Feature("Calendar")
    @Story("Calendar")
    @DisplayName("Check calendar")
    @Severity(SeverityLevel.NORMAL)
    void checkCalendarTest() {
        step("Allow access", () ->
                $(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")).click());

        step("Skip onboarding page", () ->
                $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/btn_start_skip")).click());

        step("Tap calendar button", () ->
                $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/page_calendar")).click());

        step("Check calendar", () -> {
            $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/month_view")).shouldBe(Condition.visible);
        });
    }

    @Test
    @Feature("Search")
    @Story("Search")
    @DisplayName("Check search")
    @Severity(SeverityLevel.NORMAL)
    void checkSearchTest() {
        step("Allow access", () ->
                $(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")).click());

        step("Skip onboarding page", () ->
                $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/btn_start_skip")).click());

        step("Tap search button", () ->
                $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/page_search")).click());

        step("Check search", () -> {
            $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/edit_search")).shouldBe(Condition.visible);
        });
    }

    @Test
    @Feature("Menu")
    @Story("Menu")
    @DisplayName("Check menu")
    @Severity(SeverityLevel.MINOR)
    void checkMenuTest() {
        step("Allow access", () ->
                $(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")).click());

        step("Skip onboarding page", () ->
                $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/btn_start_skip")).click());

        step("Tap menu button", () ->
                $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/page_more")).click());

        step("Check menu", () -> {
            $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/main_title")).shouldBe(Condition.visible);
        });
    }

    @Test
    @Feature("Color")
    @Story("Color")
    @DisplayName("Check color")
    @Severity(SeverityLevel.MINOR)
    void colorTest() {
        step("Allow access", () ->
                $(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")).click());

        step("Skip onboarding page", () ->
                $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/btn_start_skip")).click());

        step("Tap color button", () ->
                $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/main_btn1")).click());

        step("Tap color", () ->
                $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/item_container")).click());

        step("Check color", () -> {
            $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/text_button_center")).shouldBe(Condition.visible);
        });
    }

    @Test
    @Feature("More")
    @Story("More")
    @DisplayName("Check more button")
    @Severity(SeverityLevel.MINOR)
    void moreTest() {
        step("Allow access", () ->
                $(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")).click());

        step("Skip onboarding page", () ->
                $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/btn_start_skip")).click());

        step("Tap more button", () ->
                $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/main_btn3")).click());

        step("Tap view", () ->
                $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/text")).click());

        step("Check view", () -> {
            $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/alertTitle")).shouldBe(Condition.visible);
        });
    }

    @Test
    @Feature("Archive")
    @Story("Archive")
    @DisplayName("Check archive")
    @Severity(SeverityLevel.NORMAL)
    void archiveTest() {
        step("Allow access", () ->
                $(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")).click());

        step("Skip onboarding page", () ->
                $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/btn_start_skip")).click());

        step("Tap menu button", () ->
                $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/page_more")).click());

        step("Tap archive button", () ->
                $(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/c.q.a.b/android.widget.ScrollView/android.widget.LinearLayout/android.widget.GridView/android.widget.LinearLayout[1]/android.widget.TextView")).click());

        step("Check archive", () -> {
            $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/main_title")).shouldBe(Condition.visible);
        });
    }

    @Test
    @Feature("Trash")
    @Story("Trash")
    @DisplayName("Check trash")
    @Severity(SeverityLevel.CRITICAL)
    void trashTest() {
        step("Allow access", () ->
                $(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")).click());

        step("Skip onboarding page", () ->
                $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/btn_start_skip")).click());

        step("Tap menu button", () ->
                $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/page_more")).click());

        step("Tap trash button", () ->
                $(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/c.q.a.b/android.widget.ScrollView/android.widget.LinearLayout/android.widget.GridView/android.widget.LinearLayout[2]/android.widget.TextView")).click());

        step("Check trash", () -> {
            $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/main_title")).shouldBe(Condition.visible);
        });
    }

    @Test
    @Feature("Settings")
    @Story("Settings")
    @DisplayName("Check settings")
    @Severity(SeverityLevel.CRITICAL)
    void settingsTest() {
        step("Allow access", () ->
                $(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")).click());

        step("Skip onboarding page", () ->
                $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/btn_start_skip")).click());

        step("Tap menu button", () ->
                $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/page_more")).click());

        step("Tap settings button", () ->
                $(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/c.q.a.b/android.widget.ScrollView/android.widget.LinearLayout/android.widget.GridView/android.widget.LinearLayout[3]/android.widget.TextView")).click());

        step("Check trash", () -> {
            $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/action_bar")).shouldBe(Condition.visible);
        });
    }

    @Test
    @Feature("Theme")
    @Story("Theme")
    @DisplayName("Check theme")
    @Severity(SeverityLevel.CRITICAL)
    void themeTest() {
        step("Allow access", () ->
                $(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")).click());

        step("Skip onboarding page", () ->
                $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/btn_start_skip")).click());

        step("Tap menu button", () ->
                $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/page_more")).click());

        step("Tap theme button", () ->
                $(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/c.q.a.b/android.widget.ScrollView/android.widget.LinearLayout/android.widget.GridView/android.widget.LinearLayout[4]/android.widget.TextView")).click());

        step("Check theme", () -> {
            $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/title_template")).shouldBe(Condition.visible);
        });
    }

    @Test
    @Feature("Tutorial")
    @Story("Tutorial")
    @DisplayName("Check tutorial")
    @Severity(SeverityLevel.CRITICAL)
    void tutorialTest() {
        step("Allow access", () ->
                $(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")).click());

        step("Skip onboarding page", () ->
                $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/btn_start_skip")).click());

        step("Tap menu button", () ->
                $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/page_more")).click());

        step("Tap tutorial button", () ->
                $(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/c.q.a.b/android.widget.ScrollView/android.widget.LinearLayout/android.widget.GridView/android.widget.LinearLayout[5]/android.widget.TextView")).click());

        step("Check tutorial", () -> {
            $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/textTitle"))
                    .shouldHave(Condition.text("Welcome to ColorNote"));
        });
    }

    @Test
    @Feature("Sort")
    @Story("Sort")
    @DisplayName("Check sorting")
    @Severity(SeverityLevel.NORMAL)
    void sortTest() {
        step("Allow access", () ->
                $(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")).click());

        step("Skip onboarding page", () ->
                $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/btn_start_skip")).click());

        step("Tap sort button", () ->
                $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/text_button_center")).click());

        step("Tap sort by modified time button", () ->
                $(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/c.q.a.b/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.TextView")).click());

        step("Check tutorial", () -> {
            $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/empty_text"))
                    .shouldHave(Condition.text("Add note"));
        });
    }

    @Test
    @Feature("Note")
    @Story("Note")
    @DisplayName("Check add note")
    @Severity(SeverityLevel.BLOCKER)
    void addNoteTest() {
        step("Allow access", () ->
                $(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")).click());

        step("Skip onboarding page", () ->
                $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/btn_start_skip")).click());

        step("add new note button", () ->
                $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/empty_text")).click());

        step("Create new note", () ->
                $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/text")).click());

        step("Type note", () -> {
            $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/edit_note"))
                    .setValue("123456");
        });
        step("Exit", Selenide::back);
        step("Exit", Selenide::back);
        step("Check create note", () -> {
            $(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/content_container")).shouldBe(Condition.visible);
        });
    }
}
