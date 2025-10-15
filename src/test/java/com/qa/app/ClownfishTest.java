package com.qa.app;

import com.qa.app.SwimmablePackage.FishPackage.Clownfish;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;
import java.awt.Color;
import java.util.ArrayList;

@ExtendWith(ClownfishParameterResolver.class)
public class ClownfishTest {

    // test clownfish setters with valid values
    @Test
    @DisplayName("Test Clownfish Setters with Valid Values")
    public void testClownfishSettersValid(Clownfish clownfish) {
        clownfish.setLength(15);
        clownfish.setWeight(7.5f);
        clownfish.setColor(Color.YELLOW);

        assertEquals(15, clownfish.getLength());
        assertEquals(7.5f, clownfish.getWeight());
        assertEquals(Color.YELLOW, clownfish.getColor());
    }

    // test clownfish setters with invalid values
    @Test
    @DisplayName("Test Clownfish Setters with Invalid Values")
    public void testClownfishSettersInvalid(Clownfish clownfish) {
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
    @DisplayName("Test Clownfish Eat Method")
    public void testClownfishEat(Clownfish clownfish) {
        ArrayList<String> food = clownfish.eat();
        assertTrue(food.contains("algae"));
        assertTrue(food.contains("zooplankton (like copepods)"));
        assertTrue(food.contains("small crustaceans"));
        assertTrue(food.contains("leftover food from their host anemones"));

        assertEquals(4, food.size());
    }
}