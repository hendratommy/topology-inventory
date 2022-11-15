package dev.hendratommy.training.inventory.framework.adapter.output.sql.data;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "networks")
public class NetworkData implements Serializable {
    private static final long serialVersionUID = 1645955024022350226L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="network_id")
    private Long id;

    @Column(name="switch_id")
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID switchId;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "address",
                    column = @Column(
                            name = "network_address")),
            @AttributeOverride(
                    name = "protocol",
                    column = @Column(
                            name = "network_protocol")),
    })
    private IPData ip;

    @Column(name="network_name")
    private String name;

    @Column(name="network_cidr")
    private Integer cidr;

    public NetworkData(UUID switchId, IPData ip, String name, Integer cidr) {
        this.switchId = switchId;
        this.ip = ip;
        this.name = name;
        this.cidr = cidr;
    }

    protected NetworkData() {}

    public Long getId() {
        return id;
    }

    public UUID getSwitchId() {
        return switchId;
    }

    public IPData getIp() {
        return ip;
    }

    public String getName() {
        return name;
    }

    public Integer getCidr() {
        return cidr;
    }
}
