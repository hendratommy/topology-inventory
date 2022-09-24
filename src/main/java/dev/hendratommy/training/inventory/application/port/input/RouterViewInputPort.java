package dev.hendratommy.training.inventory.application.port.input;

import dev.hendratommy.training.inventory.application.port.output.RouterViewOutputPort;
import dev.hendratommy.training.inventory.domain.Router;
import dev.hendratommy.training.inventory.application.usecase.RouterViewUseCase;

import java.util.List;
import java.util.function.Predicate;

public class RouterViewInputPort implements RouterViewUseCase {
    private final RouterViewOutputPort routerViewOutputPort;

    public RouterViewInputPort(RouterViewOutputPort routerViewOutputPort) {
        this.routerViewOutputPort = routerViewOutputPort;
    }

    @Override
    public List<Router> getRouters(Predicate<Router> filter) {
        var routers = routerViewOutputPort.fetchRouters();
        return Router.retrieveRouter(routers, filter);
    }
}
