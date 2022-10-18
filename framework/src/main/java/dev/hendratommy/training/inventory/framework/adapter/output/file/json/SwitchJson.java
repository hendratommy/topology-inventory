package dev.hendratommy.training.inventory.framework.adapter.output.file.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.UUID;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class SwitchJson {
    @JsonProperty("switchId")
    private UUID switchId;

    @JsonProperty("ip")
    private IPJson ip;

    @JsonProperty("switchType")
    private SwitchTypeJson switchType;

    @JsonProperty("networks")
    private List<NetworkJson> networks;

    public SwitchJson(UUID switchId, IPJson ip, SwitchTypeJson switchType, List<NetworkJson> networks) {
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

    public IPJson getIp() {
        return ip;
    }

    public void setIp(IPJson ip) {
        this.ip = ip;
    }

    public SwitchTypeJson getSwitchType() {
        return switchType;
    }

    public void setSwitchType(SwitchTypeJson switchType) {
        this.switchType = switchType;
    }

    public List<NetworkJson> getNetworks() {
        return networks;
    }

    public void setNetworks(List<NetworkJson> networks) {
        this.networks = networks;
    }
}
