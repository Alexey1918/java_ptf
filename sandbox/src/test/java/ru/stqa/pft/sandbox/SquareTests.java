package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;


public class SquareTests {

     @Test
    public void testArea(){

        ru.stqa.pft.rest.pft.sandbox.Square c = new ru.stqa.pft.rest.pft.sandbox.Square(5);
        Assert.assertEquals(c.area(),25.0);
    }
}
