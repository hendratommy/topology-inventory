package dev.hendratommy.training.inventory.framework.adapter.input.cli;

import dev.hendratommy.training.inventory.application.usecase.RouterViewUseCase;
import dev.hendratommy.training.inventory.domain.entity.Router;
import dev.hendratommy.training.inventory.domain.vo.RouterType;
import io.quarkus.logging.Log;

import java.util.List;

public class RouterViewCLIAdapter {
    RouterViewUseCase routerViewUseCase;

    public RouterViewCLIAdapter(RouterViewUseCase routerViewUseCase) {
        this.routerViewUseCase = routerViewUseCase;
    }

    public List<Router> obtainRelatedRouters(String type) {
        return routerViewUseCase.getRelatedRouters(RouterType.valueOf(type));
    }


    public void run(String... args) {
        if (args[0].equals("-t") && args.length == 2) {
            try {
                var type = RouterType.valueOf(args[1]);
            } catch (IllegalArgumentException e) {
                Log.error("Unrecognized router type: " + args[1] + ": should be CORE or EDGE");
            }
        } else {
            Log.info("Usage: -t [CORE|EDGE]");
        }
    }
}
