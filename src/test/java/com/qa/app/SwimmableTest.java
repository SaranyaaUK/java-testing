package com.qa.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.qa.app.SwimmablePackage.FishPackage.Blobfish;
import com.qa.app.SwimmablePackage.FishPackage.Clownfish;
import com.qa.app.SwimmablePackage.HomosapiensPackage.Human;
import com.qa.app.SwimmablePackage.HomosapiensPackage.CantSwimException;
import java.awt.Point;
import java.awt.Color;

public class SwimmableTest {
    
    @Test
    @DisplayName("Test Clownfish Swimming")
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
    @DisplayName("Test Clownfish Invalid Swim")
    public void testClownfishInvalidSwim() {
        Blobfish blobfish = new Blobfish(10, 5.0f, Color.PINK);
        blobfish.setHasGills(false); // Simulate a fish without gills

        Exception swimException = assertThrows(CantSwimException.class, () -> {
            blobfish.swim(0);
        });
        assertEquals("Exception: I can't swim without gills!", swimException.getMessage());
    }

    @Test
    @DisplayName("Test Human Swimming with Stamina")
    public void testHumanSwim() {
        Human human = new Human("Alice");

        // try swimming until stamina depletes
        for (int i = 0; i < 10; i++) {
            try {
                Point newPosition = human.swim(0); // swim up
                assertEquals(new Point(0, i + 1), newPosition);
            } catch (CantSwimException e) {
                fail("Human should be able to swim with sufficient stamina");
            }
        }

        assertThrows(CantSwimException.class, () -> {
            human.swim(0); // Attempt to swim with 0 stamina
        });
    }
}