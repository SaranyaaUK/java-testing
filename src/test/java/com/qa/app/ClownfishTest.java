package com.qa.app;

import com.qa.app.SwimmablePackage.FishPackage.Clownfish;
import com.qa.app.SwimmablePackage.HomosapiensPackage.CantSwimException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class ClownfishTest {

    // Test the Clownfish class
    @Test
    public void testClownfishConstructor() {
        Clownfish clownfish = new Clownfish(10, 5.0f);

        // Test getters
        assertEquals(10, clownfish.getLength());
        assertEquals(5.0f, clownfish.getWeight());
        assertEquals(Color.ORANGE, clownfish.getColor());
    }

    // test clownfish setters with valid values
    @Test
    public void testClownfishSettersValid() {
        Clownfish clownfish = new Clownfish(10, 5.0f);

        clownfish.setLength(15);
        clownfish.setWeight(7.5f);
        clownfish.setColor(Color.YELLOW);

        assertEquals(15, clownfish.getLength());
        assertEquals(7.5f, clownfish.getWeight());
        assertEquals(Color.YELLOW, clownfish.getColor());
    }

    // test clownfish setters with invalid values
    @Test
    public void testClownfishSettersInvalid() {
        Clownfish clownfish = new Clownfish(10, 5.0f);

        Exception lengthException = assertThrows(IllegalArgumentException.class, () -> {
            clownfish.setLength(-5);
        });
        assertEquals("Length must be positive", lengthException.getMessage());

        Exception weightException = assertThrows(IllegalArgumentException.class, () -> {
            clownfish.setWeight(-2.5f);
        });
        assertEquals("Weight must be positive", weightException.getMessage());

        Exception colorException = assertThrows(IllegalArgumentException.class, () -> {
            clownfish.setColor(null);
        });
        assertEquals("Color cannot be null", colorException.getMessage());
    }

    @Test
    public void testClownfishEat() {
        Clownfish clownfish = new Clownfish(10, 5.0f);
        ArrayList<String> food = clownfish.eat();
        assertTrue(food.contains("algae"));
        assertTrue(food.contains("zooplankton (like copepods)"));
        assertTrue(food.contains("small crustaceans"));
        assertTrue(food.contains("leftover food from their host anemones"));

        assertEquals(4, food.size());
    }

    @Test
    public void testClownfishSwim() {
        Clownfish clownfish = new Clownfish(10, 5.0f);

        try {
            Point newPosition = clownfish.swim(0); // swim up
            assertEquals(new Point(0, 1), newPosition);

            newPosition = clownfish.swim(3); // swim right
            assertEquals(new Point(1, 1), newPosition);

            newPosition = clownfish.swim(1); // swim down
            assertEquals(new Point(1, 0), newPosition);

            newPosition = clownfish.swim(2); // swim left
            assertEquals(new Point(0, 0), newPosition);
        } catch (CantSwimException e) {
            fail("Clownfish should be able to swim");
        }
    }

    @Test
    public void testClownfishInvalidSwim() {
        Clownfish clownfish = new Clownfish(10, 5.0f);
        clownfish.setHasGills(false); // Simulate a fish without gills

        Exception swimException = assertThrows(CantSwimException.class, () -> {
            clownfish.swim(0);
        });
        assertEquals("Exception: I can't swim without gills!", swimException.getMessage());
    }
}