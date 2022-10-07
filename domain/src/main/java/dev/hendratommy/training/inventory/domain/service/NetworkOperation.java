package dev.hendratommy.training.inventory.domain.service;

import dev.hendratommy.training.inventory.domain.entity.Router;
import dev.hendratommy.training.inventory.domain.specification.CIDRSpecification;
import dev.hendratommy.training.inventory.domain.specification.NetworkAmountSpecification;
import dev.hendratommy.training.inventory.domain.specification.NetworkAvailabilitySpecification;
import dev.hendratommy.training.inventory.domain.specification.RouterTypeSpecification;
import dev.hendratommy.training.inventory.domain.vo.Network;

public class NetworkOperation {

    public static Router createNewNetwork(Router router, Network network) {
        var availabilitySpec = new NetworkAvailabilitySpecification(network.getAddress(), network.getName(), network.getCidr());
        var cidrSpec = new CIDRSpecification();
        var routerTypeSpec = new RouterTypeSpecification();
        var amountSpec = new NetworkAmountSpecification();

        if(cidrSpec.isSatisfiedBy(network.getCidr()))
            throw new IllegalArgumentException("CIDR is below "+CIDRSpecification.MINIMUM_ALLOWED_CIDR);

        if(!availabilitySpec.isSatisfiedBy(router))
            throw new IllegalArgumentException("Address already exist");

        if(amountSpec.and(routerTypeSpec).isSatisfiedBy(router)) {
            Network newNetwork = router.createNetwork(network.getAddress(), network.getName(), network.getCidr());
            router.addNetworkToSwitch(newNetwork);
        }
        return router;
    }
}
