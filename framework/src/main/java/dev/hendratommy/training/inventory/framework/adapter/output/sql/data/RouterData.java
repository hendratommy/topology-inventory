package dev.hendratommy.training.inventory.framework.adapter.output.sql.data;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "routers")
public class RouterData implements Serializable {

    @Id
    @Column(name="router_id")
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID routerId;

//    @Embedded
    @Enumerated(EnumType.STRING)
    @Column(name="router_type")
    private RouterTypeData routerType;


    @OneToOne(cascade = CascadeType.ALL, mappedBy = "routerData")
    private SwitchData networkSwitch;

    public RouterData(UUID routerId, RouterTypeData routerType, SwitchData networkSwitch) {
        this.routerId = routerId;
        this.routerType = routerType;
        this.networkSwitch = networkSwitch;
        this.setNetworkSwitch(networkSwitch);
    }

    public RouterData() {}

    public UUID getRouterId() {
        return routerId;
    }

    public RouterTypeData getRouterType() {
        return routerType;
    }

    public SwitchData getNetworkSwitch() {
        return networkSwitch;
    }

    public void setNetworkSwitch(SwitchData networkSwitch) {
        networkSwitch.setRouterData(this);
        this.networkSwitch = networkSwitch;
    }
}
