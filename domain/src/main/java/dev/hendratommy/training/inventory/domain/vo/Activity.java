package dev.hendratommy.training.inventory.domain.vo;

public class Activity {

    private final String srcHost;
    private final String dstHost;

    public Activity (String srcHost, String dstHost){
        this.srcHost = srcHost;
        this.dstHost = dstHost;
    }

    @Override
    public String toString() {
        return new StringBuilder("Activity{")
                .append("srcHost='").append(srcHost).append("'")
                .append(", dstHost='").append(dstHost).append("'")
                .append("}").toString();
    }
}
