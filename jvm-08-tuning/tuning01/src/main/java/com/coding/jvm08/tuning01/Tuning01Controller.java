package com.coding.jvm08.tuning01;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Tuning01Controller {

    private final PeopleService peopleService;

    @RequestMapping("/visit")
    public List<People> visit() {
        List<People> peopleList = peopleService.getPeopleList();
        return peopleList;
    }
}
