package dev.hendratommy.training.inventory.domain.entity;

import dev.hendratommy.training.inventory.domain.policy.RegexEventParser;
import dev.hendratommy.training.inventory.domain.policy.SplitEventParser;
import dev.hendratommy.training.inventory.domain.vo.Activity;
import dev.hendratommy.training.inventory.domain.vo.EventId;
import dev.hendratommy.training.inventory.domain.vo.ParsePolicyType;
import dev.hendratommy.training.inventory.domain.vo.Protocol;

import java.time.OffsetDateTime;
import java.util.Objects;

public class Event implements Comparable<Event> {
    private EventId id;
    private OffsetDateTime timestamp;
    private Protocol protocol;
    private Activity activity;

    public Event(EventId id, OffsetDateTime timestamp, Protocol protocol, Activity activity){
        this.id = id;
        this.timestamp = timestamp;
        this.protocol = protocol;
        this.activity = activity;
    }

    public static Event parsedEvent(String unparsedEvent, ParsePolicyType policy){
        switch (policy) {
            case REGEX:
                return new RegexEventParser().parseEvent(unparsedEvent);
            case SPLIT:
                return new SplitEventParser().parseEvent(unparsedEvent);
            default: throw  new IllegalArgumentException("");
        }
    }

    @Override
    public int compareTo(Event event) {
        return timestamp.compareTo(event.timestamp);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Event) {
            Event event = (Event)obj;
            return (event.timestamp.equals(this.timestamp)
                    && event.id.equals(this.id)
                    && event.protocol.equals(this.protocol)
                    && event.activity.equals(this.activity)
            );
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, id, protocol, activity) + 31;
    }
}
