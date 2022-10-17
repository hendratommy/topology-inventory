package dev.hendratommy.training.inventory.framework.adapter.output.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.UUID;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class SwitchModel {
    @JsonProperty("switchId")
    private UUID switchId;

    @JsonProperty("ip")
    private IPModel ip;

    @JsonProperty("switchType")
    private SwitchTypeModel switchType;

    @JsonProperty("networks")
    private List<NetworkModel> networks;

    public SwitchModel(UUID switchId, IPModel ip, SwitchTypeModel switchType, List<NetworkModel> networks) {
        this.switchId = switchId;
        this.ip = ip;
        this.switchType = switchType;
        this.networks = networks;
    }

    public UUID getSwitchId() {
        return switchId;
    }

    public void setSwitchId(UUID switchId) {
        this.switchId = switchId;
    }

    public IPModel getIp() {
        return ip;
    }

    public void setIp(IPModel ip) {
        this.ip = ip;
    }

    public SwitchTypeModel getSwitchType() {
        return switchType;
    }

    public void setSwitchType(SwitchTypeModel switchType) {
        this.switchType = switchType;
    }

    public List<NetworkModel> getNetworks() {
        return networks;
    }

    public void setNetworks(List<NetworkModel> networks) {
        this.networks = networks;
    }
}
