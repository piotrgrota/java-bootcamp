package com.sampler;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class ConnectorTest {

    private static final String SAMPLING_RULES =
            "{\n"
                    + "    \"SamplingRuleRecords\": [\n"
                    + "        {\n"
                    + "            \"SamplingRule\": {\n"
                    + "                \"RuleName\": \"Default\",\n"
                    + "                \"RuleARN\": \"arn:aws:xray:us-east-1::sampling-rule/Default\",\n"
                    + "                \"ResourceARN\": \"*\",\n"
                    + "                \"Priority\": 10000,\n"
                    + "                \"FixedRate\": 0.01,\n"
                    + "                \"ReservoirSize\": 0,\n"
                    + "                \"ServiceName\": \"*\",\n"
                    + "                \"ServiceType\": \"*\",\n"
                    + "                \"Host\": \"*\",\n"
                    + "                \"HTTPMethod\": \"*\",\n"
                    + "                \"URLPath\": \"*\",\n"
                    + "                \"Version\": 1,\n"
                    + "                \"Attributes\": {}\n"
                    + "            },\n"
                    + "            \"CreatedAt\": 0.0,\n"
                    + "            \"ModifiedAt\": 1530558121.0\n"
                    + "        },\n"
                    + "        {\n"
                    + "            \"SamplingRule\": {\n"
                    + "                \"RuleName\": \"base-scorekeep\",\n"
                    + "                \"RuleARN\": \"arn:aws:xray:us-east-1::sampling-rule/base-scorekeep\",\n"
                    + "                \"ResourceARN\": \"*\",\n"
                    + "                \"Priority\": 9000,\n"
                    + "                \"FixedRate\": 0.1,\n"
                    + "                \"ReservoirSize\": 2,\n"
                    + "                \"ServiceName\": \"Scorekeep\",\n"
                    + "                \"ServiceType\": \"*\",\n"
                    + "                \"Host\": \"*\",\n"
                    + "                \"HTTPMethod\": \"*\",\n"
                    + "                \"URLPath\": \"*\",\n"
                    + "                \"Version\": 1,\n"
                    + "                \"Attributes\": {}\n"
                    + "            },\n"
                    + "            \"CreatedAt\": 1530573954.0,\n"
                    + "            \"ModifiedAt\": 1530920505.0\n"
                    + "        },\n"
                    + "        {\n"
                    + "            \"SamplingRule\": {\n"
                    + "                \"RuleName\": \"polling-scorekeep\",\n"
                    + "                \"RuleARN\": \"arn:aws:xray:us-east-1::sampling-rule/polling-scorekeep\",\n"
                    + "                \"ResourceARN\": \"*\",\n"
                    + "                \"Priority\": 5000,\n"
                    + "                \"FixedRate\": 0.003,\n"
                    + "                \"ReservoirSize\": 0,\n"
                    + "                \"ServiceName\": \"Scorekeep\",\n"
                    + "                \"ServiceType\": \"*\",\n"
                    + "                \"Host\": \"*\",\n"
                    + "                \"HTTPMethod\": \"GET\",\n"
                    + "                \"URLPath\": \"/api/state/*\",\n"
                    + "                \"Version\": 1,\n"
                    + "                \"Attributes\": {}\n"
                    + "            },\n"
                    + "            \"CreatedAt\": 1530918163.0,\n"
                    + "            \"ModifiedAt\": 1530918163.0\n"
                    + "        }\n"
                    + "    ]\n"
                    + "}";
    @Rule
    public WireMockRule wireMockRule = new WireMockRule(20022);


    @Test
    public void giveRequest_then_should_read_response() throws IOException, InterruptedException {
        stubFor(post(urlEqualTo("/GetSamplingRules"))
                .willReturn(aResponse().withBody(SAMPLING_RULES).withStatus(200)));
        ServiceConnector connector = new ServiceConnector();
        connector.fetchRules("http://localhost:20022");

    }

}
