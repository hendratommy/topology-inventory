package dev.hendratommy.training.inventory.domain.entity;

import dev.hendratommy.training.inventory.domain.vo.IP;
import dev.hendratommy.training.inventory.domain.vo.Network;
import dev.hendratommy.training.inventory.domain.vo.RouterId;
import dev.hendratommy.training.inventory.domain.vo.RouterType;

import java.util.List;
import java.util.function.Predicate;

public class Router {
    private final RouterId routerId;
    private final RouterType routerType;
    private Switch networkSwitch;

    public Router(RouterId routerId, RouterType routerType) {
        this.routerId = routerId;
        this.routerType = routerType;
    }

    public Router(RouterId routerId, RouterType routerType, Switch networkSwitch) {
        this.routerId = routerId;
        this.routerType = routerType;
        this.networkSwitch = networkSwitch;
    }

    public static Predicate<Router> filterRouterByType(RouterType routerType) {
        return routerType.equals(RouterType.CORE)
                ? isCore() :
                isEdge();
    }

    private static Predicate<Router> isCore() {
        return p -> p.getRouterType() == RouterType.CORE;
    }

    private static Predicate<Router> isEdge() {
        return p -> p.getRouterType() == RouterType.EDGE;
    }

    public RouterType getRouterType() {
        return routerType;
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

    public RouterId getRouterId() {
        return routerId;
    }

    @Override
    public String toString() {
        return new StringBuilder("Router{")
                .append("routerType=").append(routerType)
                .append(", routerId=").append(routerId)
                .append(", networkSwitch=").append(networkSwitch)
                .append("}").toString();
    }
}
