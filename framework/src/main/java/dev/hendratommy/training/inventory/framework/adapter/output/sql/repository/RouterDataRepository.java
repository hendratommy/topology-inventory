package dev.hendratommy.training.inventory.framework.adapter.output.sql.repository;

import dev.hendratommy.training.inventory.framework.adapter.output.sql.data.RouterData;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import java.util.UUID;

public class RouterDataRepository implements PanacheRepositoryBase<RouterData, UUID> {
}
