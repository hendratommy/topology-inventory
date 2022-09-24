package dev.hendratommy.training.inventory;

import dev.hendratommy.training.inventory.framework.adapter.input.RouterViewCLIAdapter;

public class Main {
    public static void main(String... args) {
        var cli = new RouterViewCLIAdapter();
        var type = "CORE";
        System.out.println(cli.obtainRelatedRouters(type));

        System.out.println(cli.obtainRelatedRouters("EDGE"));
    }
}
