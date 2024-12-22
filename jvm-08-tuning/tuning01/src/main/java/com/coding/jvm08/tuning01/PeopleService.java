package com.coding.jvm08.tuning01;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PeopleService {
    private final PeopleMapper peopleMapper;

    public List<People> getPeopleList() {
        return peopleMapper.getPeopleList();
    }
}
