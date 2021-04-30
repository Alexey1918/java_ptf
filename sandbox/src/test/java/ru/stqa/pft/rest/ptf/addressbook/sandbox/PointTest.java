package ru.stqa.pft.rest.ptf.addressbook.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

    @Test
    public void testDistance(){

        Point a = new Point(2,2);
        Point b = new Point(8,8);

        Assert.assertEquals(a.distance(b),8.48528137423857);
    }
}
