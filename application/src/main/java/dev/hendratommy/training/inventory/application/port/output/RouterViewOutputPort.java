package dev.hendratommy.training.inventory.application.port.output;

import dev.hendratommy.training.inventory.domain.entity.Router;

import java.util.List;

public interface RouterViewOutputPort {
    List<Router> fetchRouters();
}
