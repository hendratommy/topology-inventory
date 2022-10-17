package dev.hexastack.training.inventory.framework.adapter.input;

import dev.hendratommy.training.inventory.framework.adapter.input.cli.RouterViewCliAdapter;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class RouterViewCliAdapterTest {
    @Inject
    RouterViewCliAdapter cli;
    @Test
    void testObtainRelatedRoutersByType() {
        var cores = cli.obtainRelatedRouters("CORE");
        assert cores != null : "CORE routers should not be null";
        assert cores.size() == 1 : "CORE routers size should equals 1";

        var edges = cli.obtainRelatedRouters("EDGE");
        assert edges != null : "EDGE routers should not be null";
        assert edges.size() == 2 : "EDGE routers size should equals 2";
    }

    @Test
    void testRun() {
        var cores = cli.run("-t", "CORE");
        assert cores != null : "CORE routers should not be null";
        assert cores.size() == 1 : "CORE routers size should equals 1";

        var edges = cli.run("-t", "EDGE");
        assert edges != null : "EDGE routers should not be null";
        assert edges.size() == 2 : "EDGE routers size should equals 2";
    }
}
