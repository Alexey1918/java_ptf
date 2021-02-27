package ru.stqa.ptf.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SquareTests {

     @Test
    public void testArea(){

        Square c = new Square(5);
        Assert.assertEquals(c.area(),25);
    }
}
