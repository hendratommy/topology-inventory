package dev.hendratommy.training.inventory.domain.service;

import dev.hendratommy.training.inventory.domain.entity.Router;
import dev.hendratommy.training.inventory.domain.vo.RouterType;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RouterSearch {
    public List<Router> retrieveRouter(RouterType type, List<Router> routers) {
        return routers.stream().filter(router -> router.isType(type)).toList();
    }
}
