package dev.hendratommy.training.inventory.framework.adapter.input.cli;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.hendratommy.training.inventory.application.usecase.RouterNetworkUseCase;
import dev.hendratommy.training.inventory.domain.entity.Router;
import dev.hendratommy.training.inventory.domain.vo.IP;
import dev.hendratommy.training.inventory.domain.vo.Network;
import dev.hendratommy.training.inventory.domain.vo.RouterId;
import dev.hendratommy.training.inventory.framework.adapter.output.mapper.RouterModelMapper;
import io.quarkus.logging.Log;

import java.util.HashMap;

public class RouterNetworkCliAdapter {
    private final RouterNetworkUseCase routerNetworkUseCase;

    public RouterNetworkCliAdapter(RouterNetworkUseCase routerNetworkUseCase) {
        this.routerNetworkUseCase = routerNetworkUseCase;
    }

    public Router addNetwork(RouterId routerId, Network network) {
        return routerNetworkUseCase.addNetworkToRouter(routerId, network);
    }

    public Router run(String... args) {
        if (args.length == 8) {
            try {
                var params = new HashMap<String, String>();
                for (int i = 0; i < args.length; i+=2) {
                    switch (args[i]) {
                        case "-r":
                            params.put("routerId", args[i+1]);
                            break;
                        case "-i":
                            params.put("address", args[i+1]);
                            break;
                        case "-n":
                            params.put("name", args[i+1]);
                            break;
                        case "-c":
                            params.put("cidr", args[i+1]);
                            break;
                        default:
                            throw new IllegalArgumentException("Unrecognized argument: " + args[i]);
                    }
                }

                if (params.size() != 4) {
                    throw new IllegalArgumentException("Required 4 arguments");
                }

                var routerId = new RouterId(params.get("routerId"));
                var network = new Network(new IP(params.get("address")), params.get("name"), Integer.valueOf(params.get("cidr")));
                var router = addNetwork(routerId, network);

                var mapper = new ObjectMapper();
                var routerJson = mapper.writeValueAsString(RouterModelMapper.toJson(router));
                Log.info(routerJson);

                return router;
            } catch (IllegalArgumentException e) {
                Log.error(e.getMessage());
                throw e;
            } catch (JsonProcessingException e) {
                Log.error(e.getMessage());
                throw new RuntimeException(e);
            }
        } else {
            Log.info("Usage: -r [ROUTER-ID] -i [IP-ADDRESS] -n [NETWORK-NAME] -c [CIDR]");
            throw new IllegalArgumentException("Usage: -r [ROUTER-ID] -i [IP-ADDRESS] -n [NETWORK-NAME] -c [CIDR]");
        }
    }
}
