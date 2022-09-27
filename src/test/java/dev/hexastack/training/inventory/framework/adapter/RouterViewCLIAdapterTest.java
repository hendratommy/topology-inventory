package dev.hexastack.training.inventory.framework.adapter;

import dev.hendratommy.training.inventory.framework.adapter.input.RouterViewCLIAdapter;
import org.junit.jupiter.api.Test;

public class RouterViewCLIAdapterTest {
    @Test
    void testObtainRelatedRoutersByType() {
        var cli = new RouterViewCLIAdapter();
        var edges = cli.obtainRelatedRouters("EDGE");
        assert edges != null : "EDGE routers should not be null";
        assert edges.size() == 2 : "EDGE routers size should equals 2";

        var cores = cli.obtainRelatedRouters("CORE");
        assert cores != null : "CORE routers should not be null";
        assert cores.size() == 1 : "CORE routers size should equals 1";
    }
}
