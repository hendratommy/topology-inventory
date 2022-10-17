package dev.hendratommy.training.inventory.framework.adapter.input.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class AddNetworkModel implements Serializable {
    @Serial
    private static final long serialVersionUID = -9174400330563327744L;

    @NotEmpty(message = "required")
    private String routerId;
    @NotEmpty(message = "required")
    private String address;
    @NotEmpty(message = "required")
    private String name;
    @NotNull(message = "required")
    @Min(1)
    @Max(32)
    private Integer cidr;

    public AddNetworkModel(String routerId, String address, String name, Integer cidr) {
        this.routerId = routerId;
        this.address = address;
        this.name = name;
        this.cidr = cidr;
    }

    public String getRouterId() {
        return routerId;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public int getCidr() {
        return cidr;
    }
}
