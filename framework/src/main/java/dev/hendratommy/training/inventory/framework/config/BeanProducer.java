package dev.hendratommy.training.inventory.framework.config;

import dev.hendratommy.training.inventory.application.repository.RouterRepository;
import dev.hendratommy.training.inventory.application.service.RouterNetworkService;
import dev.hendratommy.training.inventory.application.service.RouterViewService;
import dev.hendratommy.training.inventory.application.usecase.RouterNetworkUseCase;
import dev.hendratommy.training.inventory.application.usecase.RouterViewUseCase;
import dev.hendratommy.training.inventory.domain.service.RouterSearch;
import dev.hendratommy.training.inventory.framework.adapter.input.cli.RouterNetworkCliAdapter;
import dev.hendratommy.training.inventory.framework.adapter.input.cli.RouterViewCliAdapter;
import dev.hendratommy.training.inventory.framework.adapter.output.file.RouterRepositoryFileAdapter;
import dev.hendratommy.training.inventory.framework.adapter.output.sql.RouterRepositorySqlAdapter;
import dev.hendratommy.training.inventory.framework.adapter.output.sql.repository.RouterDataRepository;
import io.quarkus.arc.DefaultBean;
import io.quarkus.arc.profile.IfBuildProfile;
import io.quarkus.logging.Log;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Dependent
public class BeanProducer {
    @Produces
    @DefaultBean
    RouterRepository routerFileRepository() {
        return RouterRepositoryFileAdapter.getInstance();
    }



    @Produces
    RouterNetworkUseCase routerNetworkUseCase(RouterRepository routerRepository) {
        return new RouterNetworkService(routerRepository);
    }

    @Produces
    RouterSearch routerSearch() {
        return new RouterSearch();
    }

    @Produces
    RouterViewUseCase routerViewUseCase(RouterRepository routerRepository, RouterSearch routerSearch) {
        return new RouterViewService(routerRepository, routerSearch);
    }

    @Produces
    RouterNetworkCliAdapter routerNetworkCLIAdapter(RouterNetworkUseCase useCase) {
        return new RouterNetworkCliAdapter(useCase);
    }

    @Produces
    RouterViewCliAdapter routerViewCLIAdapter(RouterViewUseCase useCase) {
        return new RouterViewCliAdapter(useCase);
    }
}
