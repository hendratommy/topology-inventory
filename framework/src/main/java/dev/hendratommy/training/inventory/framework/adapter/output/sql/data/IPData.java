package dev.hendratommy.training.inventory.framework.adapter.output.sql.data;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class IPData {

    private String address;

    @Enumerated(EnumType.STRING)
    private ProtocolData protocol;

    public IPData(String address){
        if(address == null)
            throw new IllegalArgumentException("Null IP address");
        this.address = address;
        if(address.length()<=15) {
            this.protocol = ProtocolData.IPV4;
        } else {
            this.protocol = ProtocolData.IPV6;
        }
    }

    protected IPData() { }

    public String getAddress() {
        return address;
    }

    public ProtocolData getProtocol() {
        return protocol;
    }
}
