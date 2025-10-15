package com.qa.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.qa.app.SwimmablePackage.HomosapiensPackage.Homosapiens;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Extends with Human that implements Swimmable and Homosapiens
@ExtendWith(MockitoExtension.class)
public class HomosapiensMockTest {

    @Mock
    private Homosapiens homosapiensMock;

    // Setup iq to retirn 40
    @BeforeEach
    public void setUp() {
        Mockito.when(homosapiensMock.getIq()).thenReturn(40);
    }

    @Test
    public void testIQ() {
        assertEquals(40, homosapiensMock.getIq());
    }
}
