package com.example.stickhero;
import org.junit.*;
import static org.junit.Assert.*;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Start2Test {
    @Test
    public void testStick(){
        if(Start2.isStickFell())Assert.assertTrue(Start2.isValidStick());
    }

    @Test
    public void testCherryCollection(){
        if(Start2.isCherryIncremented())Assert.assertTrue(Start2.isStickmanIntersects());
    }
}



