package dev.hendratommy.training.inventory.application.repository;

import dev.hendratommy.training.inventory.domain.entity.Router;
import dev.hendratommy.training.inventory.domain.vo.RouterId;

import java.util.List;

public interface RouterRepository {
    List<Router> findAll();
    Router findById(RouterId routerId);
    Router save(Router router);
}
