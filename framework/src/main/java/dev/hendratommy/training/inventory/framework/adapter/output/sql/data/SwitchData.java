package dev.hendratommy.training.inventory.framework.adapter.output.sql.data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "switches")
public class SwitchData implements Serializable {
    private static final long serialVersionUID = -3481707626785416063L;

    @Id
    @Column(name="switch_id",
            columnDefinition = "uuid",
            updatable = false )
    @Convert(converter = UUIDTypeConverter.class)
    private UUID switchId;

    @Column(name="router_id")
    @Convert(converter = UUIDTypeConverter.class)
    private UUID routerId;

    @Enumerated(EnumType.STRING)
    @Column(name = "switch_type")
    private SwitchTypeData switchType;

    @OneToMany
    @JoinColumn(
            name = "switch_id",
            referencedColumnName = "switch_id")
    private List<NetworkData> networks;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "address",
                    column = @Column(
                            name = "switch_ip_address")),
            @AttributeOverride(
                    name = "protocol",
                    column = @Column(
                            name = "switch_ip_protocol")),
    })
    private IPData ip;

    public SwitchData(UUID switchId, UUID routerId, SwitchTypeData switchType, List<NetworkData> networks, IPData ip) {
        this.switchId = switchId;
        this.routerId = routerId;
        this.switchType = switchType;
        this.networks = networks;
        this.ip = ip;
    }

    protected SwitchData() {}

    public UUID getSwitchId() {
        return switchId;
    }

    public UUID getRouterId() {
        return routerId;
    }

    public SwitchTypeData getSwitchType() {
        return switchType;
    }

    public List<NetworkData> getNetworks() {
        return networks;
    }

    public IPData getIp() {
        return ip;
    }
}
