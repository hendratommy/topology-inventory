package dev.hendratommy.training.inventory.application.port.input;

import dev.hendratommy.training.inventory.application.port.output.RouterNetworkOutputPort;
import dev.hendratommy.training.inventory.application.usecase.RouterNetworkUseCase;
import dev.hendratommy.training.inventory.domain.entity.Router;
import dev.hendratommy.training.inventory.domain.service.NetworkOperation;
import dev.hendratommy.training.inventory.domain.vo.Network;
import dev.hendratommy.training.inventory.domain.vo.RouterId;

public class RouterNetworkInputPort implements RouterNetworkUseCase {
    private final RouterNetworkOutputPort routerNetworkOutputPort;

    public RouterNetworkInputPort(RouterNetworkOutputPort routerNetworkOutputPort) {
        this.routerNetworkOutputPort = routerNetworkOutputPort;
    }

    @Override
    public Router addNetworkToRouter(RouterId routerId, Network network) {
        var router = fetchRouter(routerId);
        return createNetwork(router, network);
    }

    private Router fetchRouter(RouterId routerId) {
        return routerNetworkOutputPort.fetchRouterById(routerId);
    }

    private Router createNetwork(Router router, Network network) {
        var newRouter = NetworkOperation.createNewNetwork(router, network);
        return persistNetwork(router) ? newRouter :
                router;
    }

    private boolean persistNetwork(Router router) {
        return routerNetworkOutputPort.persistRouter(router);
    }
}
