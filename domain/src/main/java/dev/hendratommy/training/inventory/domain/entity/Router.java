package dev.hendratommy.training.inventory.domain.entity;

import dev.hendratommy.training.inventory.domain.vo.IP;
import dev.hendratommy.training.inventory.domain.vo.Network;
import dev.hendratommy.training.inventory.domain.vo.RouterId;
import dev.hendratommy.training.inventory.domain.vo.RouterType;

import java.util.List;

public class Router {
    private final RouterId routerId;
    private final RouterType type;
    private Switch networkSwitch;

    public Router(RouterId routerId, RouterType type) {
        this.routerId = routerId;
        this.type = type;
    }

    public Router(RouterId routerId, RouterType type, Switch networkSwitch) {
        this.routerId = routerId;
        this.type = type;
        this.networkSwitch = networkSwitch;
    }

    public RouterType getType() {
        return type;
    }

    public void addNetworkToSwitch(Network network) {
        this.networkSwitch = networkSwitch.addNetwork(network);
    }

    public Network createNetwork(IP address, String name, int cidr) {
        return new Network(address, name, cidr);
    }

    public List<Network> retrieveNetworks() {
        return networkSwitch.getNetworks();
    }

    public RouterId getId() {
        return routerId;
    }

    public boolean isType(RouterType type) {
        return this.type == type;
    }

    public Switch getNetworkSwitch() {
        return networkSwitch;
    }

    @Override
    public String toString() {
        return new StringBuilder("Router{")
                .append("routerType=").append(type)
                .append(", routerId=").append(routerId)
                .append(", networkSwitch=").append(networkSwitch)
                .append("}").toString();
    }
}
