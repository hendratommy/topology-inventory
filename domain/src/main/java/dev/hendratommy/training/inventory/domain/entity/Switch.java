package dev.hendratommy.training.inventory.domain.entity;

import dev.hendratommy.training.inventory.domain.vo.IP;
import dev.hendratommy.training.inventory.domain.vo.Network;
import dev.hendratommy.training.inventory.domain.vo.SwitchId;
import dev.hendratommy.training.inventory.domain.vo.SwitchType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Switch {
    private final SwitchId switchId;
    private final SwitchType switchType;
    private final List<Network> networks;
    private final IP address;

    public Switch(SwitchId switchId, SwitchType switchType, List<Network> networks, IP address) {
        this.switchId = switchId;
        this.switchType = switchType;
        this.networks = networks;
        this.address = address;
    }

    public Switch addNetwork(Network network) {
        var networks = new ArrayList<>(Arrays.asList(network));
        networks.add(network);
        return new Switch(this.switchId, this.switchType, networks, this.address);
    }

    public List<Network> getNetworks() {
        return networks;
    }

    public SwitchId getSwitchId() {
        return switchId;
    }

    public SwitchType getSwitchType() {
        return switchType;
    }

    public IP getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Switch{" +
                "switchType=" + switchType +
                ", switchId=" + switchId +
                ", networks=" + networks +
                ", address=" + address +
                '}';
    }
}
