package dev.hendratommy.training.inventory.framework.adapter.output.mapper;

import dev.hendratommy.training.inventory.domain.entity.Router;
import dev.hendratommy.training.inventory.domain.entity.Switch;
import dev.hendratommy.training.inventory.domain.vo.*;
import dev.hendratommy.training.inventory.framework.adapter.output.model.*;

import java.util.ArrayList;
import java.util.List;

public class RouterModelMapper {
    public static Router toDomain(RouterModel routerModel) {
        var routerId = new RouterId(routerModel.getRouterId().toString());
        var routerType = RouterType.valueOf(routerModel.getRouterType().name());
        var switchId = new SwitchId(routerModel.getNetworkSwitch().getSwitchId().toString());
        var switchType = SwitchType.valueOf(routerModel.getNetworkSwitch().getSwitchType().toString());
        var ip = new IP(routerModel.getNetworkSwitch().getIp().getAddress());
        var networks = getNetworksFromJson(routerModel.getNetworkSwitch().getNetworks());

        var networkSwitch = new Switch(switchId, switchType, networks, ip);

        return new Router(routerId, routerType, networkSwitch);
    }

    public static RouterModel toJson(Router router) {
        var routerId = router.getId().getUUID();
        var routerTypeModel = RouterTypeModel.valueOf(router.getType().toString());
        var switchId = router.getNetworkSwitch().getSwitchId().getUUID();
        var switchTypeModel = SwitchTypeModel.valueOf(router.getNetworkSwitch().getSwitchType().toString());
        var ipModel = new IPModel(router.getNetworkSwitch().getAddress().getIPAddress());
        var networkDataList = getNetworksFromDomain(router.retrieveNetworks());

        var switchModel = new SwitchModel(switchId, ipModel, switchTypeModel, networkDataList);

        return new RouterModel(routerId, routerTypeModel, switchModel);
    }

    private static List<Network> getNetworksFromJson(List<NetworkModel> networkModels) {
        List<Network> networks = new ArrayList<>();
        networkModels.forEach(networkModel -> {
            var network = new Network(
                    new IP(networkModel.getIp().getAddress()),
                    networkModel.getNetworkName(),
                    Integer.valueOf(networkModel.getCidr()));
            networks.add(network);
        });
        return networks;
    }

    private static List<NetworkModel> getNetworksFromDomain(List<Network> networks) {
        List<NetworkModel> networkModels = new ArrayList<>();
        networks.forEach(network -> {
            var networkModel = new NetworkModel(
                    new IPModel(network.getAddress().getIPAddress()),
                    network.getName(),
                    String.valueOf(network.getCidr())
            );
            networkModels.add(networkModel);
        });
        return networkModels;
    }
}
