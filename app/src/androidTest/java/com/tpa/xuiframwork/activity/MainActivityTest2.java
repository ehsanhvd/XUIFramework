package com.tpa.xuiframwork.activity;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.tpa.xuiframwork.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.longClick;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest2 {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }

    @Test
    public void mainActivityTest2() {
        ViewInteraction switchCompat = onView(
                allOf(withId(R.id.switchRtl),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.frameDrawerContainer),
                                        0),
                                3),
                        isDisplayed()));
        switchCompat.perform(click());

        ViewInteraction switchCompat2 = onView(
                allOf(withId(R.id.switchRtl),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.frameDrawerContainer),
                                        0),
                                3),
                        isDisplayed()));
        switchCompat2.perform(click());

        ViewInteraction linearLayout = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.recyclerView),
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0)),
                        10),
                        isDisplayed()));
        linearLayout.perform(click());

        ViewInteraction appCompatImageView = onView(
                allOf(withId(R.id.imgMenu),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.frameDrawerContainer),
                                        0),
                                0),
                        isDisplayed()));
        appCompatImageView.perform(click());

        ViewInteraction _LinearLayout = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.frameDrawer),
                                0),
                        2),
                        isDisplayed()));
        _LinearLayout.perform(click());

        ViewInteraction linearLayout2 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.recyclerView),
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0)),
                        1),
                        isDisplayed()));
        linearLayout2.perform(longClick());
    }
}
