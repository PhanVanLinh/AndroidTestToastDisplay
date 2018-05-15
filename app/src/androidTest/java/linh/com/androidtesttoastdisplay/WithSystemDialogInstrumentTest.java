package linh.com.androidtesttoastdisplay;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiSelector;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class WithSystemDialogInstrumentTest {
    private UiDevice device;

    @Before
    public void before() {
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    }
    @Rule
    public ActivityTestRule<WithSystemDialogActivity> activityTestRule =
            new ActivityTestRule<>(WithSystemDialogActivity.class);

    @Test
    public void useAppContext() throws Exception {
        onView(withId(R.id.button_click)).perform(click());
        device.findObject(new UiSelector().text("DENY")).click();
        onView(withText(Constant.TOAST_SHOW)).inRoot(
                withDecorView(not(is(activityTestRule.getActivity().getWindow().getDecorView()))))
                .check(matches(isDisplayed()));
    }
}
