package dev.hexastack.training.inventory.framework.adapter.input;

import dev.hendratommy.training.inventory.domain.vo.IP;
import dev.hendratommy.training.inventory.domain.vo.Network;
import dev.hendratommy.training.inventory.domain.vo.RouterId;
import dev.hendratommy.training.inventory.framework.adapter.input.cli.RouterNetworkCLIAdapter;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class RouterNetworkCLIAdapterTest {
    @Inject
    RouterNetworkCLIAdapter cli;

    @Test
    public void testAddNetwork() {
//        var cli = new RouterNetworkCLIAdapter(new RouterNetworkService(RouterRepositoryFileAdapter.getInstance()));
        var routerId = new RouterId("ca23800e-9b5a-11eb-a8b3-0242ac130003");
        var network = new Network(new IP("20.0.0.0"), "Marketing", 8);
        var router = cli.addNetwork(routerId, network);
        assert router != null : "router should not be null";
        System.out.println(router);
    }

    @Test
    public void testRun() {
//        var cli = new RouterNetworkCLIAdapter(new RouterNetworkService(RouterRepositoryFileAdapter.getInstance()));
        var router = cli.run("-r", "ca23800e-9b5a-11eb-a8b3-0242ac130003", "-i", "20.0.0.0", "-n", "Marketing", "-c", "8");
        assert router != null : "router should not be null";
        System.out.println(router);
    }
}
