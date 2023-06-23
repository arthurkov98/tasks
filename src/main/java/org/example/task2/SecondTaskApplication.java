package org.example.task2;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class SecondTaskApplication {
    public Map<Long, Map<Long, List<Profile>>> groupByOrgIdAndGroupId(List<Profile> data) {
        return data.stream()
                .collect(groupingBy(Profile::getOrgId, groupingBy(Profile::getGroupId)));
    }
}
