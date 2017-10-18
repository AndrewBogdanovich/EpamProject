package com.andrewbogdanovich.github.epamproject;

import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;

/**
 * Created by Tom on 11.10.2017.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class,
        sdk = Constants.SDK_VERSION
)

public class CalculatorActivityTest {

    private ActivityController<CalculatorActivity> activityController;
    private View TextView;
    private View FirstInputField;
    private View SecondInputField;


    @Before
    public void init() {

        activityController = Robolectric.buildActivity(CalculatorActivity.class);
        // calculatorActivity = activityController.get();
    }

    @Test
    public void calculatorTest() {
        activityController.create();
        activityController.start();
        activityController.resume();
        activityController.pause();

        CalculatorActivity calculatorActivity = activityController.get();
        boolean calculateButton = calculatorActivity.findViewById(R.id.calculate_button).isActivated();
        assertEquals(calculateButton, false);
        assertFalse(calculateButton);


        TextView = calculatorActivity.findViewById(R.id.result_text_view);
        assertEquals(TextView.isEnabled(), true);

        FirstInputField = calculatorActivity.findViewById(R.id.input_first_field_edit_text);
        assertEquals(FirstInputField.isEnabled(), true);

        SecondInputField = calculatorActivity.findViewById(R.id.input_second_field_edit_text);
        assertEquals(FirstInputField.isEnabled(), true);


    }


    @After
    public void destroy() {

    }
}
