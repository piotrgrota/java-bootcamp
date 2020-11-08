package com.sampler;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RulesWrapper {
    @SerializedName(value = "SamplingRuleRecords")
    private List<SamplingRule> rules;

    @SerializedName(value = "NextToken")
    private String nextToken;
}
