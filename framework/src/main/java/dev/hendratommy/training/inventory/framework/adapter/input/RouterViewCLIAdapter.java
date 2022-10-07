package dev.hendratommy.training.inventory.framework.adapter.input;

import dev.hendratommy.training.inventory.application.port.input.RouterViewInputPort;
import dev.hendratommy.training.inventory.application.usecase.RouterViewUseCase;
import dev.hendratommy.training.inventory.domain.entity.Router;
import dev.hendratommy.training.inventory.domain.service.RouterSearch;
import dev.hendratommy.training.inventory.domain.vo.RouterType;
import dev.hendratommy.training.inventory.framework.adapter.output.RouterViewFileAdapter;

import java.util.List;

public class RouterViewCLIAdapter {
    RouterViewUseCase routerViewUseCase;

    public RouterViewCLIAdapter() {
        setAdapters();
    }

    public List<Router> obtainRelatedRouters(String type) {
        return routerViewUseCase.getRouters(
                Router.filterRouterByType(RouterType.valueOf(type)));
    }

    private void setAdapters() {
        this.routerViewUseCase = new RouterViewInputPort(RouterViewFileAdapter.getInstance(), new RouterSearch());
    }
}
