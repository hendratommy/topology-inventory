package dev.hexastack.training.inventory.framework.adapter.input;

import dev.hendratommy.training.inventory.domain.vo.IP;
import dev.hendratommy.training.inventory.domain.vo.Network;
import dev.hendratommy.training.inventory.domain.vo.RouterId;
import dev.hendratommy.training.inventory.framework.adapter.input.cli.RouterNetworkCLIAdapter;
import org.junit.jupiter.api.Test;

public class RouterNetworkCLIAdapterTest {
    @Test
    public void testAddNetwork() {
        var cli = new RouterNetworkCLIAdapter();
        var routerId = new RouterId("ca23800e-9b5a-11eb-a8b3-0242ac130003");
        var network = new Network(new IP("20.0.0.0"), "Marketing", 8);
        var router = cli.addNetwork(routerId, network);
        System.out.println(router);
    }

//    @Test
//    public void testAddNetwork() {
//        var cli = new RouterNetworkCLIAdapter();
//        var routerId = new RouterId("ca23800e-9b5a-11eb-a8b3-0242ac130003");
//        var network = new Network(new IP("20.0.0.0"), "Marketing", 8);
//        var router = cli.addNetwork(routerId, network);
//        System.out.println(router);
//    }
}
