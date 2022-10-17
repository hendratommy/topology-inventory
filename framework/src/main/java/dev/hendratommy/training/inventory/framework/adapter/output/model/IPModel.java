package dev.hendratommy.training.inventory.framework.adapter.output.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class IPModel {
    @JsonProperty("address")
    private String address;

    @JsonProperty("protocol")
    private ProtocolModel protocol;

    public IPModel(String address){
        if(address == null)
            throw new IllegalArgumentException("Null IP address");
        this.address = address;
        if(address.length()<=15) {
            this.protocol = ProtocolModel.IPV4;
        } else {
            this.protocol = ProtocolModel.IPV6;
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ProtocolModel getProtocol() {
        return protocol;
    }

    public void setProtocol(ProtocolModel protocol) {
        this.protocol = protocol;
    }
}
