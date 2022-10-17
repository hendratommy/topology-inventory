package dev.hendratommy.training.inventory.framework.adapter.input.cli;

import dev.hendratommy.training.inventory.application.usecase.RouterViewUseCase;
import dev.hendratommy.training.inventory.domain.entity.Router;
import dev.hendratommy.training.inventory.domain.vo.RouterType;
import io.quarkus.logging.Log;

import java.util.List;

public class RouterViewCLIAdapter {
    private final RouterViewUseCase routerViewUseCase;

    public RouterViewCLIAdapter(RouterViewUseCase routerViewUseCase) {
        this.routerViewUseCase = routerViewUseCase;
    }

    public List<Router> obtainRelatedRouters(String type) {
        return routerViewUseCase.getRelatedRouters(RouterType.valueOf(type));
    }

    public List<Router> run(String... args) {
        if (args[0].equals("-t") && args.length == 2) {
            try {
                var routers = obtainRelatedRouters(args[1]);
                routers.stream().forEach(router -> {
                    Log.info(router);
                });
                return routers;
            } catch (IllegalArgumentException e) {
                Log.error("Unrecognized router type: " + args[1] + ": should be CORE or EDGE");
                throw e;
            }
        } else {
            Log.warn("Usage: -t [CORE|EDGE]");
            throw new IllegalArgumentException("Usage: -t [CORE|EDGE]");
        }
    }
}
