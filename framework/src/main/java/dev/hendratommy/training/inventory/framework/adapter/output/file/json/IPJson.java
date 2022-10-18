package dev.hendratommy.training.inventory.framework.adapter.output.file.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class IPJson {
    @JsonProperty("address")
    private String address;

    @JsonProperty("protocol")
    private ProtocolJson protocol;

    public IPJson(String address){
        if(address == null)
            throw new IllegalArgumentException("Null IP address");
        this.address = address;
        if(address.length()<=15) {
            this.protocol = ProtocolJson.IPV4;
        } else {
            this.protocol = ProtocolJson.IPV6;
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ProtocolJson getProtocol() {
        return protocol;
    }

    public void setProtocol(ProtocolJson protocol) {
        this.protocol = protocol;
    }
}
