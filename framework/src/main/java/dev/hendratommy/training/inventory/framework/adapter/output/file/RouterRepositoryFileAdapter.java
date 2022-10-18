package dev.hendratommy.training.inventory.framework.adapter.output.file;

import dev.hendratommy.training.inventory.application.repository.RouterRepository;
import dev.hendratommy.training.inventory.domain.entity.Router;
import dev.hendratommy.training.inventory.domain.entity.Switch;
import dev.hendratommy.training.inventory.domain.vo.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RouterRepositoryFileAdapter implements RouterRepository {
    private static RouterRepositoryFileAdapter instance;
    private List<Router> routers = new ArrayList<>();

    private RouterRepositoryFileAdapter() {
        createSampleRouter();
    }

    public static RouterRepositoryFileAdapter getInstance() {
        if (instance == null) {
            synchronized (RouterRepositoryFileAdapter.class) {
                instance = new RouterRepositoryFileAdapter();
            }
        }
        return instance;
    }

    private List<Router> readFileAsString() {
        List<Router> routers = new ArrayList<>();
        try (Stream<String> stream = new BufferedReader(
                new InputStreamReader(
                        RouterRepositoryFileAdapter.class.getClassLoader().
                                getResourceAsStream("routers.txt"))).lines()) {
            stream.forEach(line -> {
                String[] routerEntry = line.split(";");
                var id = routerEntry[0];
                var type = routerEntry[1];
                Router router = new Router(new RouterId(id), RouterType.valueOf(type));
                routers.add(router);
            });
            return routers;
        } catch (Exception e) {
            throw new RuntimeException("Failed to read resource", e);
        }
    }

    @Override
    public List<Router> findAll() {
        return readFileAsString();
    }

    @Override
    public Router findById(RouterId routerId) {
        Router retrievedRouter = null;
        for(Router router: routers){
            if(router.getId().getUUID().equals(routerId.getUUID())){
                retrievedRouter = router;
                break;
            }
        }
        return retrievedRouter;
    }

    private void createSampleRouter() {
        var routerId = new RouterId("ca23800e-9b5a-11eb-a8b3-0242ac130003");
        var network = new Network(new IP("10.0.0.0"), "HR", 8);
        var networkSwitch = new Switch(new SwitchId(), SwitchType.LAYER3, List.of(network), new IP("9.0.0.9"));
        var router = new Router(routerId, RouterType.EDGE, networkSwitch);
        routers.add(router);
    }

    @Override
    public Router save(Router router){
        this.routers.add(router);
        return router;
    }
}
