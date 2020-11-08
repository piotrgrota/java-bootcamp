package com.sampler;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.StreamSupport;

public class ServiceConnector {


    private static String SAMPLE_RULES_URL = "/GetSamplingRules";
    private static String SAMPLE_TARGETS_URL = "/SamplingTargets";

    public void fetchRules(String endpoint) throws IOException, InterruptedException {
        CloseableHttpClient client = HttpClients.createDefault();
        GsonBuilder gsonBldr = new GsonBuilder();
        try {
            HttpPost httpPost = new HttpPost(endpoint + SAMPLE_RULES_URL);
            httpPost.setHeader("Content-type", "application/json");
            httpPost.setEntity( new StringEntity("{}"));

            CloseableHttpResponse response = client.execute(httpPost);
            String json = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
            JSONObject obj = new JSONObject(json);
            Type targetClassType = new TypeToken<ArrayList<SamplingRule>>() { }.getType();
            gsonBldr.setLenient();
            gsonBldr.registerTypeAdapter(SamplingRule.class, new SamplingRuleDeserializerFromJsonWithDifferentFields());
            String array =  obj.getJSONArray("SamplingRuleRecords").toString();
            RulesWrapper rules =  gsonBldr.create().fromJson(json, RulesWrapper.class);

            System.out.println("error");




            System.out.println(array);

        } finally {
            client.close();
        }

    }

}
