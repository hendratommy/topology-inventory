package dev.hendratommy.training.inventory.framework.adapter.input.rest;

import dev.hendratommy.training.inventory.application.usecase.RouterNetworkUseCase;
import dev.hendratommy.training.inventory.domain.entity.Router;
import dev.hendratommy.training.inventory.domain.vo.IP;
import dev.hendratommy.training.inventory.domain.vo.Network;
import dev.hendratommy.training.inventory.domain.vo.RouterId;
import dev.hendratommy.training.inventory.framework.adapter.input.model.AddNetworkModel;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/networks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RouterNetworkRestAdapter {
    private final RouterNetworkUseCase routerNetworkUseCase;

    public RouterNetworkRestAdapter(RouterNetworkUseCase routerNetworkUseCase) {
        this.routerNetworkUseCase = routerNetworkUseCase;
    }

    public Router addNetwork(RouterId routerId, Network network) {
        return routerNetworkUseCase.addNetworkToRouter(routerId, network);
    }

    @POST
    public Router addNetwork(@Valid AddNetworkModel params) {
        var routerId = new RouterId(params.getRouterId());
        var network = new Network(new IP(params.getAddress()), params.getName(), params.getCidr());
        return addNetwork(routerId, network);
    }
}
