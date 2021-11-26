package com.dyh.test.design_mode.strategy.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class Context {

    @Autowired
    private QueryTicketStrategy queryTicketAConcreteStrategy;

    @Autowired
    private QueryTicketStrategy queryTicketDConcreteStrategy;

    private static Map<Integer, QueryTicketStrategy> map = new HashMap<>();

    @PostConstruct
    public void init() {
        map.put(1, queryTicketAConcreteStrategy);
        map.put(4, queryTicketAConcreteStrategy);
    }

    public void getTicketList(int type) {
        System.out.println(map.get(type).getTicketList());
    }
}
