package dev.hendratommy.training.inventory.framework.adapter.output.sql.repository;

import dev.hendratommy.training.inventory.framework.adapter.output.sql.data.RouterData;
import io.quarkus.arc.profile.IfBuildProfile;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
@IfBuildProfile("sql")
public class RouterDataRepository implements PanacheRepositoryBase<RouterData, UUID> {
}
