package dev.hexastack.training.inventory.framework.adapter.input;

import dev.hendratommy.training.inventory.application.repository.RouterRepository;
import dev.hendratommy.training.inventory.application.service.RouterNetworkService;
import dev.hendratommy.training.inventory.application.service.RouterViewService;
import dev.hendratommy.training.inventory.application.usecase.RouterNetworkUseCase;
import dev.hendratommy.training.inventory.application.usecase.RouterViewUseCase;
import dev.hendratommy.training.inventory.domain.service.RouterSearch;
import dev.hendratommy.training.inventory.framework.adapter.input.cli.RouterNetworkCLIAdapter;
import dev.hendratommy.training.inventory.framework.adapter.input.cli.RouterViewCLIAdapter;
import dev.hendratommy.training.inventory.framework.adapter.output.file.RouterRepositoryFileAdapter;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class BeanProducer {
    @Produces
    RouterRepository routerRepository() {
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
    RouterNetworkCLIAdapter routerNetworkCLIAdapter(RouterNetworkUseCase useCase) {
        return new RouterNetworkCLIAdapter(useCase);
    }

    @Produces
    RouterViewCLIAdapter routerViewCLIAdapter(RouterViewUseCase useCase) {
        return new RouterViewCLIAdapter(useCase);
    }

}
