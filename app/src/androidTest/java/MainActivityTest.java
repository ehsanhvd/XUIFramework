import androidx.test.rule.ActivityTestRule;

import com.tpa.xuiframwork.activity.MainActivity;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityTest  {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void ensureTextChangesWork() {
        // Type text and then press the button.



        onView(withText("rtl")).check(matches(isDisplayed()));
//        onView(withId(R.id.changeText)).perform(click());
//
//        // Check that the text was changed.
//        onView(withId(R.id.inputField)).check(matches(withText("Lalala")));
    }
}
