package dev.hendratommy.training.inventory.domain.vo;

public class EventId {
    private final String id;

    public EventId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new StringBuilder("EventId{")
                .append("id='").append(this.id)
                .append("'}").toString();
    }
}
