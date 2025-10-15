package com.qa.app;

import com.qa.app.SwimmablePackage.FishPackage.Blobfish;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(BlobfishParameterResolver.class)
public class BlobfishParameterizedTest {

    @ParameterizedTest
    @ValueSource(ints = {10, 20, 30, 40})
    @DisplayName("Test Blobfish Setters with Valid Values")
    public void testBlobfishLength(int length, Blobfish blobfish) {
        blobfish.setLength(length);

        assertEquals(length, blobfish.getLength());

    }

    @ParameterizedTest
    @ValueSource(ints = {-10, -20, -1, -4})
    @DisplayName("Test Blobfish Setters with Valid Values")
    public void testBlobfishInvalid(int length, Blobfish blobfish) {

        Exception invalidLengthException = assertThrows(IllegalArgumentException.class, () -> {
            blobfish.setLength(length);
        });

        assertEquals("Length must be positive", invalidLengthException.getMessage());
    }


    @ParameterizedTest
    @CsvSource({"10, 20.3", "20, 3.4", "40, 300.54"})
    @DisplayName("Test Blobfish Setters with Valid Values")
    public void testBlobfishValid(int length, float weight,  Blobfish blobfish) {
        blobfish.setWeight(weight);
        blobfish.setLength(length);

        assertEquals(length, blobfish.getLength());
        assertEquals(weight, blobfish.getWeight());

    }
}
