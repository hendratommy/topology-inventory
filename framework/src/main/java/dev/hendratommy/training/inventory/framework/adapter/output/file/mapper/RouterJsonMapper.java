package dev.hendratommy.training.inventory.framework.adapter.output.file.mapper;

import dev.hendratommy.training.inventory.domain.entity.Router;
import dev.hendratommy.training.inventory.domain.entity.Switch;
import dev.hendratommy.training.inventory.domain.vo.*;
import dev.hendratommy.training.inventory.framework.adapter.output.file.json.*;

import java.util.ArrayList;
import java.util.List;

public class RouterJsonMapper {
    public static Router toDomain(RouterJson routerJson) {
        var routerId = new RouterId(routerJson.getRouterId().toString());
        var routerType = RouterType.valueOf(routerJson.getRouterType().name());
        var switchId = new SwitchId(routerJson.getNetworkSwitch().getSwitchId().toString());
        var switchType = SwitchType.valueOf(routerJson.getNetworkSwitch().getSwitchType().toString());
        var ip = new IP(routerJson.getNetworkSwitch().getIp().getAddress());
        var networks = getNetworksFromJson(routerJson.getNetworkSwitch().getNetworks());

        var networkSwitch = new Switch(switchId, switchType, networks, ip);

        return new Router(routerId, routerType, networkSwitch);
    }

    public static RouterJson toJson(Router router) {
        var routerId = router.getId().getUUID();
        var routerTypeJson = RouterTypeJson.valueOf(router.getType().toString());
        var switchIdJson = router.getNetworkSwitch().getSwitchId().getUUID();
        var switchTypeJson = SwitchTypeJson.valueOf(router.getNetworkSwitch().getSwitchType().toString());
        var ipJson = new IPJson(router.getNetworkSwitch().getAddress().getIPAddress());
        var networkDataList = getNetworksFromDomain(router.retrieveNetworks());

        var switchModel = new SwitchJson(switchIdJson, ipJson, switchTypeJson, networkDataList);

        return new RouterJson(routerId, routerTypeJson, switchModel);
    }

    private static List<Network> getNetworksFromJson(List<NetworkJson> networkJsons) {
        List<Network> networks = new ArrayList<>();
        networkJsons.forEach(networkJson -> {
            var network = new Network(
                    new IP(networkJson.getIp().getAddress()),
                    networkJson.getNetworkName(),
                    Integer.valueOf(networkJson.getCidr()));
            networks.add(network);
        });
        return networks;
    }

    private static List<NetworkJson> getNetworksFromDomain(List<Network> networks) {
        List<NetworkJson> networkJsons = new ArrayList<>();
        networks.forEach(network -> {
            var networkModel = new NetworkJson(
                    new IPJson(network.getAddress().getIPAddress()),
                    network.getName(),
                    String.valueOf(network.getCidr())
            );
            networkJsons.add(networkModel);
        });
        return networkJsons;
    }
}
