package dev.hendratommy.training.inventory.domain.policy;

import dev.hendratommy.training.inventory.domain.entity.Event;
import dev.hendratommy.training.inventory.domain.vo.Activity;
import dev.hendratommy.training.inventory.domain.vo.EventId;
import dev.hendratommy.training.inventory.domain.vo.Protocol;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;

public class SplitEventParser implements EventParser {
    @Override
    public Event parseEvent(String event) {
        var fields = Arrays.asList(event.split(" "));

        var timestamp = LocalDateTime.parse(fields.get(0), formatter).atOffset(ZoneOffset.UTC);
        var id = new EventId(fields.get(1));
        var protocol = Protocol.valueOf(fields.get(2));
        var activity = new Activity(fields.get(3), fields.get(5));

        return new Event(id, timestamp, protocol, activity);
    }
}
