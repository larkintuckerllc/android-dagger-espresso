package com.larkintuckerllc.dagger;

import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.larkintuckerllc.dagger.mocks.DaggerMyComponentMock;
import com.larkintuckerllc.dagger.mocks.MyModuleMock;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class) {

        @Override
        protected void beforeActivityLaunched() {
            MyApplication application = (MyApplication) InstrumentationRegistry
                    .getInstrumentation()
                    .getTargetContext()
                    .getApplicationContext();
            MyComponent myComponent = DaggerMyComponentMock
                    .builder()
                    .myModuleMock(new MyModuleMock())
                    .build();
            application.setMyComponent(myComponent);
        }

    };

    @Test
    public void formattedDateShown() {
        onView(withId(R.id.tvDate)).check(matches(withText("Wed Dec 31 19:00:00 EST 1969")));
    }

}