package com.qa.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import com.qa.app.SwimmablePackage.Swimmable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import com.qa.app.SwimmablePackage.FishPackage.Blobfish;
import com.qa.app.SwimmablePackage.FishPackage.Clownfish;
import com.qa.app.SwimmablePackage.HomosapiensPackage.Human;
import com.qa.app.SwimmablePackage.HomosapiensPackage.CantSwimException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.awt.Point;
import java.awt.Color;

@ExtendWith(HumanParameterResolver.class)
@ExtendWith(ClownfishParameterResolver.class)
@ExtendWith(BlobfishParameterResolver.class)
public class SwimmableTest {
    
    @Test
    @DisplayName("Test Clownfish Swimming")
    public void testClownfishSwim(Clownfish clownfish) {

        try {
            Point newPosition = clownfish.swim(Swimmable.Direction.UP); // swim up
            assertEquals(new Point(0, 1), newPosition);

            newPosition = clownfish.swim(Swimmable.Direction.RIGHT); // swim right
            assertEquals(new Point(1, 1), newPosition);

            newPosition = clownfish.swim(Swimmable.Direction.DOWN); // swim down
            assertEquals(new Point(1, 0), newPosition);

            newPosition = clownfish.swim(Swimmable.Direction.LEFT); // swim left
            assertEquals(new Point(0, 0), newPosition);
        } catch (CantSwimException e) {
            fail("Clownfish should be able to swim");
        }
    }

    @Test
    @DisplayName("Test Blobfish Invalid Swim")
    public void testBlobfishInvalidSwim(Blobfish blobfish) {
        blobfish.setHasGills(false); // Simulate a fish without gills

        Exception swimException = assertThrows(CantSwimException.class, () -> {
            blobfish.swim(Swimmable.Direction.UP);
        });
        assertEquals("Exception: I can't swim without gills!", swimException.getMessage());
    }

    @Test
    @DisplayName("Test Human Swimming with Stamina")
    public void testHumanSwim(Human human) {

        // try swimming until stamina depletes
        for (int i = 0; i < 10; i++) {
            try {
                Point newPosition = human.swim(Swimmable.Direction.UP); // swim up
                assertEquals(new Point(0, i + 1), newPosition);
            } catch (CantSwimException e) {
                fail("Human should be able to swim with sufficient stamina");
            }
        }

        assertThrows(CantSwimException.class, () -> {
            human.swim(Swimmable.Direction.LEFT); // Attempt to swim with 0 stamina
        });
    }

    @RepeatedTest(2)
    @DisplayName("Test swim in same direction twice")
    public void testSwimTwiceUp(Human human) {
        try {
            Point newPosition = human.swim(Swimmable.Direction.UP); // swim up
        } catch (CantSwimException e) {
            fail("Human should be able to swim with sufficient stamina");
        }

        assertEquals(90, human.getStamina());
        System.out.println("Stamina : " + human.getStamina());
    }
}