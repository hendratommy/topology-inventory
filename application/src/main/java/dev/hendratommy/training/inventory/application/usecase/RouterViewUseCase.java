package dev.hendratommy.training.inventory.application.usecase;

import dev.hendratommy.training.inventory.domain.entity.Router;
import dev.hendratommy.training.inventory.domain.vo.RouterType;

import java.util.List;
import java.util.function.Predicate;

public interface RouterViewUseCase {
    List<Router> getRelatedRouters(RouterType type);
}
