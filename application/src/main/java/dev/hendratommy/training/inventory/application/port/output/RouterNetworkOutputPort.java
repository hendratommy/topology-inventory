package dev.hendratommy.training.inventory.application.port.output;

import dev.hendratommy.training.inventory.domain.entity.Router;
import dev.hendratommy.training.inventory.domain.vo.RouterId;

public interface RouterNetworkOutputPort {
    Router fetchRouterById(RouterId routerId);
    boolean persistRouter(Router router);
}
