package dev.hendratommy.training.inventory.domain.vo;

import java.util.UUID;

public class SwitchId {
    private final UUID id;

    public SwitchId() {
        id = UUID.randomUUID();
    }

    public SwitchId(String id) {
        this.id = UUID.fromString(id);
    }

    @Override
    public String toString() {
        return new StringBuilder("SwitchId{")
                .append("id='").append(this.id.toString())
                .append("'}").toString();
    }
}
