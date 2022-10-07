package dev.hendratommy.training.inventory.domain.specification;


import dev.hendratommy.training.inventory.domain.entity.Router;
import dev.hendratommy.training.inventory.domain.specification.shared.AbstractSpecification;
import dev.hendratommy.training.inventory.domain.vo.RouterType;

public class RouterTypeSpecification extends AbstractSpecification<Router> {

    @Override
    public boolean isSatisfiedBy(Router router) {
        return router.getType().equals(RouterType.EDGE) || router.getType().equals(RouterType.CORE);
    }
}