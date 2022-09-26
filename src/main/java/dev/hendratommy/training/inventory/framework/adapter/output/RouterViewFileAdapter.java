package dev.hendratommy.training.inventory.framework.adapter.output;

import dev.hendratommy.training.inventory.domain.vo.RouterType;
import dev.hendratommy.training.inventory.application.port.output.RouterViewOutputPort;
import dev.hendratommy.training.inventory.domain.entity.Router;
import dev.hendratommy.training.inventory.domain.vo.RouterId;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RouterViewFileAdapter implements RouterViewOutputPort {
    private static RouterViewFileAdapter instance;

    private RouterViewFileAdapter() {}

    public static RouterViewFileAdapter getInstance() {
        if (instance == null) {
            synchronized (RouterViewFileAdapter.class) {
                instance = new RouterViewFileAdapter();
            }
        }
        return instance;
    }

    private List<Router> readFileAsString() {
        List<Router> routers = new ArrayList<>();
        try (Stream<String> stream = new BufferedReader(
                new InputStreamReader(
                        RouterViewFileAdapter.class.getClassLoader().
                                getResourceAsStream("routers.txt"))).lines()) {
            stream.forEach(line ->{
                String[] routerEntry = line.split(";");
                var id = routerEntry[0];
                var type = routerEntry[1];
                Router router = new Router(RouterType.valueOf(type), new RouterId(id));
                routers.add(router);
            });
            return routers;
        } catch (Exception e){
            throw new RuntimeException("Failed to read resource", e);
        }
    }

    @Override
    public List<Router> fetchRouters() {
        return readFileAsString();
    }
}
