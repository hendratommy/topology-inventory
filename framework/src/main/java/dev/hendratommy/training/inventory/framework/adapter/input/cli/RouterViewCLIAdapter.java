package dev.hendratommy.training.inventory.framework.adapter.input.cli;

import dev.hendratommy.training.inventory.application.service.RouterViewService;
import dev.hendratommy.training.inventory.application.usecase.RouterViewUseCase;
import dev.hendratommy.training.inventory.domain.entity.Router;
import dev.hendratommy.training.inventory.domain.service.RouterSearch;
import dev.hendratommy.training.inventory.domain.vo.RouterType;
import dev.hendratommy.training.inventory.framework.adapter.output.RouterRepositoryFileAdapter;

import java.util.List;

public class RouterViewCLIAdapter {
    RouterViewUseCase routerViewUseCase;

    public RouterViewCLIAdapter(RouterViewUseCase routerViewUseCase) {
        this.routerViewUseCase = routerViewUseCase;
    }

    public List<Router> obtainRelatedRouters(String type) {
        return routerViewUseCase.getRelatedRouters(RouterType.valueOf(type));
    }
}
