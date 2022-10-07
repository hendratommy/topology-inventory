package dev.hendratommy.training.inventory.application.usecase;

import dev.hendratommy.training.inventory.domain.entity.Router;
import dev.hendratommy.training.inventory.domain.vo.Network;
import dev.hendratommy.training.inventory.domain.vo.RouterId;

public interface RouterNetworkUseCase {
    public Router addNetworkToRouter(RouterId routerId, Network network);
}
