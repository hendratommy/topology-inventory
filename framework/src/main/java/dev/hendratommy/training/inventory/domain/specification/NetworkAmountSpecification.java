package dev.hendratommy.training.inventory.domain.specification;

import dev.hendratommy.training.inventory.domain.entity.Router;
import dev.hendratommy.training.inventory.domain.specification.shared.AbstractSpecification;

public class NetworkAmountSpecification extends AbstractSpecification<Router> {

    final static public int MAXIMUM_ALLOWED_NETWORKS = 6;

    @Override
    public boolean isSatisfiedBy(Router router) {
        return router.retrieveNetworks().size() <= MAXIMUM_ALLOWED_NETWORKS;
    }
}
