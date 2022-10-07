package dev.hendratommy.training.inventory.application.port.input;

import dev.hendratommy.training.inventory.application.port.output.RouterViewOutputPort;
import dev.hendratommy.training.inventory.domain.entity.Router;
import dev.hendratommy.training.inventory.application.usecase.RouterViewUseCase;
import dev.hendratommy.training.inventory.domain.service.RouterSearch;

import java.util.List;
import java.util.function.Predicate;

public class RouterViewInputPort implements RouterViewUseCase {
    private final RouterViewOutputPort routerViewOutputPort;
    private final RouterSearch routerSearch;

    public RouterViewInputPort(RouterViewOutputPort routerViewOutputPort, RouterSearch routerSearch) {
        this.routerViewOutputPort = routerViewOutputPort;
        this.routerSearch = routerSearch;
    }

    @Override
    public List<Router> getRouters(Predicate<Router> filter) {
        var routers = routerViewOutputPort.fetchRouters();
        return routerSearch.retrieveRouter(routers, filter);
    }
}
