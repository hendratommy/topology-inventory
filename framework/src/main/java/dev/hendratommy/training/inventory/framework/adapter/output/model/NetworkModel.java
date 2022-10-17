package dev.hendratommy.training.inventory.framework.adapter.output.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class NetworkModel {
    @JsonProperty("ip")
    private IPModel ip;
    @JsonProperty("networkName")
    private String networkName;
    @JsonProperty("networkCidr")
    private String cidr;

    public NetworkModel(IPModel ip, String networkName, String cidr) {
        this.ip = ip;
        this.networkName = networkName;
        this.cidr = cidr;
    }

    public IPModel getIp() {
        return ip;
    }

    public void setIp(IPModel ip) {
        this.ip = ip;
    }

    public String getNetworkName() {
        return networkName;
    }

    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }

    public String getCidr() {
        return cidr;
    }

    public void setCidr(String cidr) {
        this.cidr = cidr;
    }
}
