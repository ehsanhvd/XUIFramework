package com.tpa.xuiframwork.activity;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.Espresso;
import androidx.test.rule.ActivityTestRule;

import com.hvd.xcore.webservice.XRequest;
import com.tpa.xuiframwork.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.google.common.truth.Truth.assertThat;
import static org.hamcrest.Matchers.not;

public class MainActivityTest {

    private static final int DRAWER_WAIT_TIME = 50;
    @Rule
    public ActivityTestRule<MainActivity> activityRule
            = new ActivityTestRule<>(
            MainActivity.class,     //next activity to launch
            true,     // initialTouchMode
            false);


    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);
    private Context context = ApplicationProvider.getApplicationContext();

    @Test
//    @SdkSuppress(minSdkVersion = 30)
    public void ensureTextChangesWork() {
        // Type text and then press the button.


        onView(withText("rtl")).check(matches(isDisplayed()));
//        onView(withId(R.id.changeText)).perform(click());
//
//        // Check that the text was changed.
//        onView(withId(R.id.inputField)).check(matches(withText("Lalala")));
    }

    @Test
    public void checkString() {
        assertThat(context.getString(R.string.app_name)).isEqualTo("XUIFramework");
    }

    @Test
    public void allFragmentsTest() throws InterruptedException {
//        iterateFragments();
        iterateFragments();
        Espresso.registerIdlingResources(XRequest.Companion.getIdlingResource());
        onView(withText("TEST GET REQUEST RAW")).perform(click());
        onView(withId(R.id.textResponse)).check(matches(not(withText(""))));
    }



    private void iterateFragments(){
//        onView(withId(R.id.imgMenu)).perform(click());
//        SystemClock.sleep(DRAWER_WAIT_TIME);
//        onView(withId(R.id.imgMenu)).perform(click());
//        SystemClock.sleep(DRAWER_WAIT_TIME);
//        onView(withText(context.getString(R.string.simpleAdapter))).perform(click());
//        SystemClock.sleep(DRAWER_WAIT_TIME);
//        onView(withId(R.id.imgMenu)).perform(click());
//        SystemClock.sleep(DRAWER_WAIT_TIME);
//        onView(withText(context.getString(R.string.multiSelectAdapter))).perform(click());
//        SystemClock.sleep(DRAWER_WAIT_TIME);
//        onView(withId(R.id.imgMenu)).perform(click());
//        SystemClock.sleep(DRAWER_WAIT_TIME);
//        onView(withText(context.getString(R.string.paginationAdapter))).perform(click());
//        SystemClock.sleep(DRAWER_WAIT_TIME);
//        onView(withId(R.id.imgMenu)).perform(click());
//        SystemClock.sleep(DRAWER_WAIT_TIME);
//        onView(withText(context.getString(R.string.customViews))).perform(click());
//        SystemClock.sleep(DRAWER_WAIT_TIME);
//        onView(withId(R.id.imgMenu)).perform(click());
//        SystemClock.sleep(DRAWER_WAIT_TIME);
//        onView(withText(context.getString(R.string.formBuilder))).perform(click());
//        SystemClock.sleep(DRAWER_WAIT_TIME);
//        onView(withId(R.id.imgMenu)).perform(click());
//        SystemClock.sleep(DRAWER_WAIT_TIME);
//        onView(withText(context.getString(R.string.autoForm))).perform(click());
//        SystemClock.sleep(DRAWER_WAIT_TIME);
        onView(withId(R.id.imgMenu)).perform(click());
        SystemClock.sleep(DRAWER_WAIT_TIME);
        onView(withText(context.getString(R.string.dataFragment))).perform(click());
    }

    @Test
    public void startActivity() {
        Intent intent = new Intent();
        intent.putExtra("your_key", "your_value");

        activityRule.launchActivity(intent);
    }

    @Before
    public void before(){
//        Espresso.registerIdlingResources(XRequest.Companion.getIdlingResource());
    }
}
