package com.ing.tech;


import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class TestExamples {

    @Test
    public void shouldBeEmptyIfNullValueProvided(){
        Optional opt = Optional.ofNullable(null);

        Assert.assertEquals(Optional.empty(), opt);
    }



    @Test
    public void shouldHaveTheSameName() {
        String expected = "example";
        String actual = "example";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldHaveADifferentName() {
        String expected = "example";
        String actual = "example1";

        Assert.assertNotEquals(expected, actual);
    }


}
