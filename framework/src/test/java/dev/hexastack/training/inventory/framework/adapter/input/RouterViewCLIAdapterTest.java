package dev.hexastack.training.inventory.framework.adapter.input;

import dev.hendratommy.training.inventory.application.service.RouterViewService;
import dev.hendratommy.training.inventory.domain.service.RouterSearch;
import dev.hendratommy.training.inventory.framework.adapter.input.cli.RouterViewCLIAdapter;
import dev.hendratommy.training.inventory.framework.adapter.output.RouterRepositoryFileAdapter;
import org.junit.jupiter.api.Test;

public class RouterViewCLIAdapterTest {
    @Test
    void testObtainRelatedRoutersByType() {
        var routerViewUseCase = new RouterViewService(RouterRepositoryFileAdapter.getInstance(), new RouterSearch());
        var cli = new RouterViewCLIAdapter(routerViewUseCase);
        var cores = cli.obtainRelatedRouters("CORE");
        assert cores != null : "CORE routers should not be null";
        assert cores.size() == 1 : "CORE routers size should equals 1";

        var edges = cli.obtainRelatedRouters("EDGE");
        assert edges != null : "EDGE routers should not be null";
        assert edges.size() == 2 : "EDGE routers size should equals 2";
    }
}
