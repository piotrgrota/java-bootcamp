package com.sampler;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Date;

public class SamplingRuleDeserializerFromJsonWithDifferentFields implements JsonDeserializer<SamplingRule> {
    @Override
    public SamplingRule deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jObject = json.getAsJsonObject();

        JsonObject samplingRule = jObject.getAsJsonObject("SamplingRule");

        BigDecimal createdAt = jObject.get("CreatedAt").getAsBigDecimal();
        BigDecimal modifiedAt =  jObject.get("ModifiedAt").getAsBigDecimal();
        Date createdAtDate = new Date(createdAt.scaleByPowerOfTen(3).longValue());
        Date modifiedAtDate = new Date(modifiedAt.scaleByPowerOfTen(3).longValue());

        
        String ruleName = samplingRule.get("RuleName").getAsString();
        int priority =  samplingRule.get("Priority").getAsInt();
        double fixedRate = samplingRule.get("FixedRate").getAsDouble();
        int reservoirSize = samplingRule.get("ReservoirSize").getAsInt();
        String httpMethod = samplingRule.get("HTTPMethod").getAsString();
        String urlPath = samplingRule.get("URLPath").getAsString();
        String host = samplingRule.get("Host").getAsString();

        return new SamplingRule(ruleName, priority, fixedRate ,reservoirSize,
                host, httpMethod, urlPath, createdAtDate, modifiedAtDate);
    }
}
