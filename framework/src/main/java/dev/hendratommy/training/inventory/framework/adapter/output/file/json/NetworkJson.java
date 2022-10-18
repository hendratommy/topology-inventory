package dev.hendratommy.training.inventory.framework.adapter.output.file.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class NetworkJson {
    @JsonProperty("ip")
    private IPJson ip;
    @JsonProperty("networkName")
    private String networkName;
    @JsonProperty("networkCidr")
    private String cidr;

    public NetworkJson(IPJson ip, String networkName, String cidr) {
        this.ip = ip;
        this.networkName = networkName;
        this.cidr = cidr;
    }

    public IPJson getIp() {
        return ip;
    }

    public void setIp(IPJson ip) {
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
