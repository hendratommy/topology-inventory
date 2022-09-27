package dev.hexastack.training.inventory.domain.service;

import dev.hendratommy.training.inventory.domain.entity.Router;
import dev.hendratommy.training.inventory.domain.service.RouterSearch;
import dev.hendratommy.training.inventory.domain.vo.RouterId;
import dev.hendratommy.training.inventory.domain.vo.RouterType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class RouterSearchTest {
    @Test
    void testRetrieveRouter() {
        var routers = new ArrayList<Router>();
        routers.add(new Router(RouterType.CORE, new RouterId()));
        routers.add(new Router(RouterType.EDGE, new RouterId()));
        routers.add(new Router(RouterType.EDGE, new RouterId()));

        var cores = RouterSearch.retrieveRouter(routers, Router.filterRouterByType(RouterType.CORE));
        assert cores != null : "CORE routers should not be null";
        assert cores.size() == 1 : "CORE routers size should equals 1";

        var edges = RouterSearch.retrieveRouter(routers, Router.filterRouterByType(RouterType.EDGE));
        assert edges != null : "EDGE routers should not be null";
        assert edges.size() == 2 : "EDGE routers size should equals 2";
    }
}
