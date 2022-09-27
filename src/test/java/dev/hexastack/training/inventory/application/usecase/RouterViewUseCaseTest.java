package dev.hexastack.training.inventory.application.usecase;

import dev.hendratommy.training.inventory.application.port.input.RouterViewInputPort;
import dev.hendratommy.training.inventory.domain.Router;
import dev.hendratommy.training.inventory.domain.RouterType;
import dev.hendratommy.training.inventory.framework.adapter.output.RouterViewFileAdapter;
import org.junit.jupiter.api.Test;

public class RouterViewUseCaseTest {
    @Test
    void testGetRouters() {
        var routerViewUseCase =  new RouterViewInputPort(RouterViewFileAdapter.getInstance());
        var edges = routerViewUseCase.getRouters(Router.filterRouterByType(RouterType.EDGE));
        assert edges != null : "EDGE routers should not be null";
        assert edges.size() == 2 : "EDGE routers size should equals 2";

        var cores = routerViewUseCase.getRouters(Router.filterRouterByType(RouterType.CORE));
        assert cores != null : "CORE routers should not be null";
        assert cores.size() == 1 : "CORE routers size should equals 1";
    }
}
