package com.sampler;

import java.util.Date;

public class SamplingRule {


    private String ruleName;
    private int priority;
    private Double fixedRate;
    private int reservoirSize;
    private String host;
    private String hTTPMethod;
    private String uRLPath;

    private java.util.Date createdAt;
    private java.util.Date modifiedAt;

    public SamplingRule(String ruleName, int priority, Double fixedRate, int reservoirSize, String host, String hTTPMethod, String uRLPath, Date createdAt, Date modifiedAt) {
        this.ruleName = ruleName;
        this.priority = priority;
        this.fixedRate = fixedRate;
        this.reservoirSize = reservoirSize;
        this.host = host;
        this.hTTPMethod = hTTPMethod;
        this.uRLPath = uRLPath;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
