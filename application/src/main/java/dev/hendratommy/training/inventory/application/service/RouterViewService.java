package dev.hendratommy.training.inventory.application.service;

import dev.hendratommy.training.inventory.application.repository.RouterRepository;
import dev.hendratommy.training.inventory.domain.entity.Router;
import dev.hendratommy.training.inventory.application.usecase.RouterViewUseCase;
import dev.hendratommy.training.inventory.domain.service.RouterSearch;

import java.util.List;
import java.util.function.Predicate;

public class RouterViewService implements RouterViewUseCase {
    private final RouterRepository routerRepository;
    private final RouterSearch routerSearch;

    public RouterViewService(RouterRepository routerRepository, RouterSearch routerSearch) {
        this.routerRepository = routerRepository;
        this.routerSearch = routerSearch;
    }

    @Override
    public List<Router> getRouters(Predicate<Router> filter) {
        var routers = routerRepository.findAll();
        return routerSearch.retrieveRouter(routers, filter);
    }
}
