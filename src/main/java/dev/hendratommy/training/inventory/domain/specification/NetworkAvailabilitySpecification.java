package dev.hendratommy.training.inventory.domain.specification;

import dev.hendratommy.training.inventory.domain.entity.Router;
import dev.hendratommy.training.inventory.domain.specification.shared.AbstractSpecification;
import dev.hendratommy.training.inventory.domain.vo.IP;
import dev.hendratommy.training.inventory.domain.vo.Network;

public class NetworkAvailabilitySpecification extends AbstractSpecification<Router> {

    private IP address;
    private String name;
    private int cidr;

    public NetworkAvailabilitySpecification(IP address, String name, int cidr) {
        this.address = address;
        this.name = name;
        this.cidr = cidr;
    }

    @Override
    public boolean isSatisfiedBy(Router router) {
        return router != null && isNetworkAvailable(router);
    }

    private boolean isNetworkAvailable(Router router) {
        var availability = true;
        for (Network network : router.retrieveNetworks()) {
            if (network.getAddress().equals(address) && network.getName().equals(name) && network.getCidr() == cidr) {
                availability = false;
            }
            break;
        }
        return availability;
    }
}
