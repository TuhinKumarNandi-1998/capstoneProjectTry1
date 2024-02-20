package com.example.capstoneprojecttry1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RandomTest {
    @Test
    void onePlusOneEqualToTwo() {
        // arrange
        int i = 2;

        // act
        i += 2;

        // assert
        assert i==4;

        assert i*i == 16;

        assertTrue(i==4);
        assertEquals(16, i*i);

    }
}
