package dev.hexastack.training.inventory.framework.adapter.input.cli;

import dev.hendratommy.training.inventory.domain.vo.IP;
import dev.hendratommy.training.inventory.domain.vo.Network;
import dev.hendratommy.training.inventory.domain.vo.RouterId;
import dev.hendratommy.training.inventory.framework.adapter.input.cli.RouterNetworkCliAdapter;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class RouterNetworkCliAdapterTest {
    @Inject
    RouterNetworkCliAdapter cli;

    @Test
    public void testAddNetwork() {
        var routerId = new RouterId("ca23800e-9b5a-11eb-a8b3-0242ac130003");
        var network = new Network(new IP("20.0.0.0"), "Marketing", 10);
        var router = cli.addNetwork(routerId, network);
        assert router != null : "router should not be null";
        System.out.println(router);
    }

    @Test
    public void testRun() {
        var router = cli.run("-r", "ca23800e-9b5a-11eb-a8b3-0242ac130003", "-i", "20.0.0.0", "-n", "Marketing", "-c", "10");
        assert router != null : "router should not be null";
        System.out.println(router);
    }
}
