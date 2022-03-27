package ru.zavrichko.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("selenide")
public class AndroidSelenideTests extends TestBase {
    @Test
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


//    }
}

