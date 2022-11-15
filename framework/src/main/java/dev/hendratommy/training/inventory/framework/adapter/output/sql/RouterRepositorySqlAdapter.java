package dev.hendratommy.training.inventory.framework.adapter.output.sql;

import dev.hendratommy.training.inventory.application.repository.RouterRepository;
import dev.hendratommy.training.inventory.domain.entity.Router;
import dev.hendratommy.training.inventory.domain.vo.RouterId;
import dev.hendratommy.training.inventory.framework.adapter.output.sql.mapper.RouterDataMapper;
import dev.hendratommy.training.inventory.framework.adapter.output.sql.repository.RouterDataRepository;

import java.util.List;
import java.util.stream.Collectors;

public class RouterRepositorySqlAdapter implements RouterRepository {
    private RouterDataRepository repository;

    public RouterRepositorySqlAdapter(RouterDataRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Router> findAll() {
        return repository.findAll().stream().map(routerData -> RouterDataMapper.toDomain(routerData)).collect(Collectors.toList());
    }

    @Override
    public Router findById(RouterId routerId) {
        var routerData = repository.findById(routerId.getUUID());
        return RouterDataMapper.toDomain(routerData);
    }

    @Override
    public Router save(Router router) {
        var routerData = RouterDataMapper.toH2(router);
        repository.persist(routerData);
        return RouterDataMapper.toDomain(routerData);
    }
}
