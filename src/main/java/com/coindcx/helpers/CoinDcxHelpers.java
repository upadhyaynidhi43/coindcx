package com.coindcx.helpers;

import com.coindcx.constants.CoinDcxEndpoints;
import com.coindcx.entities.CoindcxEntities;
import io.restassured.response.Response;

import java.util.HashMap;

import static com.coindcx.utils.BaseTest.*;

public class CoinDcxHelpers {

    CoindcxEntities coindcxEntities = new CoindcxEntities();

    /**
     * This method is to create an object
     *
     * @param name       name of the object to create
     * @param capacity   capacity of the object
     * @param generation generation of the object
     * @param price      price of the object
     * @return created object response
     * @throws Exception
     */
    public String createObject(String name, String capacity, String generation, String price) throws Exception {
        Response response = post(CoinDcxEndpoints.CREATE_AND_GET_OBJECT, coindcxEntities.payload(name, capacity, generation, price));
        if (response.getStatusCode() == 200) {
            return response.getBody().asString();

        }
        throw new Exception("Unable to create Object", new Exception(response.getBody().asString()));
    }

    /**
     * This method is to get object
     *
     * @param id created object id to be passed
     * @return the json response of searched id
     * @throws Exception
     */
    public String getAllObjects(String id) throws Exception {

        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("id", id);
        Response response = get(CoinDcxEndpoints.CREATE_AND_GET_OBJECT, queryParams);
        if (response.getStatusCode() == 200) {
            return response.getBody().asString();
        }
        throw new Exception("Unable to get All Objects", new Exception(response.getBody().asString()));

    }

    /**
     * This method is to delete an object
     *
     * @param id created object id to be passed
     * @return the json response of deleted id
     * @throws Exception
     */
    public String deleteObject(String id) throws Exception {
        Response response = delete(CoinDcxEndpoints.DELETE_OBJECT, "id", id);
        if (response.getStatusCode() == 200) {
            return response.getBody().asString();
        }
        throw new Exception("Unable to delete an Object", new Exception(response.getBody().asString()));
    }

}
