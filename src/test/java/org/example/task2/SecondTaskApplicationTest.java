package org.example.task2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SecondTaskApplicationTest {

    private final SecondTaskApplication secondTaskApplication = new SecondTaskApplication();

    @Test
    void testGroupByOrgIdAndGroupId() {
        List<Profile> data = new ArrayList<>();
        data.add(new Profile(1L, 0L, 1L));
        data.add(new Profile(2L, 0L, 1L));
        data.add(new Profile(3L, 0L, 2L));
        data.add(new Profile(4L, 1L, 1L));
        data.add(new Profile(5L, 1L, 2L));
        Map<Long, Map<Long, List<Profile>>> resultExample = new TreeMap<>();
        resultExample.put(0L, new TreeMap<>());
        resultExample.get(0L).put(1L,
                List.of(
                        new Profile(1L, 0L, 1L),
                        new Profile(2L, 0L, 1L)
                )
        );
        resultExample.get(0L).put(2L,
                List.of(
                        new Profile(3L, 0L, 2L)
                )
        );
        resultExample.put(1L, new TreeMap<>());
        resultExample.get(1L).put(1L,
                List.of(
                        new Profile(4L, 1L, 1L)
                )
        );
        resultExample.get(1L).put(2L,
                List.of(
                        new Profile(5L, 1L, 2L)
                )
        );
        Map<Long, Map<Long, List<Profile>>> result = secondTaskApplication.groupByOrgIdAndGroupId(data);
        assertEquals(result, resultExample);
    }

}