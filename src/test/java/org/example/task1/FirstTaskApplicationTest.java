package org.example.task1;

import org.example.task1.domain.ProfileInfo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FirstTaskApplicationTest {

    private final FirstTaskApplication firstTaskApplication = new FirstTaskApplication();

    @Test
    void checkTimeExecution() {
        long start = System.nanoTime();
        firstTaskApplication.getProfileInfo(1L);
        long end = System.nanoTime();
        assertTrue(end - start < Math.pow(10, 9), String.valueOf((end - start) / Math.pow(10, 9)));
    }

    @Test
    void shouldReturnRightData() {
        ProfileInfo profileInfo = firstTaskApplication.getProfileInfo(1L);
        assertEquals(profileInfo.companyInfo.id, "1");
        assertEquals(profileInfo.userInfo.name, "1");
    }
}