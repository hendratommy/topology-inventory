package dev.hendratommy.training.inventory.application.service;

import dev.hendratommy.training.inventory.application.repository.RouterRepository;
import dev.hendratommy.training.inventory.application.usecase.RouterNetworkUseCase;
import dev.hendratommy.training.inventory.domain.entity.Router;
import dev.hendratommy.training.inventory.domain.service.NetworkOperation;
import dev.hendratommy.training.inventory.domain.vo.Network;
import dev.hendratommy.training.inventory.domain.vo.RouterId;

public class RouterNetworkService implements RouterNetworkUseCase {
    private final RouterRepository routerRepository;

    public RouterNetworkService(RouterRepository routerRepository) {
        this.routerRepository = routerRepository;
    }

    @Override
    public Router addNetworkToRouter(RouterId routerId, Network network) {
        var router = findById(routerId);
        return createNetwork(router, network);
    }

    private Router findById(RouterId routerId) {
        return routerRepository.findById(routerId);
    }

    private Router createNetwork(Router router, Network network) {
        var newRouter = NetworkOperation.createNewNetwork(router, network);
        return persistNetwork(newRouter);
    }

    private Router persistNetwork(Router router) {
        return routerRepository.save(router);
    }
}
