package com.dyh.test.design_mode.strategy.spring;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QueryTicketDConcreteStrategy implements QueryTicketStrategy {
    @Override
    public List<Ticket> getTicketList() {
        List<Ticket> list = new ArrayList<>();
        list.add(new Ticket("去程第一张机票"));
        list.add(new Ticket("去程第二张机票"));
        list.add(new Ticket("返程第一张机票"));
        list.add(new Ticket("返程第二张机票"));
        return list;
    }
}
