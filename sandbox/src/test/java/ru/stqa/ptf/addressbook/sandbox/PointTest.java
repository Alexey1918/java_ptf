package ru.stqa.ptf.addressbook.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

    @Test
    public void testDistance(){

        ru.stqa.ptf.addressbook.sandbox.Point a = new ru.stqa.ptf.addressbook.sandbox.Point(2,2);
        ru.stqa.ptf.addressbook.sandbox.Point b = new Point(8,8);

        Assert.assertEquals(a.distance(b),8.48528137423857);
    }
}
