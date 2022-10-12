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
        routers.add(new Router(new RouterId(), RouterType.CORE));
        routers.add(new Router(new RouterId(), RouterType.EDGE));
        routers.add(new Router(new RouterId(), RouterType.EDGE));

        var routerSearch = new RouterSearch();

        var cores = routerSearch.retrieveRouter(RouterType.CORE, routers);
        assert cores != null : "CORE routers should not be null";
        assert cores.size() == 1 : "CORE routers size should equals 1";

        var edges = routerSearch.retrieveRouter(RouterType.EDGE, routers);
        assert edges != null : "EDGE routers should not be null";
        assert edges.size() == 2 : "EDGE routers size should equals 2";
    }
}
