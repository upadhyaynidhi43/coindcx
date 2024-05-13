package com.coindcx.validators;

import com.coindcx.pojos.CoinDcxObject;
import com.coindcx.pojos.CoinDcxResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.testng.Assert;

import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.List;

public class CoindcxValidators {

    public void validateCreatedObjectResponse(String respone, String name, String capacity, String generation, String price) {
        Assert.assertEquals(JsonPath.read(respone, "$.name"), name, "Assertion Failed :: Name is incorrect");
        Assert.assertEquals(JsonPath.read(respone, "$.data.generation"), generation, "Assertion Failed :: Generation is incorrect");
        Assert.assertEquals(JsonPath.read(respone, "$.data.price"), price, "Assertion Failed :: Price is incorrect");
        Assert.assertEquals(JsonPath.read(respone, "$.data.capacity"), capacity, "Assertion Failed :: Capacity is incorrect");
    }

    public void validateGetObjectResponse(String json, String id, String name, String capacity, String generation, String price) {

        Gson gson = new Gson();
        Type listType = new TypeToken<List<CoinDcxObject>>(){}.getType();
        List<CoinDcxObject> coinDcxObjects = gson.fromJson(json, listType);
        Assert.assertEquals(coinDcxObjects.get(0).getId(), id, "Assertion Failed :: Id is incorrect");
        Assert.assertEquals(coinDcxObjects.get(0).getName(), name, "Assertion Failed :: Name is incorrect");
        Assert.assertEquals(coinDcxObjects.get(0).getData().getGeneration(), generation, "Assertion Failed :: Generation is incorrect");
        Assert.assertEquals(coinDcxObjects.get(0).getData().getPrice(), price, "Assertion Failed :: Price is incorrect");
        Assert.assertEquals(coinDcxObjects.get(0).getData().getCapacity(), capacity, "Assertion Failed :: Capacity is incorrect");
    }

}
