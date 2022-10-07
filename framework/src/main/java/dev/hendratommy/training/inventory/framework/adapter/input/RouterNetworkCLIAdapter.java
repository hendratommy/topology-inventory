package dev.hendratommy.training.inventory.framework.adapter.input;

import dev.hendratommy.training.inventory.application.service.RouterNetworkService;
import dev.hendratommy.training.inventory.application.usecase.RouterNetworkUseCase;
import dev.hendratommy.training.inventory.domain.entity.Router;
import dev.hendratommy.training.inventory.domain.vo.Network;
import dev.hendratommy.training.inventory.domain.vo.RouterId;
import dev.hendratommy.training.inventory.framework.adapter.output.RouterRepositoryFileAdapter;

public class RouterNetworkCLIAdapter {
    RouterNetworkUseCase routerNetworkUseCase;

    public RouterNetworkCLIAdapter() {
        setAdapters();
    }

    public Router addNetwork(RouterId routerId, Network network) {
        return routerNetworkUseCase.addNetworkToRouter(routerId, network);
    }

    private void setAdapters() {
        this.routerNetworkUseCase = new RouterNetworkService(RouterRepositoryFileAdapter.getInstance());
    }
}
