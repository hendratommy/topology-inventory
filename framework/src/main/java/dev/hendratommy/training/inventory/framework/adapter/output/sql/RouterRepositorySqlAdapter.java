package dev.hendratommy.training.inventory.framework.adapter.output.sql;

import dev.hendratommy.training.inventory.application.repository.RouterRepository;
import dev.hendratommy.training.inventory.domain.entity.Router;
import dev.hendratommy.training.inventory.domain.vo.RouterId;
import dev.hendratommy.training.inventory.framework.adapter.output.sql.mapper.RouterDataMapper;
import dev.hendratommy.training.inventory.framework.adapter.output.sql.repository.RouterDataRepository;
import io.quarkus.arc.profile.IfBuildProfile;
import io.quarkus.hibernate.orm.panache.Panache;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@IfBuildProfile("sql")
public class RouterRepositorySqlAdapter implements RouterRepository {
    @Inject
    RouterDataRepository repository;

    @PersistenceContext
    EntityManager em;


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
    @Transactional
    public Router save(Router router) {
        var routerData = RouterDataMapper.toH2(router);
        repository.getEntityManager().merge(routerData);
        return RouterDataMapper.toDomain(routerData);
    }
}
