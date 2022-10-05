package dev.hendratommy.training.inventory.framework.adapter.output;

import dev.hendratommy.training.inventory.application.port.output.RouterNetworkOutputPort;
import dev.hendratommy.training.inventory.domain.entity.Router;
import dev.hendratommy.training.inventory.domain.entity.Switch;
import dev.hendratommy.training.inventory.domain.vo.*;

import java.util.ArrayList;
import java.util.List;

public class RouterNetworkFileAdapter implements RouterNetworkOutputPort {
    private static RouterNetworkFileAdapter instance;
    private List<Router> routers = new ArrayList<>();

    private RouterNetworkFileAdapter() {
        createSampleRouter();
    }

    public static RouterNetworkFileAdapter getInstance() {
        if (instance == null) {
            synchronized (RouterNetworkFileAdapter.class) {
                instance = new RouterNetworkFileAdapter();
            }
        }
        return instance;
    }

    @Override
    public Router fetchRouterById(RouterId routerId) {
        Router retrievedRouter = null;
        for(Router router: routers){
            if(router.getRouterId().getId().equals(routerId.getId())){
                retrievedRouter = router;
                break;
            }
        }
        return retrievedRouter;
    }

    private void createSampleRouter() {
        var routerId = new RouterId("ca23800e-9b5a-11eb-a8b3-0242ac130003");
        var network = new Network(new IP("10.0.0.0"), "HR", 8);
        var networkSwitch = new Switch(SwitchType.LAYER3, new SwitchId(), List.of(network), new IP("9.0.0.9"));
        var router = new Router(RouterType.EDGE, routerId, networkSwitch);
        routers.add(router);
    }

    @Override
    public boolean persistRouter(Router router){
        return this.routers.add(router);
    }

}
