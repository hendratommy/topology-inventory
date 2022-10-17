package dev.hendratommy.training.inventory.domain.vo;

public class IP {

    private final String address;
    private final Protocol protocol;

    public IP(String address) {
        if (address == null) {
            throw new IllegalArgumentException("Null IP address");
        }
        this.address = address;
        if (address.length() <= 15) {
            this.protocol = Protocol.IPV4;
        } else {
            this.protocol = Protocol.IPV6;
        }
    }

    public String getIPAddress() {
        return address;
    }

    public Protocol getProtocol() {
        return protocol;
    }

    @Override
    public String toString() {
        return new StringBuilder("IP{")
                .append("address='").append(address).append("'")
                .append(", protocol=").append(protocol)
                .append("}").toString();
    }
}
