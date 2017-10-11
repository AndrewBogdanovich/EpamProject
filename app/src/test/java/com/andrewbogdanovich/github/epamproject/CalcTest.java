package com.andrewbogdanovich.github.epamproject;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Tom on 11.10.2017.
 */

public class CalcTest {

   
    @Test
    public void calcTest() {
        Comparable someMock = mock(CalculatorActivity.class);
        when(someMock.compareTo(anyInt())).thenReturn(3);
        assertEquals(3, someMock.compareTo(5));
    }
}
