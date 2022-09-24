package dev.hendratommy.training.inventory.application.usecase;

import dev.hendratommy.training.inventory.domain.Router;

import java.util.List;
import java.util.function.Predicate;

public interface RouterViewUseCase {
    List<Router> getRouters(Predicate<Router> filter);
}
