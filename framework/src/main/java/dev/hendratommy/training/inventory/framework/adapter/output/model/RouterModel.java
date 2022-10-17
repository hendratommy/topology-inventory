package dev.hendratommy.training.inventory.framework.adapter.output.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class RouterModel {
    @JsonProperty("routerId")
    private UUID routerId;

    @JsonProperty("routerType")
    private RouterTypeModel routerType;

    @JsonProperty("switch")
    private SwitchModel networkSwitch;

    public RouterModel(UUID routerId, RouterTypeModel routerType, SwitchModel networkSwitch) {
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

    public RouterTypeModel getRouterType() {
        return routerType;
    }

    public void setRouterType(RouterTypeModel routerType) {
        this.routerType = routerType;
    }

    public SwitchModel getNetworkSwitch() {
        return networkSwitch;
    }

    public void setNetworkSwitch(SwitchModel networkSwitch) {
        this.networkSwitch = networkSwitch;
    }
}
