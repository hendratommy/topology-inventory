package dev.hendratommy.training.inventory.domain.vo;

import java.util.UUID;

public class RouterId {
    private final UUID id;

    public RouterId() {
        id = UUID.randomUUID();
    }

    public RouterId(String id) {
        this.id = UUID.fromString(id);
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return new StringBuilder("RouterId{")
                .append("id='").append(this.id.toString())
                .append("'}").toString();
    }
}
