package com.andrewbogdanovich.github.epamproject;

import android.content.Intent;
import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.andrewbogdanovich.github.epamproject.activitys.CalculatorActivity;

import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Tom on 11.10.2017.
 */

public class CalculatorAndroidTest {

    private ActivityTestRule<CalculatorActivity> calculatorActivity = new ActivityTestRule<>(CalculatorActivity.class);

    @Test
    public void testActivityRun() {
        calculatorActivity.launchActivity(new Intent());

        ViewInteraction calculateButton = onView(withId(R.id.calculate_button));
        calculateButton.check(matches(isDisplayed()));
        calculateButton.check(new ViewAssertion() {
            @Override
            public void check(View view, NoMatchingViewException noViewFoundException) {
                if (!view.isEnabled()) {
                    throw new IllegalStateException("button is enabled");
                }
            }
        });
        onView(withId(R.id.input_first_field_edit_text)).perform(typeText("4"));
        onView(withId(R.id.input_second_field_edit_text)).perform(typeText("2"));

        calculateButton.perform(click());

        onView(withId(R.id.input_first_field_edit_text)).check(new ViewAssertion() {
            @Override
            public void check(View view, NoMatchingViewException noViewFoundException) {
                if(!((EditText) view).getText().toString().equals("6")){
                    throw new IllegalStateException("is not 6");
                }
            }
        });

        onView(withId(R.id.result_text_view)).check(new ViewAssertion() {
            @Override
            public void check(View view, NoMatchingViewException noViewFoundException) {
                if (!((TextView) view).getText().toString().equals("6 / 2 = 3")) {
                    throw new IllegalStateException("result wrong. Aspected 3");
                }
            }
        });
    }
}
