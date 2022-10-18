package dev.hendratommy.training.inventory.framework.adapter.output.file.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class RouterJson {
    @JsonProperty("routerId")
    private UUID routerId;

    @JsonProperty("routerType")
    private RouterTypeJson routerType;

    @JsonProperty("switch")
    private SwitchJson networkSwitch;

    public RouterJson(UUID routerId, RouterTypeJson routerType, SwitchJson networkSwitch) {
        this.routerId = routerId;
        this.routerType = routerType;
        this.networkSwitch = networkSwitch;
    }

    public UUID getRouterId() {
        return routerId;
    }

    public void setRouterId(UUID routerId) {
        this.routerId = routerId;
    }

    public RouterTypeJson getRouterType() {
        return routerType;
    }

    public void setRouterType(RouterTypeJson routerType) {
        this.routerType = routerType;
    }

    public SwitchJson getNetworkSwitch() {
        return networkSwitch;
    }

    public void setNetworkSwitch(SwitchJson networkSwitch) {
        this.networkSwitch = networkSwitch;
    }
}
