package dev.hendratommy.training.inventory.framework.adapter.output.sql.data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "routers")
@SecondaryTable(name = "switches")
@MappedSuperclass
public class RouterData implements Serializable {

    @Id
    @Column(name="router_id",
            columnDefinition = "uuid",
            updatable = false )
    @Convert(converter = UUIDTypeConverter.class)
    private UUID routerId;

    @Embedded
    @Enumerated(EnumType.STRING)
    @Column(name="router_type")
    private RouterTypeData routerType;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(table = "switches",
            name = "router_id",
            referencedColumnName = "router_id")
    private SwitchData networkSwitch;

    public RouterData(UUID routerId, RouterTypeData routerType, SwitchData networkSwitch) {
        this.routerId = routerId;
        this.routerType = routerType;
        this.networkSwitch = networkSwitch;
    }

    protected RouterData() {}

    public UUID getRouterId() {
        return routerId;
    }

    public RouterTypeData getRouterType() {
        return routerType;
    }

    public SwitchData getNetworkSwitch() {
        return networkSwitch;
    }
}
