package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class PointTest {

    @Test
    public void testDistance(){

        Point a = new Point(2,2);
        Point b = new Point(8,8);

        Assert.assertEquals(a.distance(b),8.48528137423857);
    }
}
